package com.example.datastorage.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteHelper extends SQLiteOpenHelper {

    private static final String DATABASE = "student.db";
    private static final int DB_VERSION = 1 ;

    private static SQLiteHelper sqLiteHelper;
    private  SQLiteHelper(@Nullable Context context) {
        super(context, SQLiteHelper.DATABASE, null, SQLiteHelper.DB_VERSION);
    }

    public static synchronized SQLiteHelper getInstance(Context context){

        if (sqLiteHelper == null){
            sqLiteHelper = new SQLiteHelper(context.getApplicationContext());
        }
        return sqLiteHelper;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String StudentTable = "CREATE TABLE IF NOT EXISTS `student`(id INTEGER PRIMARY KEY AUTOINCREMENT,name VARCHAR(150),age INTEGER)";
        sqLiteDatabase.execSQL(StudentTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        String dropStudemtTable = "DROP TABLE IF EXISTS student";
        sqLiteDatabase.execSQL(dropStudemtTable);

    }
}
