package com.nassdk.network

interface NetworkApi {

    /**
     * Предоставление апи класса для остальных фичей
     */
    fun <T> provideApiClass(interfaceClass: Class<T>): T

//    /**
//     * Предоставление маппера ошибок для остальных фичей
//     */
//    fun provideErrorWrapper(): ErrorWrapper
}