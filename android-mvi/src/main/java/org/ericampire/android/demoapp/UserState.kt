package org.ericampire.android.demoapp


import org.ericampire.android.demoapp.app.arch.IState
import org.ericampire.android.demoapp.model.User


data class UserState(
    val users: List<User> = listOf(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null
) : IState