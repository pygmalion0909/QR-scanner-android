package com.isolution.qrscanner.scanner

import android.content.ContentValues
import android.content.ContentValues.TAG
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.google.zxing.integration.android.IntentIntegrator
import com.google.zxing.integration.android.IntentResult
import com.isolution.qrscanner.MainActivity

class QRScan(private val act: MainActivity) {

  /** QRCode Scan */
  fun startQRScan() {
    Log.d(ContentValues.TAG, "SUPERPIL 스캐너 생성 접근! ");
    val intentIntegrator = IntentIntegrator(act)
    intentIntegrator.setPrompt("I-Tech 출,퇴근 QR코드 리더기") //QR코드 스캔 액티비티 하단에 띄울 텍스트 설정
    intentIntegrator.setOrientationLocked(false)                       //화면회전을 막을 것인지 설정 (default 세로모드)
    intentIntegrator.setBeepEnabled(false)                             //QR코드 스캔 시 소리를 낼 지 설정
    activityResult.launch(intentIntegrator.createScanIntent())
  }

  /** onActivityResult */
  private val activityResult = act.registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
    Log.d(ContentValues.TAG, "SUPERPIL 스캔 데이터 접근! ")
    val gg: IntentResult? = IntentIntegrator.parseActivityResult(result.resultCode, result.data)

    gg?.let {
      Log.d(TAG, "SUPERPIL let에 it !!! ${it}")
    }




//    if(result != null) {
//      //QRCode Scan 성공
//      if(intentResult.contents != null){
//        //QRCode Scan result 있는경우
//        Toast.makeText(act, "인식된 QR-data: ${intentResult.contents}", Toast.LENGTH_SHORT).show()
//      }else{
//        //QRCode Scan result 없는경우
//        Toast.makeText(act, "인식된 QR-data가 없습니다.", Toast.LENGTH_SHORT).show()
//      }
//    }else{
//      //QRCode Scan 실패
//      Toast.makeText(act, "QR스캔에 실패했습니다.", Toast.LENGTH_SHORT).show()
//    }
    startQRScan();
  }

  private fun onApi(aa: IntentResult): Unit {
  }

  private fun offApi(bb: IntentResult): Unit {
  }

  /** onActivityResult */
//  private val activityResult = act.registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
//    Log.d(ContentValues.TAG, "SUPERPIL 스캔 데이터 접근! ");
//    val data = result.data
//    Log.d(ContentValues.TAG, "SUPERPIL 스캔 데이터 ${data} ");
//
//    val intentResult: IntentResult? = IntentIntegrator.parseActivityResult(result.resultCode, data)
//    if(intentResult != null) {
//      //QRCode Scan 성공
//      if(intentResult.contents != null){
//        //QRCode Scan result 있는경우
//        Toast.makeText(act, "인식된 QR-data: ${intentResult.contents}", Toast.LENGTH_SHORT).show()
//      }else{
//        //QRCode Scan result 없는경우
//        Toast.makeText(act, "인식된 QR-data가 없습니다.", Toast.LENGTH_SHORT).show()
//      }
//    }else{
//      //QRCode Scan 실패
//      Toast.makeText(act, "QR스캔에 실패했습니다.", Toast.LENGTH_SHORT).show()
//    }
//    startQRScan();
//  }
}