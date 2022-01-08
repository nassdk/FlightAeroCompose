package com.nassdk.aero.mediators

import androidx.annotation.MainThread
import com.nassdk.network.NetworkApi
import com.nassdk.network.NetworkWrapper

class NetworkMediator {

    @MainThread
    fun getApi(): NetworkApi = NetworkWrapper.getApi()
}