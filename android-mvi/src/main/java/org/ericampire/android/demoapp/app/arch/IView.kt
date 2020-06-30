package org.ericampire.android.demoapp.app.arch

interface IView<S: IState> {
    fun render(state: S)
}