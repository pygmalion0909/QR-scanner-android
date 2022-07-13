package com.isolution.qrscanner.api

import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IRetrofit {

  @GET("/api/users?page=2")
  fun searchPhotos(@Query("query") searchTerm: String) : Call<JsonElement>
  fun searchUsers()

}