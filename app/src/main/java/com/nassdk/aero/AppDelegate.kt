package com.nassdk.aero

import com.nassdk.aero.di.DaggerAppComponent
import com.nassdk.common.base.BaseApplication

class AppDelegate : BaseApplication() {

    init {
        app = this
    }

    val appComponent by lazy {
        DaggerAppComponent.factory().create(baseComponent = baseComponent)
    }

    companion object {
        lateinit var app: AppDelegate
    }
}