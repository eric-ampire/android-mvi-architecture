package org.ericampire.android.demoapp.app

import android.app.Application
import org.ericampire.android.demoapp.app.di.apiModule
import org.ericampire.android.demoapp.app.di.netModule
import org.ericampire.android.demoapp.app.di.viewModelScope
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        configureKoin()
    }

    private fun configureKoin() {
        startKoin {
            androidContext(this@App)
            modules(netModule, apiModule, viewModelScope)
        }
    }
}