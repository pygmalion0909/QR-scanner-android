package com.isolution.qrscanner.api

import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.http.*
import java.util.*
import kotlin.collections.HashMap

interface IRetrofit {

  @GET("/api/users?page=2")
  fun searchPhotos(@Query("query") searchTerm: String) : Call<JsonElement>

  @Headers("Authorization: ")
  @POST("/api/v1/commutes")
  fun insertCommute(@Body params: HashMap<String, Any>) : Call<JsonElement>

}