package org.ericampire.android.demoapp.app.di

import org.ericampire.android.demoapp.FactViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { FactViewModel() }
}