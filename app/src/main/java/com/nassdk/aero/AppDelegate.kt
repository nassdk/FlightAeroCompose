package com.nassdk.aero

import com.nassdk.aero.di.DaggerAppComponent
import com.nassdk.common.base.BaseApplication
import io.realm.Realm

class AppDelegate : BaseApplication() {

    init {
        app = this
    }

    val appComponent by lazy {
        DaggerAppComponent.factory().create(baseComponent = baseComponent)
    }

    override fun onCreate() {
        super.onCreate()
        initRealm()
    }

    private fun initRealm() {
        Realm.init(this)
    }

    companion object {
        lateinit var app: AppDelegate
    }
}