package com.example.hannahkern.bankaccount;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

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
            + COLUMN_USER_ID + " 1," +
            COLUMN_USER_NAME + " hannah," + COLUMN_USER_PASSWORD + " 1234" +
            COLUMN_USER_BALANCE + "10000" + ")";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public String[] getBalance(){
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {
                COLUMN_USER_BALANCE
        };

        Cursor cursor = db.query(DatabaseHelper.TABLE_USER,
                columns, DatabaseHelper.COLUMN_USER_ID + "= 1" ,
                null, null, null, null);

        return columns;
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
        values.put(COLUMN_USER_NAME, person.getName());
        values.put(COLUMN_USER_PASSWORD, person.getPasswort());
        values.put(COLUMN_USER_BALANCE, person.getBalance());

        // Inserting Row
        db.insert(TABLE_USER, null, values);
        db.close();
    }

    public List<Person> getAllUser() {
        // array of columns to fetch
        String[] columns = {
                COLUMN_USER_ID,
                COLUMN_USER_NAME,
                COLUMN_USER_PASSWORD
        };

        String sortOrder =
                COLUMN_USER_NAME + " ASC";
        List<Person> userList = new ArrayList<Person>();

        SQLiteDatabase db = this.getReadableDatabase();


        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order


        // Traversing through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Person person = new Person();
                person.setName(cursor.getString(cursor.getColumnIndex(COLUMN_USER_NAME)));
                person.setPasswort(cursor.getString(cursor.getColumnIndex(COLUMN_USER_PASSWORD)));
                // Adding user record to list
                userList.add(person);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        // return user list
        return userList;
    }

    public boolean checkUser(String name) {

        // array of columns to fetch
        String[] columns = {
                COLUMN_USER_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();

        // selection criteria
        String selection = COLUMN_USER_NAME + " = ?";

        // selection argument
        String[] selectionArgs = {name};

        // query user table with condition
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com';
         */
        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                      //filter by row groups
                null);                      //The sort order
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if (cursorCount > 0) {
            return true;
        }

        return false;
    }

    public boolean checkUser(String name, String password) {

        // array of columns to fetch
        String[] columns = {
                COLUMN_USER_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();
        // selection criteria
        String selection = COLUMN_USER_NAME + " = ?" + " AND " + COLUMN_USER_PASSWORD + " = ?";

        // selection arguments
        String[] selectionArgs = {name, password};

        // query user table with conditions
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com' AND user_password = 'qwerty';
         */
        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by row groups
                null);                      //The sort order

        int cursorCount = cursor.getCount();

        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return true;
        }

        return false;
    }

}
