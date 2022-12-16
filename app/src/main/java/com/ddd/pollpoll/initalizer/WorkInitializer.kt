package com.ddd.pollpoll.initalizer

import android.content.Context
import androidx.startup.Initializer

import timber.log.Timber

class WorkInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        if (BuildConfig.DEBUG) {
            Timber.plant(DustDebugTree())
            Timber.d("timber Initalized")
        }
    }

    override fun dependencies(): MutableList<Class<out Initializer<*>>> {
        return mutableListOf()
    }
}
