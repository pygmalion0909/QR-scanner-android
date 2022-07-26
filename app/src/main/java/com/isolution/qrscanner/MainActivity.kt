package com.isolution.qrscanner

import android.content.ContentValues
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.google.zxing.integration.android.IntentIntegrator
import com.isolution.qrscanner.api.RetrofitManager
import com.isolution.qrscanner.scanner.QRScan

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    QRScan(this).startQRScan()
//    IntentIntegrator(this).initiateScan() 앱 실행 시 바로 스캐너 실행
  }

  fun startScanner(view: View) {
//    IntentIntegrator(this).initiateScan()
//    Log.d(ContentValues.TAG, "SUPERPIL 스타트 버튼! ");
//    val qrCodeScan = QRScan(this)
//    qrCodeScan.startQRScan()
  }

//  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//    super.onActivityResult(requestCode, resultCode, data)
//    // qr결과값가져오기
//    Log.d(TAG, "SUPERPIL onActivityResult Start ${requestCode}");
//    val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
////    if(result == null) {
////      Log.d(TAG, "SUPERPIL result null");
////      return super.onActivityResult(requestCode, resultCode, data)
////    };
//    if(result.contents == null) return Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
//
//    Log.d(TAG, "SUPERPIL API시작!!!!!!!!!!!!!!!!!!!!");
//    RetrofitManager.instance.insertCommute(completion = { res ->
////      res -> Toast.makeText(this, "[SUPERPIL!!!!!!!!!!!!!] api호출완료 ${res}", Toast.LENGTH_SHORT).show();
//      Log.d(TAG, "api 호출 성공 : $res");
//      IntentIntegrator(this).initiateScan();
//    });
//
////    RetrofitManager.instance.searchPhotos("test", completion = { res ->
////      Log.d(TAG, "api 호출 성공 : $res");
////    })
//
//  }

}
