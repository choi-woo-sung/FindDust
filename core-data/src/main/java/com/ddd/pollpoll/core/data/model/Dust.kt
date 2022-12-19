package com.ddd.pollpoll.core.data.model

import com.ddd.pollpoll.core.database.DustEntity
import com.ddd.pollpoll.network.model.Item

fun Item.asEntity() = DustEntity(
    coFlag = coFlag,
    coGrade = coGrade,
    coValue = coValue,
    dataTime = dataTime,
    khaiGrade = khaiGrade,
    khaiValue = khaiValue,
    no2Flag = no2Flag,
    no2Grade = no2Grade,
    no2Value = no2Value,
    o3Flag = o3Flag,
    o3Grade = o3Grade,
    o3Value = o3Value,
    pm10Flag = pm10Flag,
    pm10Grade = pm10Grade,
    pm10Value = pm10Value,
    sidoName = sidoName,
    so2Flag = so2Flag,
    so2Grade = so2Grade,
    so2Value = so2Value,
    stationName = stationName

)
