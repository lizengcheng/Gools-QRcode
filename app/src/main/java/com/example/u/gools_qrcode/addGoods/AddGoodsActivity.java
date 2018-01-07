package com.example.u.gools_qrcode.addGoods;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.u.gools_qrcode.R;
import com.example.u.gools_qrcode.dao.DAO;
import com.example.u.gools_qrcode.dao.DBManeger;
import com.example.u.gools_qrcode.dao.DBOpenHelper;
import com.example.u.gools_qrcode.model.Tb_goods;
import com.google.zxing.activity.CaptureActivity;
import com.google.zxing.decode.BitmapDecoder;

public class AddGoodsActivity extends AppCompatActivity {
        ImageView image;
        EditText goodscode;
        TextView goodname;
        TextView goodsprize;
        TextView goodmark;
        private Context mContext;
        Button addButton;
        Button cancelButton;
        private final static int REQ_CODE = 1028;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_add_goods);

            startScan();
            mContext = this;
            image= (ImageView) findViewById(R.id.image);
            goodscode= (EditText) findViewById(R.id.et_goodscode);
            goodname=(TextView)findViewById(R.id.tv_goodname);
            goodsprize=(TextView)findViewById(R.id.tv_goodsprize);
            goodmark=(TextView)findViewById(R.id.tv_goodmark);
            addButton=(Button)findViewById(R.id.bt_add);
            cancelButton=(Button)findViewById(R.id.bt_cencel);

            addButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DAO dao = new DAO(AddGoodsActivity.this);
                    Tb_goods tb_goods = new Tb_goods(
                            dao.getMaxId()+1,
                            goodname.getText().toString(),
                            Float.parseFloat(goodsprize.getText().toString()),
                            goodscode.getText().toString(),
                            goodmark.getText().toString());
                    dao.add(tb_goods);

                    Toast.makeText(AddGoodsActivity.this, goodscode.getText().toString()+"商品添加成功！", Toast.LENGTH_SHORT).show();
                }
            });
            cancelButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
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
                goodscode.setVisibility(View.VISIBLE);

                String result = data.getStringExtra(CaptureActivity.SCAN_QRCODE_RESULT);

                goodscode.setText(result);
                showToast("扫码结果：" + result);
            }
        }

        private void showToast(String msg) {
            Toast.makeText(mContext, "" + msg, Toast.LENGTH_SHORT).show();
        }
    }
