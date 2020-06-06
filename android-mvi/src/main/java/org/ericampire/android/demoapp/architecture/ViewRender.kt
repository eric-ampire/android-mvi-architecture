package org.ericampire.android.demoapp.architecture

interface ViewRender<T: ViewState> {
    fun render(state: T)
}

