package com.dunca.charactergenerator;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLException;
//Made using tutorial at https://www.journaldev.com/9438/android-sqlite-database-example-tutorial

public class DBManager {
    private SQLiteOpenHelper dbHelper;
    private SQLiteDatabase database;
    private Context context;

    public DBManager (Context c){
        context = c;
    }

    public DBManager open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close(){
        dbHelper.close();
    }

    public void insert(String profession, String hairColour, String hobby){
        ContentValues contentValue = new ContentValues();
        contentValue.put(DatabaseHelper.PROFESSION, profession);
        contentValue.put(DatabaseHelper.HAIRCOLOUR, hairColour);
        contentValue.put(DatabaseHelper.HOBBY, hobby);
        database.insert(DatabaseHelper.TABLE_NAME, null, contentValue);
    }

    public int update(long _id, String profession, String hairColour, String hobby){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.PROFESSION, profession);
        contentValues.put(DatabaseHelper.HAIRCOLOUR, hairColour);
        contentValues.put(DatabaseHelper.HOBBY, hobby);
        int i = database.update(DatabaseHelper.TABLE_NAME, contentValues, DatabaseHelper._ID + " = "+_id, null);
        return i;
    }

    public void delete(long _id){
        database.delete(DatabaseHelper.TABLE_NAME, DatabaseHelper._ID + "=" + _id, null);
    }
    public Cursor fetch(){
        String[] columns = new String[]{ DatabaseHelper._ID, DatabaseHelper.PROFESSION, DatabaseHelper.HAIRCOLOUR, DatabaseHelper.HOBBY};
        Cursor cursor = database.query(DatabaseHelper.TABLE_NAME, columns, null, null,null,null, null);
        if(cursor != null){
            cursor.moveToFirst();
        }
        return cursor;
    }
}
