package com.example.hannahkern.bankaccount;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by hannahkern on 18.04.18.
 */

public class DatabaseHelper extends SQLiteOpenHelper{

    private static int DATABASE_VERSION = 1;
    private static String DATABASE_NAME = "LoginManager.de";
    private static final String TABLE_USER = "person";

    private static final String COLUMN_USER_ID = "user_id";
    private static final String COLUMN_USER_NAME = "user_name";
    private static final String COLUMN_USER_PASSWORD = "user_password";
    private static final String COLUMN_USER_BALANCE = "user_balance";

    private String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "("
            + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_USER_NAME + " TEXT," + COLUMN_USER_PASSWORD + " TEXT" + ")";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // Create tables again
        onCreate(db);

    }

    public void addUser(Person person) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME, "hannah");
        values.put(COLUMN_USER_PASSWORD, "1234");
        values.put(COLUMN_USER_BALANCE, "100000");

        // Inserting Row
        db.insert(TABLE_USER, null, values);
        db.close();
    }

}
