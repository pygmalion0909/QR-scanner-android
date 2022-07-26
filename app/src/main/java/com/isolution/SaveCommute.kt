package com.isolution

import com.google.gson.annotations.SerializedName

data class SaveCommute(
  @SerializedName("type") var type: String
  ,@SerializedName("qrToken") var qrToken: String
)
