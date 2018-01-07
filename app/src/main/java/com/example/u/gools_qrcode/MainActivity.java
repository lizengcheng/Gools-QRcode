package com.example.u.gools_qrcode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.u.gools_qrcode.addGoods.AddGoodsActivity;
import com.example.u.gools_qrcode.saomiao.SaomiaoActivity;
import com.example.u.gools_qrcode.showAllGoods.AllGoodsActivity;

public class MainActivity extends AppCompatActivity {

    private Button saomiao;
    private Button allgools;
    private Button addgools;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //
        saomiao = (Button) findViewById(R.id.bt_saomiao);
        saomiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SaomiaoActivity.class);
                startActivity(intent);
            }
        });
        allgools = (Button) findViewById(R.id.bt_allgools);
        allgools.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AllGoodsActivity.class);
                startActivity(intent);
            }
        });
        addgools = (Button) findViewById(R.id.bt_addgools);
        addgools.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddGoodsActivity.class);
                startActivity(intent);
            }
        });
    }
}
