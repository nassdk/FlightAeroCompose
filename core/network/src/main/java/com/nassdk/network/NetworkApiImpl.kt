package com.nassdk.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Lazy
import javax.inject.Inject
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit

internal class NetworkApiImpl @Inject constructor() : NetworkApi {

    init {
        NetworkWrapper.getComponent().inject(this)
    }

    @Inject lateinit var json: Lazy<Json>
    @Inject lateinit var okhttp3Client: Lazy<OkHttpClient>
//    @Inject lateinit var errorWrapper: Lazy<ErrorWrapper>

    override fun <T> provideApiClass(interfaceClass: Class<T>): T {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okhttp3Client.get())
            .addConverterFactory(json.get().asConverterFactory("application/json".toMediaType()))
            .build()
            .create(interfaceClass)
    }

//    override fun provideErrorWrapper(): ErrorWrapper {
//        return errorWrapper.get()
//    }

    private companion object {
        private const val BASE_URL = "" //TODO
    }
}