package com.nassdk.aero

import com.nassdk.aero.model.AppEvent
import com.nassdk.aero.model.AppState
import com.nassdk.common.base.BaseViewModel
import javax.inject.Inject

class AppViewModel @Inject constructor() : BaseViewModel<AppState, AppEvent>(
    initialState = AppState()
) {
    override fun observe(event: AppEvent) = Unit
}