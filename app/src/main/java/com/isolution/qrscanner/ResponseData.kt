package com.isolution.qrscanner

import com.google.gson.annotations.SerializedName
import java.util.Objects

data class ResponseData(
  @SerializedName("success") var success: Boolean
  , @SerializedName("code") var code: Int
  , @SerializedName("msg") var msg: String
//  , var data: Objects
)