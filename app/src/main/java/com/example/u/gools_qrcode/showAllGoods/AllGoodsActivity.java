package com.example.u.gools_qrcode.showAllGoods;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.u.gools_qrcode.R;
import com.example.u.gools_qrcode.addGoods.AddGoodsActivity;
import com.example.u.gools_qrcode.dao.DAO;
import com.example.u.gools_qrcode.model.Tb_goods;

import java.util.List;

public class AllGoodsActivity extends Activity {
    private static final String ID="id";
    private ListView listView;
    private String strType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_goods);
        listView = (ListView)findViewById(R.id.listview);
        showInfo();

        /*listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String strInfo = String.valueOf(((TextView) view).getText());
                String strid = strInfo.substring(0, strInfo.indexOf('|'));
                Intent intent = new Intent(AllGoodsActivity.this, AddGoodsActivity.class);
                intent.putExtra(ID, new String[] { strid, strType });
                startActivity(intent);
            }
        });*/
    }

    private void showInfo() {
        String[] strInfos = null;
        ArrayAdapter<String> arrayAdapter = null;
        strType = "btnininfo";
        DAO dao = new DAO(AllGoodsActivity.this);
        List<Tb_goods> listinfos = dao.getScrollData(0, (int) dao.getCount());
        strInfos = new String[listinfos.size()];
        int m = 0;
        for (Tb_goods tb_goods : listinfos) {
            strInfos[m] = "商品名："+ tb_goods.getName() + "   价钱：" + String.valueOf(tb_goods.getPrize()) + "元    商品码："
                    + tb_goods.getGoodsId();
            m++;
        }
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strInfos);
        listView.setAdapter(arrayAdapter);

    }
}
