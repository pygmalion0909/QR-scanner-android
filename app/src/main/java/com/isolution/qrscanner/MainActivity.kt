package com.isolution.qrscanner

import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import com.google.zxing.integration.android.IntentIntegrator
import com.isolution.qrscanner.api.RetrofitManager

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
  }

  fun startScanner(view: View) {
    IntentIntegrator(this).initiateScan()
  }

  fun toSecondPage(view: View) {
    val intent = Intent(this, second::class.java);
    startActivity(intent);
//    val inflater: LayoutInflater = this.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater;
//    val cView: View = inflater.inflate(R.layout.activity_second, null, true);
  }

  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    // qr결과값가져오기
    val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

    if(result != null) {
      if(result.contents != null) {



        /**
         * 방법1
         * api요청 -> toast커스텀
         *
         * 방법2
         * api요청 -> 페이지이동 -> 5초 후 -> 스캐너 재실행
         */

//        val intent = Intent(this, second::class.java);
//        startActivity(intent);
//        val tas = Toast.makeText(this, "scanned: ${result.contents} format: ${result.formatName}", Toast.LENGTH_LONG);

        // 페이지 이동 -> 스캔 재실행
//        val intent = Intent(this, second::class.java);
//        startActivity(intent);
//        IntentIntegrator(this).initiateScan();



        // api 호출
//        RetrofitManager.instance.searchPhotos(searchTerm = "test", completion = {
//          res -> Toast.makeText(this, "api호출완료 ${res}", Toast.LENGTH_SHORT).show();
//          Log.d(TAG, "api 호출 성공 : $res");
//        });

        Log.d(TAG, "[SUPERIL LOG] API시작!!!!!!!!!!!!!!!!!!!!");
        RetrofitManager.instance.insertCommute(completion = {
//            res -> Toast.makeText(this, "[SUPERPIL!!!!!!!!!!!!!] api호출완료 ${res}", Toast.LENGTH_SHORT).show();
            res -> Log.d(TAG, "api 호출 성공 : $res");
          val intent = Intent(this, second::class.java);
          startActivity(intent);
          IntentIntegrator(this).initiateScan();
        });

      } else {
        Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
      }
    } else {
      super.onActivityResult(requestCode, resultCode, data)
    }
  }

}
