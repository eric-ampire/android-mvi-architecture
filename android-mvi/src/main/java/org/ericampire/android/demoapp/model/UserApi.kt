package org.ericampire.android.demoapp.model

import retrofit2.http.GET

interface UserApi {

    @GET("users")
    suspend fun getUser(): List<User>
}