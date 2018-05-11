package com.example.buror.samsungproject.IDE;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

import static com.example.buror.samsungproject.IDE.DBHelper.COLUMN_ID;
import static com.example.buror.samsungproject.IDE.DBHelper.TABLE_NAME;



public class CodeHelper {
    SQLiteDatabase db;

    public CodeHelper(Context context) {
        //инициализация помощника БД
        DBHelper dbHelper = new DBHelper(context);
        //доступ к БД через переменную db,
        // который даёт возможность записывать и читать данные из БД
        db = dbHelper.getWritableDatabase();
    }

    //метод для добавления данных в БД
    long insert(String name, String code) {
        ContentValues cv = new ContentValues();// хранилище

        cv.put(DBHelper.COLUMN_NAME, name);
        cv.put(DBHelper.COLUMN_CODE, code);

        return db.insert(TABLE_NAME, null, cv);
    }

    //удаление по id
    public void delete(long id) {
        db.delete(TABLE_NAME, COLUMN_ID + " = ?", new String[] {String.valueOf(id) });
    }

    //Название говорит само за себя
    void update(Code code) {
        ContentValues cv = new ContentValues();

        cv.put(DBHelper.COLUMN_NAME, code.getName());
        cv.put(DBHelper.COLUMN_CODE, code.getCode());

        db.update(TABLE_NAME, cv, "_id=?", new String[]{String.valueOf(code.getId())});
        //db.close();
        Log.d("Update",code.toString() + "Updated");
    }

    //Метод, который возвращает все данные из БД в ArrayList`e
    ArrayList<Code> getAll(){
        //курсор для перемещения по записям в БД
        Cursor mCursor = db.query(TABLE_NAME, null, null, null, null, null, null);
        ArrayList<Code> arrPers = new ArrayList<>();
        mCursor.moveToFirst();//перемещение курсора на первую запись
        while (mCursor.moveToNext()) { //пока можем двигаться
            int id = mCursor.getInt(DBHelper.NUM_COLUMN_ID);
            String name = mCursor.getString(DBHelper.NUM_COLUMN_NAME);
            String code = mCursor.getString(DBHelper.NUM_COLUMN_CODE);

            //Создаётся новый объект Contact и добавлятся в ArrayList
            arrPers.add(new Code(id, name, code));
        }
        //  db.close(); //Закрытие транзакции для работы с БД
        return arrPers;
    }


    void upDate(int id, String name, String code){

    }
}