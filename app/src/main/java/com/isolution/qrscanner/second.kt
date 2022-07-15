package com.isolution.qrscanner

import android.content.ContentValues.TAG
import android.icu.number.Scale.none
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.telecom.Call
import android.util.Log
import androidx.core.os.HandlerCompat.postDelayed

class second : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_second)
    Log.d(TAG, "[SUPERIL] 두번쨰 페이지!!! CREATE")
//    this.someFunction();
    Handler().postDelayed({
                   finish();
    }, 1000)
  }

  fun someFunction() {
    finish()
    // 이 화면은, 오른쪽에서 왼쪽으로 슬라이딩 하면서 사라집니다.
    overridePendingTransition(R.anim.horizon_enter, R.anim.horizon_enter)
  }

//  override fun onBackPressed() {
//    super.onBackPressed()
//    if (isFinishing) {
//      // back 버튼으로 화면 종료가 야기되면 동작한다.
//      overridePendingTransition(R.anim.horizon_enter, R.anim.horizon_enter)
//    }
//  }

  override fun onDestroy() {
    super.onDestroy();
    Log.d(TAG, "[SUPERIL] 두번쨰 페이지!!! DESTROY")
    overridePendingTransition(R.anim.horizon_enter, R.anim.horizon_enter)
  }

}