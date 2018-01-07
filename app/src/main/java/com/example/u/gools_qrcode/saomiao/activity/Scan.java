package com.example.u.gools_qrcode.saomiao.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.u.gools_qrcode.saomiao.SaomiaoActivity;
import com.google.zxing.activity.CaptureActivity;


/**
 * Created by U on 2018/1/3.
 */

public class Scan extends AppCompatActivity {

    public String result;
    private final static int REQ_CODE = 1028;

    public  void startScan(){
        Intent intent = new Intent(this,CaptureActivity.class);
        startActivityForResult(intent, REQ_CODE);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ_CODE) {
           result = data.getStringExtra(CaptureActivity.SCAN_QRCODE_RESULT);
        }
    }
}
