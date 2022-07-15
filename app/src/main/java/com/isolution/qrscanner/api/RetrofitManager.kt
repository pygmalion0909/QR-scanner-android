package com.isolution.qrscanner.api

import android.content.ContentValues.TAG
import android.util.Log
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.Response

class RetrofitManager {

  companion object{
    val instance = RetrofitManager();
  }

  private val iRetrofit: IRetrofit? = Client.getClient("http://ec2-52-78-134-72.ap-northeast-2.compute.amazonaws.com:8080")?.create(IRetrofit::class.java);

  fun searchPhotos(searchTerm: String?, completion: (String) -> Unit) {
    val term: String = searchTerm.let{ it }?: "";

    val call: Call<JsonElement> = iRetrofit?.searchPhotos(searchTerm = term).let {
      it
    }?: return

    // 응답결과 받는 곳
    call.enqueue(object : retrofit2.Callback<JsonElement>{
      override fun onResponse(call: Call<JsonElement>, response: Response<JsonElement>) {
        Log.d(TAG, "RetrofitManager - onResponse() called / t : ${response.raw()}");
        completion(response.raw().toString());
      }

      override fun onFailure(call: Call<JsonElement>, t: Throwable) {
        Log.d(TAG, "RetrofitManager - onFailure() called / t : $t");
      }
    })

  }

  fun insertCommute(completion: (String) -> Unit) {
//    val term: String = searchTerm.let{ it }?: "";
//
//    val call: Call<JsonElement> = iRetrofit?.searchPhotos(searchTerm = term).let {
//      it
//    }?: return
    Log.d(TAG, "[SUPERIL LOG] API 함수 진입!!!!!!!!!!!!!!");

    var map = HashMap<String, Any>();
    map.put("type", "O");
    map.put("qrToken", "")
    // 응답결과 받는 곳
    iRetrofit?.insertCommute(map)?.enqueue(object : retrofit2.Callback<JsonElement>{
      override fun onResponse(call: Call<JsonElement>, response: Response<JsonElement>) {
        Log.d(TAG, "[SUPERIL LOG] RetrofitManager - onResponse() called / t : ${response.raw()}");
        completion(response.raw().toString());
      }

      override fun onFailure(call: Call<JsonElement>, t: Throwable) {
        Log.d(TAG, "[SUPERIL LOG] RetrofitManager - onFailure() called / t : $t");
      }
    })

  }

}