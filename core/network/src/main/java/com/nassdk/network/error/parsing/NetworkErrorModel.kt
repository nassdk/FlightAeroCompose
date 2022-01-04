package com.nassdk.network.error.parsing

import kotlinx.serialization.SerialName

data class NetworkErrorModel(
    @SerialName(value = "code") val code: Int,
    @SerialName(value = "message") val message: String
)