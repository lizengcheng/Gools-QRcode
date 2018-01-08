package com.example.u.gools_qrcode.saomiao;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.u.gools_qrcode.MainActivity;
import com.example.u.gools_qrcode.R;
import com.example.u.gools_qrcode.dao.DAO;
import com.example.u.gools_qrcode.model.Tb_goods;
import com.google.zxing.activity.CaptureActivity;

public class SaomiaoActivity extends AppCompatActivity {

    ImageView image;
    TextView tvGoodsId;
    TextView tvGoodName;
    TextView tvGoodsPrize;
    TextView tvGoodMark;

    private Context mContext;
    private final static int REQ_CODE = 1028;

    private DAO dao = new DAO(SaomiaoActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saomiao);
        tvGoodsId= (TextView) findViewById(R.id.tv_goodscode);
        tvGoodName= (TextView) findViewById(R.id.tv_goodname);
        tvGoodsPrize= (TextView) findViewById(R.id.tv_goodsprize);
        tvGoodMark= (TextView) findViewById(R.id.tv_goodmark);
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
            tvGoodsId.setVisibility(View.VISIBLE);

            try {
                String result = data.getStringExtra(CaptureActivity.SCAN_QRCODE_RESULT);
                tvGoodsId.setText(result);
                Tb_goods tb_goods = dao.find(Long.valueOf(tvGoodsId.getText().toString()));
                tvGoodName.setText(String.valueOf(tb_goods.getName()));
                tvGoodsPrize.setText(String.valueOf(tb_goods.getPrize()));
                tvGoodMark.setText(tb_goods.getMark());
                showToast("扫码结果：" + result);
            }catch (Exception e){
                finish();
            }
        }
    }

    private void showToast(String msg) {
        Toast.makeText(mContext, "" + msg, Toast.LENGTH_SHORT).show();
    }
}
