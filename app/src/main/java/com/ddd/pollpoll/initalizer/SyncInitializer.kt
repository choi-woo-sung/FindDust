/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ddd.pollpoll.initalizer

import android.content.Context
import android.util.Log
import androidx.startup.AppInitializer
import androidx.startup.Initializer
import androidx.work.Configuration
import androidx.work.WorkManager
import androidx.work.WorkManagerInitializer
import com.ddd.pollpoll.BuildConfig
import com.ddd.pollpoll.module.WorkManagerInitializerEntryPoint
import dagger.hilt.android.EntryPointAccessors

internal const val SyncWorkName = "SyncWorkName"

object Sync {

    fun initialize(context: Context) {
        AppInitializer.getInstance(context)
            .initializeComponent(SyncInitializer::class.java)
    }
}

class SyncInitializer : Initializer<WorkManager> {

    override fun create(context: Context): WorkManager {
        val entryPoint = EntryPointAccessors.fromApplication(
            context,
            WorkManagerInitializerEntryPoint::class.java
        )

        val configuration = Configuration
            .Builder()
            .setWorkerFactory(entryPoint.hiltWorkerFactory())
            .setMinimumLoggingLevel(if (BuildConfig.DEBUG) Log.DEBUG else Log.INFO)
            .build()
        WorkManager.initialize(context, configuration)
        return WorkManager.getInstance(context)
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}
