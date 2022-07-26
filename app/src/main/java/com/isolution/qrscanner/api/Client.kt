package com.isolution.qrscanner.api

import android.content.ContentValues.TAG
import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object Client {

  // 클라이언트 선언
  private var retrofitClient: Retrofit? = null;

  // 클라이언트 가져오기
  fun getClient(baseUrl: String): Retrofit? {
    val clientBuilder = OkHttpClient.Builder()
    val loggingInterceptor = HttpLoggingInterceptor()
    loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    clientBuilder.addInterceptor(loggingInterceptor)

    Log.d(TAG, "SUPERPIL : ${baseUrl}");
    if(retrofitClient == null) {
      retrofitClient = Retrofit
        .Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .client(clientBuilder.build())
        .build()
    };
    return retrofitClient;
  }

}