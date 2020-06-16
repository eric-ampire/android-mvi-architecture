package org.ericampire.android.demoapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.airbnb.mvrx.Async
import com.airbnb.mvrx.BaseMvRxViewModel
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.Success
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import org.ericampire.android.demoapp.app.di.UserApi
import org.koin.core.KoinComponent
import org.koin.core.inject




class FactViewModel(state: State) : BaseMvRxViewModel<State>(state, debugMode = true), KoinComponent {

    private val api by inject<UserApi>()

    private val coroutineContext = SupervisorJob() + Dispatchers.IO
    private val coroutineScope = CoroutineScope(coroutineContext)

    init {
        fetchDate()
    }

    private fun fetchDate() {
        setState { copy(isRefreshButtonEnabled = false) }
        coroutineScope.launch {
            val data = api.getUser()
            setState { copy(users = Success(data), isRefreshButtonEnabled = true) }
        }
    }

    fun refreshData() {
        fetchDate()
    }

}