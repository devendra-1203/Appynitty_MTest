package com.example.appynitty

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface GetAPI {
   @GET("data/v1/user")
   suspend fun getData(@Header("app-id") header: String, @Query("limit") limit : Int ): GetResponse
}