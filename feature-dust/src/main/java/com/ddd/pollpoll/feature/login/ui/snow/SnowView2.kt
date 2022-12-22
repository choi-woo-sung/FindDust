package com.ddd.pollpoll.feature.login.ui.snow

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import kotlinx.coroutines.isActive
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.roundToInt
import kotlin.math.sin
import kotlin.time.Duration.Companion.nanoseconds

internal fun Modifier.snowfall2() = composed {
    // 변경이 되면 recomposition이 예약된다.
    var snowflakesState2 by remember {
        mutableStateOf(SnowflakesState2(-1, IntSize(0, 0)))
    }

    // 한번만 실행
    LaunchedEffect(Unit) {
        // composable이 끝나지 않는이상 이녀석은 죽지않음.
        while (isActive) {
            // 나노프레임마다 delay된다.
            withFrameNanos { newTick ->
                val elapsedMillis =
                    (newTick - snowflakesState2.tickNanos).nanoseconds.inWholeMilliseconds
                val wasFirstRun = snowflakesState2.tickNanos < 0
                // 업데이트되면 해당값을 포함하는 composable을 업데이트 시킨
                snowflakesState2.tickNanos = newTick

                if (wasFirstRun) return@withFrameNanos
                for (snowflake in snowflakesState2.snowflakes) {
                    snowflake.update(elapsedMillis)
                }
            }
        }
    }

    // 화면 사이즈가 바뀔때마다 눈의
    onSizeChanged { newSize -> snowflakesState2 = snowflakesState2.resize(newSize) }
        .clipToBounds()
        .drawWithContent {
            Log.d("snow", "drawWithContent")
            // drawContent()는 반드시 호출 해야함.
            drawContent()
            snowflakesState2.draw(drawContext.canvas)
        }
}

// 빽빽도
private const val snowflakeDensity = 0.01
private val incrementRange = 0.4f..0.8f
private val sizeRange = 5.0f..12.0f
private const val angleSeed = 25.0f
private val angleSeedRange = -angleSeed..angleSeed
private const val angleRange = 0.1f
private const val angleDivisor = 10000.0f

internal data class SnowflakesState(
    var tickNanos: Long,
    val snowflakes: List<Snowflake2>
) {

    constructor(tick: Long, canvasSize: IntSize) : this(tick, createSnowflakes(canvasSize))

    fun draw(canvas: Canvas) {
        val path = Path()
        snowflakes.forEach {
            path.asAndroidPath().let { path ->
                path.addCircle(
                    it.position.x,
                    it.position.y,
                    it.size,
                    android.graphics.Path.Direction.CW
                )
            }
        }
        canvas.drawPath(path, snowflakePaint)
//        snowflakes.forEach { it.draw(canvas) }
    }

    fun resize(newSize: IntSize): SnowflakesState {
        Log.d("Snow", "resize: $newSize")
        return copy(snowflakes = createSnowflakes(newSize))
    }

    companion object {

        private fun createSnowflakes(canvasSize: IntSize): List<Snowflake2> {
            val canvasArea = canvasSize.width * canvasSize.height
            val normalizedDensity = snowflakeDensity.coerceIn(0.0..1.0) / 1000.0
            val snowflakesCount = (canvasArea * normalizedDensity).roundToInt()

            return List(snowflakesCount) {
                Snowflake2(
                    incrementFactor = incrementRange.random(),
                    size = sizeRange.random(),
                    canvasSize = canvasSize,
                    position = canvasSize.randomPosition(),
                    angle = angleSeed.random() / angleSeed * angleRange + (PI / 2.0) - (angleRange / 2.0)
                )
            }
        }
    }
}

private val snowflakePaint = Paint().apply {
    isAntiAlias = true
    color = Color.White
    style = PaintingStyle.Fill
}


class Snowflake2(
    val size: Float,
    var position : Offset,
    private val canvasSize: IntSize
){
    fun update() {
        // y포지션이 height+size보다 낮아질때, 다시 위로 올린다.
        if (position.y > canvasSize.height + size) {
            position = Offset(position.x, -size)
        }
    }
}

//internal class Snowflake2(
//    private val incrementFactor: Float,
//    val size: Float,
//    private val canvasSize: IntSize,
//    position: Offset,
//    angle: Double
//) {
//
//    var position by mutableStateOf(position)
//    private var angle by mutableStateOf(angle)
//
//    fun update(elapsedMillis: Long) {
//        // 초마다 움직이는 증가량
//        val increment =
//            incrementFactor * (elapsedMillis / baseFrameDurationMillis) * baseSpeedPxAt60Fps
//
//        val xDelta = (increment * cos(angle)).toFloat()
//
//        val yDelta = (increment * sin(angle)).toFloat()
//        position = Offset(position.x + xDelta, position.y + yDelta)
//        // 각도가 계속 바뀐다.
//        angle += angleSeedRange.random() / angleDivisor
//
//        // y포지션이 height+size보다 낮아질때, 다시 위로 올린다.
//        if (position.y > canvasSize.height + size) {
//            position = Offset(position.x, -size)
//        }
//    }

    fun draw(canvas: Canvas) {
        canvas.drawCircle(position, size, snowflakePaint)
    }

    companion object {

        private const val baseFrameDurationMillis = 16f
        private const val baseSpeedPxAt60Fps = 2f
    }
}

@Preview
@Composable
fun a2() {
    Surface(modifier = Modifier.fillMaxSize().snowfall2(), color = Color.Black) {
    }
}
