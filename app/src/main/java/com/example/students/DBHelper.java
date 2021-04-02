package com.example.students;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBHelper extends SQLiteOpenHelper {
    Context context;

    // при изменении структуры БД меняется и версия
    private static final int DATABASE_VERSION = 2;

    public DBHelper(Context context) {
        super(context, context.getResources().getString(R.string.DB_NAME), null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // выполняется, если базы данных нет
        String query = "CREATE TABLE students (" + context.getResources().getString(R.string.COLUMN_ID)
                + " INTEGER PRIMARY KEY AUTOINCREMENT," + context.getResources().getString(R.string.COLUMN_LASTNAME)
                + " TEXT NOT NULL, " + context.getResources().getString(R.string.COLUMN_FIRSTNAME) + " TEXT NOT NULL, "
                + context.getResources().getString(R.string.COLUMN_GROUP) + " INTEGER NOT NULL, "
                + context.getResources().getString(R.string.COLUMN_AGE) + " INTEGER NOT NULL);";

        db.execSQL(query);

        //db.execSQL("INSERT INTO students VALUES (1, 'Urumov', 'Alexander', 2441, 21 )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // выполняется, если версия базы данных отличается
        db.execSQL("DROP TABLE IF EXISTS " + context.getResources().getString(R.string.TABLE));
        this.onCreate(db);
    }
}
