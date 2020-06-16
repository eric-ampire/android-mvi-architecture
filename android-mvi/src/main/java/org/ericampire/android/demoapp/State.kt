package org.ericampire.android.demoapp

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.Uninitialized


data class State(
    val users: Async<List<User>> = Uninitialized,
    val isRefreshButtonEnabled: Boolean = false
) : MvRxState