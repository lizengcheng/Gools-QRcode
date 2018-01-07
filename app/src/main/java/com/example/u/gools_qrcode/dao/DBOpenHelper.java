package com.example.u.gools_qrcode.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by U on 2018/1/5.
 */

public class DBOpenHelper extends SQLiteOpenHelper{


    public DBOpenHelper(Context context){
        super(context,Constent.DB_NAME,null,Constent.DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table goods(_id Integer primary key,name varchar(20),prize float,goodsId varchar(20),mark varchar(100))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}
