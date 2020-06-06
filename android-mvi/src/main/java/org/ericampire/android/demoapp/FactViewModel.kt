package org.ericampire.android.demoapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.ericampire.android.demoapp.architecture.Model

class FactViewModel() : ViewModel(), Model<State, HomeUserIntent> {

    private val _state = MutableLiveData<State>()
    override val state: LiveData<State>
        get() = _state

    override fun dispatchIntent(intent: HomeUserIntent) {

    }
}