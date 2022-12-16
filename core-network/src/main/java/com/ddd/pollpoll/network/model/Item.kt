package com.ddd.pollpoll.network.model


/**
 * TODO
 *
 * @property coFlag  일산화 탄소 플래그
 * @property coGrade 일산화 탄소 지수
 * @property coValue 일산화 탄소 농도
 * @property dataTime 측정 일시
 * @property khaiGrade 통합 대기환경 수치
 * @property khaiValue 통합 대기환경 지수
 * @property no2Flag
 * @property no2Grade
 * @property no2Value
 * @property o3Flag
 * @property o3Grade 오존지수
 * @property o3Value 오존 농도
 * @property pm10Flag
 * @property pm10Grade
 * @property pm10Value
 * @property sidoName
 * @property so2Flag 아상산 가스 플래그
 * @property so2Grade 아상산 가스 지수
 * @property so2Value 아황산 가스 농도
 * @property stationName
 */
data class Item(
    val coFlag: String,
    val coGrade: String,
    val coValue: String,
    val dataTime: String,
    val khaiGrade: String,
    val khaiValue: String,
    val no2Flag: Any,
    val no2Grade: String,
    val no2Value: String,
    val o3Flag: Any,
    val o3Grade: String,
    val o3Value: String,
    val pm10Flag: Any,
    val pm10Grade: String,
    val pm10Value: String,
    val sidoName: String,
    val so2Flag: Any,
    val so2Grade: String,
    val so2Value: String,
    val stationName: String
)
