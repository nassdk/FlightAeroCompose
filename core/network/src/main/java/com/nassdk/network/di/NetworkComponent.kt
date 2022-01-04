package com.nassdk.network.di

import com.nassdk.di.scopes.NetworkScope
import com.nassdk.network.NetworkApi
import com.nassdk.network.NetworkApiImpl
import dagger.Component

@NetworkScope
@Component(modules = [NetworkModule::class])
internal interface NetworkComponent {
    @Component.Factory
    interface Factory {

        fun create(): NetworkComponent
    }

    fun inject(apiImpl: NetworkApiImpl)

    fun moduleApi(): NetworkApi
}