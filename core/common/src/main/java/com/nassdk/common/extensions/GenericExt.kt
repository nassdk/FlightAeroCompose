package com.nassdk.common.extensions

fun <T> T?.ifNull(alternative: T): T = this ?: alternative