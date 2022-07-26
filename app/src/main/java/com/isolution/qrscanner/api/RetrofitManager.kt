package com.isolution.qrscanner.api

import android.content.ContentValues.TAG
import android.util.Log
import com.google.gson.JsonElement
import com.isolution.qrscanner.ResponseData
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response

class RetrofitManager {

  companion object{
    val instance = RetrofitManager();
  }

  private val retro: IRetrofit? = Client.getClient("http://ec2-52-78-134-72.ap-northeast-2.compute.amazonaws.com:8080")?.create(IRetrofit::class.java);

  fun searchPhotos(searchTerm: String?, completion: (String) -> Unit) {
    Log.d(TAG, "SUPERPIL 진입1111!!! :");
    val term: String = searchTerm.let{ it }?: "";

    val call: Call<JsonElement> = retro?.searchPhotos(searchTerm = term).let {
      it
    }?: return

    // 응답결과 받는 곳
    call.enqueue(object : retrofit2.Callback<JsonElement>{
      override fun onResponse(call: Call<JsonElement>, response: Response<JsonElement>) {
        Log.d(TAG, "SUPERPIL RetrofitManager - onResponse() called / t : ${response.raw()}");
        completion(response.raw().toString());
      }

      override fun onFailure(call: Call<JsonElement>, t: Throwable) {
        Log.d(TAG, "SUPERPIL RetrofitManager - onFailure() called / t : $t");
      }
    })

  }

//  fun insertCommute(completion: (String) -> Unit) {
////    val term: String = searchTerm.let{ it }?: "";
////
////    val call: Call<JsonElement> = iRetrofit?.searchPhotos(searchTerm = term).let {
////      it
////    }?: return
//    Log.d(TAG, "[SUPERIL LOG] API 함수 진입!!!!!!!!!!!!!!");
//
//    val req = SaveCommute("F", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJRUi10b2tlbiIsInR5cGUiOiJPIiwidXNlcklkIjoyMSwiY3JlYXRlRGF0ZSI6IjIwMjItMDctMjUiLCJpYXQiOjE2NTg3MjE1MjIsImV4cCI6MTY1ODcyNTEyMn0.N3uxu_R0-A8Q2z2NHRAPq6Fr_x_WYJRFy5GcWkcFh_I")
//    Log.d(TAG, "[SUPERIL LOG] Commute Req : ${req}");
//
//    val jsonObject = JSONObject()
//    jsonObject.put("type", "F")
//    jsonObject.put("qrToken", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJRUi10b2tlbiIsInR5cGUiOiJPIiwidXNlcklkIjoyMSwiY3JlYXRlRGF0ZSI6IjIwMjItMDctMjUiLCJpYXQiOjE2NTg3MjE1MjIsImV4cCI6MTY1ODcyNTEyMn0.N3uxu_R0-A8Q2z2NHRAPq6Fr_x_WYJRFy5GcWkcFh_I")
//
//    var map = HashMap<String, String>();
//    map.put("type", "O");
//    map.put("qrToken", "aaaaaaaaaa")
//
//    // 응답결과 받는 곳
//    retro?.insertCommute(map)?.enqueue(object : retrofit2.Callback<JsonElement>{
//      override fun onResponse(call: Call<JsonElement>, response: Response<JsonElement>) {
//        Log.d(TAG, "[SUPERIL LOG] RetrofitManager - onResponse() called / t : ${response}");
//        completion(response.raw().toString());
//      }
//
//      override fun onFailure(call: Call<JsonElement>, t: Throwable) {
//        Log.d(TAG, "[SUPERIL LOG] RetrofitManager - onFailure() called / t : ${t.toString()}");
//      }
//    })

  fun insertCommute(completion: (String) -> Unit) {
//    val term: String = searchTerm.let{ it }?: "";
//
//    val call: Call<JsonElement> = iRetrofit?.searchPhotos(searchTerm = term).let {
//      it
//    }?: return
      Log.d(TAG, "[SUPERPIL LOG] API 함수 진입!!!!!!!!!!!!!!");

      var map = HashMap<String, Any>();
      map.put("type", "O");
      map.put("qrToken", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJRUi10b2tlbiIsInR5cGUiOiJPIiwidXNlcklkIjoyMSwiY3JlYXRlRGF0ZSI6IjIwMjItMDctMjYiLCJpYXQiOjE2NTg3OTMxNzIsImV4cCI6MTY1ODc5Njc3Mn0.koeqHiLpKXIcpr-hPXjAsgrWNzGffsHR3edETK7TbU4")

    Log.d(TAG, "[SUPERPIL LOG] retro ${retro}");

      // 응답결과 받는 곳
      retro?.insertCommute(map)?.enqueue(object : retrofit2.Callback<ResponseData> {
        override fun onResponse(call: Call<ResponseData>, response: Response<ResponseData>) {
          // 성공여부
          Log.d(TAG, "[SUPERPIL LOG] RetrofitManager - onResponse() called / onResponse!!! : ${response.isSuccessful()}");
          // 성공했을경우
//          val result: ResponseData? = response.body();
//          Log.d(TAG, "[SUPERPIL LOG] RetrofitManager - onResponse() called / onResponse!!! : ${result}");

          // 에러가 발생한경우
          Log.d(TAG, "[SUPERPIL LOG] RetrofitManager - onResponse() called / onResponse!!! : ${response.errorBody()?.string()}");
          completion(response.raw().toString());
        }

        override fun onFailure(call: Call<ResponseData>, t: Throwable) {
          Log.d(TAG, "[SUPERPIL LOG] RetrofitManager - onFailure() called / Error : $call")
          Log.d(TAG, "[SUPERPIL LOG] RetrofitManager - onFailure() called / Error : $t");
        }
      })
    }

  }