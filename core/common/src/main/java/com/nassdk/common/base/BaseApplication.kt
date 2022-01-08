package com.nassdk.common.base

import android.app.Application
import com.nassdk.common.di.DaggerBaseComponent
import com.nassdk.network.BuildConfig
import timber.log.Timber

abstract class BaseApplication : Application() {

    init {
        app = this
    }

    val baseComponent by lazy {
        DaggerBaseComponent.factory().create(context = this)
    }

    override fun onCreate() {
        super.onCreate()

        initTimber()
    }

    private fun initTimber() {

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    companion object {
        lateinit var app: BaseApplication
    }
}