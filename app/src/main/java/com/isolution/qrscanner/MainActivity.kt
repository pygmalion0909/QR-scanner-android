package com.isolution.qrscanner

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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

  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
    if(result != null) {
      if(result.contents != null) {
//        Toast.makeText(this, "scanned: ${result.contents} format: ${result.formatName}", Toast.LENGTH_LONG).show();
        RetrofitManager.instance.searchPhotos(searchTerm = "test", completion = {
          res -> Toast.makeText(this, "api호출완료 ${res}", Toast.LENGTH_SHORT).show();
          Log.d(TAG, "api 호출 성공 : $res");
        });
      } else {
        Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show()
      }
    } else {
      super.onActivityResult(requestCode, resultCode, data)
    }
  }

}