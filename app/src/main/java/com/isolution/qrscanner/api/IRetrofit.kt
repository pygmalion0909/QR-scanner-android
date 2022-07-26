package com.isolution.qrscanner.api

import com.google.gson.JsonElement
import com.isolution.qrscanner.ResponseData
import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.*
import java.util.*
import kotlin.collections.HashMap

interface IRetrofit {

  @Headers(
    "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzdXBlcnBpbCIsImp0aSI6IjQxNDIwOTQzLTY5YTItNDFhMS1hOGJkLTBhMDQwYWRhZjVjOCIsImh0dHBzOi8vaXRlY2guY29tL2p3dF9jbGFpbXMiOnRydWUsImlhdCI6MTY1ODcyODU0NSwiZXhwIjoxNjU4NzY0NTQ1fQ.k3o2j2XSh3AxyP57mUznDACKmeNhf3URqVnQHvsWvLI"
  )
  @GET("/api/v1/day-off/remaining")
  fun searchPhotos(@Query("query") searchTerm: String) : Call<JsonElement>

  @POST("/api/v1/commutes")
  fun insertCommute(@Body params: HashMap<String, Any>): Call<ResponseData>

}