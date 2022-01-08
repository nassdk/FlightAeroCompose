package com.nassdk.network.interceptor

import dagger.Reusable
import javax.inject.Inject
import okhttp3.Interceptor
import okhttp3.Response

@Reusable
internal class CredentialsInterceptor @Inject constructor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val newUrl = chain.request().url.newBuilder()
            .addQueryParameter(ACCESS_KEY, ACCESS_KEY_VALUE)
            .build()

        val newRequest = chain.request()
            .newBuilder()
            .url(newUrl)
            .build()

        return chain.proceed(newRequest)
    }

    private companion object {
        private const val ACCESS_KEY = "access_key"
        private const val ACCESS_KEY_VALUE = "7a6954d7972657346601e88e53e446df"
    }
}