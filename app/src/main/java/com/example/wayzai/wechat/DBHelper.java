package com.example.wayzai.wechat;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper{
    public DBHelper(Context context,String name,SQLiteDatabase.CursorFactory factory,int version){
        super(context,name,null,1);
    }
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE users(id INTEGER PRIMARY KEY AUTOINCREMENT,name VARCHAR(20),passwd VARCHAR(20),sex VARCHAR(10))");
    }
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){

    }
}