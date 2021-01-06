package com.dunca.charactergenerator;
//Made using tutorial at https://www.journaldev.com/9438/android-sqlite-database-example-tutorial
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    //Table Name
    public static final String TABLE_NAME = "CHARACTERS_REALISTIC";

    //Table columns
    public static final String _ID = "_id";
    public static final String PROFESSION ="profession";
    public static final String HAIRCOLOUR = "hair_colour";
    public static final String HOBBY ="hobby";

    //Database Information
    static final String DB_NAME = "CHAR_GEN.DB";

    //Database Version
    static final int DB_VERSION =1;

    //Creating table query
    private static final String CREATE_TABLE = "create table " +
            TABLE_NAME + "(" + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + PROFESSION +
            " TEXT NOT NULL, " + HAIRCOLOUR + " TEXT NOT NULL, " + HOBBY + " TEXT NOT NULL);";

    public DatabaseHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    //REMOVE WHEN FINISHED TEST
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
