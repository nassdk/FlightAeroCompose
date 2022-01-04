package com.nassdk.common.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(modules = [BaseModule::class])
@Singleton
interface BaseComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): BaseComponent
    }
}