package com.nassdk.di

fun interface ModuleDependencyProvider<out T> {
    fun getDependencies(): T
}