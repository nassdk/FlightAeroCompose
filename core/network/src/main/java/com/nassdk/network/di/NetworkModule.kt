package com.nassdk.network.di

import com.nassdk.di.scopes.NetworkScope
import com.nassdk.network.BuildConfig
import com.nassdk.network.NetworkApi
import com.nassdk.network.NetworkApiImpl
import com.nassdk.network.interceptor.CredentialsInterceptor
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Reusable
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

@Module
internal abstract class NetworkModule {

    @Binds
    @NetworkScope
    abstract fun bindModuleApi(impl: NetworkApiImpl): NetworkApi

    companion object {

        @Provides
        @Reusable
        fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            return interceptor
        }

        @Provides
        @Reusable
        fun provideOkHttp3(
            loggingInterceptor: HttpLoggingInterceptor,
            credentialsInterceptor: CredentialsInterceptor,
        ): OkHttpClient = OkHttpClient.Builder().apply {
            if (BuildConfig.DEBUG) {
                addInterceptor(loggingInterceptor)
            }
            addInterceptor(credentialsInterceptor)
        }.build()


        @Provides
        @Reusable
        fun provideJson(): Json {
            return Json(Json.Default) {
                isLenient = true
                ignoreUnknownKeys = true
            }
        }
    }
}