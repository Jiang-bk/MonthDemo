package com.bwei.jiangbikuan.monthdemo.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class MyDao {
    private MyHelper myHelper;

    public MyDao(Context context) {
        myHelper = new MyHelper(context);
    }

    //添加
    public void insert(String path,String json){
        SQLiteDatabase sqLiteDatabase = myHelper.getWritableDatabase();
        //添加之前把相同的数据删除
        sqLiteDatabase.delete("news","urlpath = ?",new String[]{path});
        //进行数据库的添加
        ContentValues values = new ContentValues();
        values.put("urlpath",path);
        values.put("jsondata",json);
        sqLiteDatabase.insert("news",null,values);
        Log.e("JBK","添加成功");
    }

    //查询
    public String select(String path){
        String data = "";
        SQLiteDatabase sqLiteDatabase = myHelper.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.query("news", null, "urlpath = ?", new String[]{path}, null, null, null);
        while (cursor.moveToNext()){
            data = cursor.getString(cursor.getColumnIndex("jsondata"));
        }
        return data;
    }
}
