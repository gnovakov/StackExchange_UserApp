package com.gnova.stackexchange_userapp.api

import com.gnova.stackexchange_userapp.api.models.UserResult
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface StackApi {

    @GET("2.2/users")
    fun getUsers(
        @Query("page") page: Int,
        @Query("pagesize") pagesize: Int,
        @Query("order") order: String,
        @Query("sort") sort: String,
        @Query("inname") inname: String,
        @Query("site") site: String
    ): Deferred<UserResult>

}

