package com.nassdk.network.interceptor

import dagger.Reusable
import javax.inject.Inject
import okhttp3.Interceptor
import okhttp3.Response

@Reusable
internal class CredentialsInterceptor @Inject constructor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.proceed(chain.request())
    }
}