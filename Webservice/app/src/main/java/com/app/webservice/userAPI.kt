package com.app.webservice

import retrofit2.Call
import retrofit2.http.GET

interface userAPI {

        @GET("users")
        fun getUsers(): Call<List<User>>


        @GET("users/1")
        fun getUser(): Call<User>
}