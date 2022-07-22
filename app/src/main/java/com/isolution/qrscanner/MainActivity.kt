package com.isolution.qrscanner

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.zxing.integration.android.IntentIntegrator
import com.isolution.qrscanner.api.RetrofitManager

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val test = { a: Int, b: Int ->
      val c = a + b
      c * 2
    }
    println("Superpil ${test(1, 2)}")

    // 함수선언
    // lambda 1
    val aa: (Int, Int) -> Int = {x, y -> x * y};
    println("Superpil aa ${aa(1, 2)}")

    // lambda 2(생략없는 오리지널)
    val bb: (Int, Int) -> Int = {x: Int, y: Int -> x * y};
    println("Superpil aa ${bb(2, 2)}")

    // lambda 3(선언부분 생략)
    val cc = { x: Int, y: Int -> x * y};
    println("Superpil cc ${cc(2, 2)}")

    showFunc { x, y -> x * y }

//    IntentIntegrator(this).initiateScan()
  }

  fun showFunc(cal: (Int, Int) -> Int) {
    val result = cal(2, 3);
    println("Superpil ShowFunc : ${result}");
  }
//  fun startScanner(view: View) {
//    IntentIntegrator(this).initiateScan()
//  }

  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    // qr결과값가져오기
    val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
    if(result == null) return super.onActivityResult(requestCode, resultCode, data);
    if(result.contents == null) return Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();

    Log.d(TAG, "[SUPERIL LOG] API시작!!!!!!!!!!!!!!!!!!!!");
    RetrofitManager.instance.insertCommute(completion = { res ->
//      res -> Toast.makeText(this, "[SUPERPIL!!!!!!!!!!!!!] api호출완료 ${res}", Toast.LENGTH_SHORT).show();
      Log.d(TAG, "api 호출 성공 : $res");
      IntentIntegrator(this).initiateScan();
    });

  }

}
