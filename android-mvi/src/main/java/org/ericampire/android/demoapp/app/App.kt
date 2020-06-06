package org.ericampire.android.demoapp.app

import android.app.Application
import org.ericampire.android.demoapp.app.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        configureKoin()
    }

    private fun configureKoin() {
        startKoin {
            modules(
                viewModelModule
            )
            androidContext(this@App)
        }
    }
}