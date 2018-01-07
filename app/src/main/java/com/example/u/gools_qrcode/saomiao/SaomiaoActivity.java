package com.example.u.gools_qrcode.saomiao;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.u.gools_qrcode.R;
import com.google.zxing.activity.CaptureActivity;

public class SaomiaoActivity extends AppCompatActivity {

    ImageView image;
    TextView tvResult;
    private Context mContext;
    private final static int REQ_CODE = 1028;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saomiao);
        tvResult= (TextView) findViewById(R.id.tv_result);
        startScan();
        mContext = this;
        image= (ImageView) findViewById(R.id.image);
    }
    public  void startScan(){
        Intent intent = new Intent(this,CaptureActivity.class);
        startActivityForResult(intent, REQ_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ_CODE) {
            image.setVisibility(View.GONE);
            tvResult.setVisibility(View.VISIBLE);
            String result = data.getStringExtra(CaptureActivity.SCAN_QRCODE_RESULT);
            tvResult.setText(result);
            showToast("扫码结果：" + result);
        }
    }

    private void showToast(String msg) {
        Toast.makeText(mContext, "" + msg, Toast.LENGTH_SHORT).show();
    }
}
