package org.ericampire.android.demoapp

import org.ericampire.android.demoapp.architecture.UserIntent

sealed class HomeUserIntent : UserIntent {
    class ShowNewFact(val categoryId: String?) : HomeUserIntent()
    object ClearFact : HomeUserIntent()
}