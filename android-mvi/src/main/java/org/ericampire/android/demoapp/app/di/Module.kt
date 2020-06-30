package org.ericampire.android.demoapp.app.di

import okhttp3.OkHttpClient
import org.ericampire.android.demoapp.model.User
import org.ericampire.android.demoapp.model.UserApi
import org.ericampire.android.demoapp.viewmodel.UserViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

val netModule = module {
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .build()
    }
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .client(client)
            .build()
    }

    single { provideOkHttpClient() }
    single { provideRetrofit(get()) }
}

val viewModelScope = module {
    viewModel { UserViewModel(get()) }
}

val apiModule = module {
    fun provideUserApi(retrofit: Retrofit): UserApi {
        return retrofit.create(UserApi::class.java)
    }

    single { provideUserApi(get()) }
}