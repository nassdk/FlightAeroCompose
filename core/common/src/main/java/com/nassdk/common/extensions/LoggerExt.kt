package com.nassdk.common.extensions

import timber.log.Timber

private const val DEFAULT_TAG = "AIR_INFO_LOG_TAG"

fun debugLog(message: String) {
    Timber.tag(DEFAULT_TAG).d(message)
}

fun errorLog(message: String) {
    Timber.tag(DEFAULT_TAG).e(message)
}