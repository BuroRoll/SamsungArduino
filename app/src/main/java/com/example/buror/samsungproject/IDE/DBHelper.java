package com.example.buror.samsungproject.IDE;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "codeDB.db";
    public static final String TABLE_NAME = "code";
    public static int DATABASE_VERSION = 3;

    //элементы таблицы
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_CODE = "code";

    //номера расположения колонок в таблице
    public static final int NUM_COLUMN_ID = 0;
    public static final int NUM_COLUMN_NAME = 1;
    public static final int NUM_COLUMN_CODE = 2;

    //Конструктор, в который помещается контекст, имя БД, null, версия БД
    public DBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    //метод для создания БД
    @Override
    public void onCreate(SQLiteDatabase db) {
        //СОЗДАНИЕ РАЗМЕТКИ ТАБЛИЦЫ
        String dbCreate = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_CODE + " TEXT);";
        db.execSQL(dbCreate);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}