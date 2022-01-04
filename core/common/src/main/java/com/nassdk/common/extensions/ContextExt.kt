package com.nassdk.common.extensions

import android.content.Context
import com.nassdk.common.base.BaseApplication
import com.nassdk.common.di.BaseComponent

val Context.baseComponent: BaseComponent
    get() = when (this) {
        is BaseApplication -> baseComponent
        else -> applicationContext.baseComponent
    }