package com.example.u.gools_qrcode.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.u.gools_qrcode.model.Tb_goods;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by U on 2018/1/5.
 */

public class DAO {
    private DBOpenHelper helper;
    private SQLiteDatabase db;

    public DAO(Context context){
        helper = new DBOpenHelper(context);
    }
    public void add(Tb_goods tb_goods){
        db = helper.getWritableDatabase();
        db.execSQL("insert into goods(_id,name,prize,goodsId,mark) values (?,?,?,?,?)", new Object[] {
                tb_goods.get_id(),
                tb_goods.getName(),
                tb_goods.getPrize(),
                tb_goods.getGoodsId(),
                tb_goods.getMark()});
    }
    public List<Tb_goods> getScrollData(int start, int count) {
        List<Tb_goods> tb_inaccount = new ArrayList<Tb_goods>();
        db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from goods limit ?,?", new String[] { String.valueOf(start), String.valueOf(count) });
        while (cursor.moveToNext()) {
            tb_inaccount.add(new Tb_goods(cursor.getInt(cursor.getColumnIndex("_id")), cursor.getString(cursor
                    .getColumnIndex("name")), cursor
                    .getDouble(cursor.getColumnIndex("prize")), cursor.getString(cursor.getColumnIndex("goodsId")),  cursor.getString(cursor.getColumnIndex("mark"))));
        }
        return tb_inaccount;
    }
    public long getCount() {
        db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select count(_id) from goods", null);
        if (cursor.moveToNext()) {

            return cursor.getLong(0);
        }
        return 0;
    }
    public int getMaxId() {
        db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select max(_id) from goods", null);
        while (cursor.moveToLast()) {
            return cursor.getInt(0);
        }
        return 0;
    }
}
