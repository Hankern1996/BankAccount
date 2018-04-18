package com.example.hannahkern.bankaccount.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.hannahkern.bankaccount.database.AccountDbSchema.AccountTable;

/**
 * Created by hannahkern on 18.04.18.
 */

public class AccountBaseHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "accountBase.db";

    public AccountBaseHelper(Context context){
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + AccountTable.NAME + "(" +
                " _id integer primary key autoincrement, " +
                AccountTable.Cols.UUID + "1 , " +
                AccountTable.Cols.NAME + "hannah , " +
                AccountTable.Cols.PASSWORD + "1234 , " +
                AccountTable.Cols.BALANCE + "10000 " +
                ")");
    }



    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }
}
