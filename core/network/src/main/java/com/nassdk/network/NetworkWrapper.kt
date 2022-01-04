package com.nassdk.network

import com.nassdk.network.di.DaggerNetworkComponent
import com.nassdk.network.di.NetworkComponent

object NetworkWrapper {

    private var component: NetworkComponent? = null

    fun getApi(): NetworkApi = getComponent().moduleApi()

    internal fun getComponent(): NetworkComponent =
        component ?: run {
            component = DaggerNetworkComponent.factory().create()

            requireNotNull(component)
        }
}