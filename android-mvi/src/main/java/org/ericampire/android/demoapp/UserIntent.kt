package org.ericampire.android.demoapp

import org.ericampire.android.demoapp.app.arch.IIntent

sealed class UserIntent : IIntent {
    object RefreshUsers : UserIntent()
    object FetchUsers : UserIntent()
}

