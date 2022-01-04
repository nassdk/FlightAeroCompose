package com.nassdk.common.extensions

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@Composable
@Suppress("UNCHECKED_CAST")
inline fun <reified VM : ViewModel> composeViewModel(
    key: String? = null,
    crossinline viewModelInstanceCreator: () -> VM,
): VM =
    androidx.lifecycle.viewmodel.compose.viewModel(
        modelClass = VM::class.java,
        key = key,
        factory = object : ViewModelProvider.Factory {
            override fun <VM : ViewModel> create(modelClass: Class<VM>): VM {
                return viewModelInstanceCreator() as VM
            }
        }
    )