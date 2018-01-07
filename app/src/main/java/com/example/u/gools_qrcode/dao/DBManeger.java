package com.example.u.gools_qrcode.dao;

import android.content.Context;

/**
 * Created by U on 2018/1/5.
 */

public class DBManeger {
    private static DBOpenHelper helper;
    public static DBOpenHelper getIntance(Context context){
        if(helper==null){
            helper=new DBOpenHelper(context);
        }
        return helper;
    }
}
