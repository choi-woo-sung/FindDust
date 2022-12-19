/*
 * Copyright (C) 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ddd.pollpoll.core.database

import androidx.room.Dao
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Update

@Entity
data class DustEntity(
    val coFlag: String,
    val coGrade: String,
    val coValue: String,
    val dataTime: String,
    val khaiGrade: String,
    val khaiValue: String,
    val no2Flag: String,
    val no2Grade: String,
    val no2Value: String,
    val o3Flag: String,
    val o3Grade: String,
    val o3Value: String,
    val pm10Flag: String,
    val pm10Grade: String,
    val pm10Value: String,
    val sidoName: String,
    val so2Flag: String,
    val so2Grade: String,
    val so2Value: String,
    @PrimaryKey
    val stationName: String
)

@Dao
interface DustDao {
//    @Query("SELECT * FROM login ORDER BY uid DESC LIMIT 10")
//    fun getLogins(): Flow<List<Login>>

    @Update
    suspend fun updateDust(item: DustEntity)
}
