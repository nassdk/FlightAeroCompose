package com.nassdk.aero.di

import com.nassdk.aero.AppActivity
import com.nassdk.common.di.BaseComponent
import dagger.Component

@Component(modules = [AppModule::class], dependencies = [BaseComponent::class])
@AppScope
interface AppComponent : BaseComponent {

    @Component.Factory
    interface Factory {
        fun create(baseComponent: BaseComponent): AppComponent
    }

    fun inject(app: AppActivity)
}