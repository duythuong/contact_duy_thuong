package com.example.duynguyen.contact;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class database extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "contact";
    private static final String TABLE_NAME = "contact";
    private static final String ID = "id";
    private static final String FIRST_NAME = "first_name";
    private static final String PHONE = "phone";
    private static final String EMAIL = "email";
    private static final int VERSION = 1;
    private static final String CREATE_TABLE =
            ""+"create table "+TABLE_NAME+"("
            +ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
            +FIRST_NAME+" text,"
            +PHONE+" text,"
            +EMAIL+" text"+")";

    public database(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void addStudent(doituong doituong){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(FIRST_NAME,doituong.getFilsname());
        contentValues.put(PHONE,doituong.getMobile());
        contentValues.put(EMAIL,doituong.getEmail());
        db.insert(TABLE_NAME,null,contentValues);
        db.close();
    }

    public ArrayList<doituong> first_name(){
        ArrayList<doituong> doituongs = new ArrayList<doituong>();
        String selectQuery = "SELECT "+FIRST_NAME+" FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                doituong doituong = new doituong();
                doituong.setFilsname(cursor.getString(0));
                doituongs.add(doituong);
            } while (cursor.moveToNext());
        }
        return doituongs;
    }

    public ArrayList<doituong> getThongTin(String str){
        ArrayList<doituong> doituongs = new ArrayList<doituong>();
        String selectQuery = "SELECT * FROM " + TABLE_NAME + " WHERE "+FIRST_NAME+" = '"+str+"'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                doituong doituong = new doituong();
                doituong.setId(cursor.getInt(0));
                doituong.setFilsname(cursor.getString(1));
                doituong.setMobile(cursor.getString(2));
                doituong.setEmail(cursor.getString(3));
                doituongs.add(doituong);
            } while (cursor.moveToNext());
        }
        return doituongs;
    }
    public void update(doituong doituong){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(FIRST_NAME,doituong.getFilsname());
        contentValues.put(PHONE,doituong.getMobile());
        contentValues.put(EMAIL,doituong.getEmail());
        sqLiteDatabase.update(TABLE_NAME,contentValues,ID+" = "+doituong.getId(),null);
        sqLiteDatabase.close();
    }
}
