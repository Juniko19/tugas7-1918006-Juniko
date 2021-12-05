package com.example.tugas7;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static String DATABASE_NAME = "db_1918006";
    private static final String tb_ikan = "tb_ikan";
    private static final String tb_ikan_id = "id";
    private static final String tb_ikan_nama = "nama";
    private static final String tb_ikan_harga = "harga";
    private static final String CREATE_TABLE_IKAN = "CREATE TABLE " +
    tb_ikan +"("
            + tb_ikan_id + " INTEGER PRIMARY KEY ,"
            + tb_ikan_nama + " TEXT ,"
            + tb_ikan_harga + " TEXT " + ")";
    public MyDatabase (Context context){
        super(context, DATABASE_NAME, null , DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_IKAN);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int
            newVersion) {
    }
    public void CreateIkan(Ikan data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_ikan_id, data.get_id());
        values.put(tb_ikan_nama, data.get_ikan());
        values.put(tb_ikan_harga, data.get_harga());
        db.insert(tb_ikan, null, values);
        db.close();
    }
    public List<Ikan> ReadIkan() {
        List<Ikan> listMhs = new ArrayList<Ikan>();
        String selectQuery = "SELECT * FROM " + tb_ikan;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Ikan data = new Ikan();
                data.set_id(cursor.getString(0));
                data.set_ikan(cursor.getString(1));
                data.set_harga(cursor.getString(2));
                listMhs.add(data);
            } while (cursor.moveToNext());
        }
        db.close();
        return listMhs;
    }
    public int UpdateIkan (Ikan data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_ikan_nama, data.get_ikan());
        values.put(tb_ikan_harga, data.get_harga());
        return db.update(tb_ikan, values, tb_ikan_id +
                        " = ?",
                new String[]{String.valueOf((data.get_id()))});
    }
    public void DeleteIkan(Ikan data){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_ikan,tb_ikan_id+ " = ?",
                new String[]{String.valueOf(data.get_id())});
        db.close();
    }
}