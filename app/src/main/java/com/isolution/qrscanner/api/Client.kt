package com.isolution.qrscanner.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Client {

  // 클라이언트 선언
  private var retrofitClient: Retrofit? = null;

  // 클라이언트 가져오기
  fun getClient(baseUrl: String): Retrofit? {
    if(retrofitClient == null) {
      retrofitClient = Retrofit
        .Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    };
    return retrofitClient;
  }

}