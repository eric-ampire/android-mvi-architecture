package org.ericampire.android.demoapp.architecture

import androidx.lifecycle.LiveData

interface Model<S: ViewState, I: UserIntent> {
    val state: LiveData<S>
    fun dispatchIntent(intent: I)
}