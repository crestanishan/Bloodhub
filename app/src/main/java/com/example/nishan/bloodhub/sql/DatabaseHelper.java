package com.example.nishan.bloodhub.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.nishan.bloodhub.Model.Registration;

/**
 * Created by nishan on 9/18/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "Signup.db";

    // User table name
    private static final String TABLE_SIGNUP = "signup";

    // User Table Columns names
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_ADDRESS = "address";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_MBN = "mbn";
    private static final String COLUMN_PASSWORD = "password";
    private static final String COLUMN_Reenter_password = "reenter_password";

    // create table sql query
    private String CREATE_SIGNUP_TABLE = "CREATE TABLE " + TABLE_SIGNUP + "("
            + COLUMN_NAME + " TEXT," + COLUMN_ADDRESS + " TEXT," + COLUMN_EMAIL + " TEXT," +
            COLUMN_MBN + " TEXT," +COLUMN_PASSWORD + " TEXT," +COLUMN_Reenter_password  + " TEXT " +")";



    /**
     * Constructor
     *
     * @param context
     */
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_SIGNUP_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        //Drop Table if exist
        String DROP_SIGNUP_TABLE = "DROP TABLE IF EXISTS " + TABLE_SIGNUP;
        db.execSQL( DROP_SIGNUP_TABLE);

        // Create tables again
        onCreate(db);


    }

    /**
     * This method is to create record
     *
     */
    public void insertRegistration(Registration r) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, r.getName());
        values.put(COLUMN_ADDRESS, r.getAddress());
        values.put(COLUMN_EMAIL, r.getEmail());
        values.put(COLUMN_MBN, r.getMbn());
        values.put(COLUMN_PASSWORD, r.getPassword());
        values.put(COLUMN_Reenter_password, r.getReenter_password());

        // Inserting Row
        db.insert(TABLE_SIGNUP, null, values);
        db.close();
    }

    public String Search (String string){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "select email, password from"+ TABLE_SIGNUP;
        Cursor cursor = db.rawQuery(query, null);

        String a,b;
        b = "not found";
        if (cursor.moveToFirst()){
            do {
                a = cursor.getString(cursor.getColumnIndex(COLUMN_EMAIL));

                if (a.equals(string)){
                    b = cursor.getString(cursor.getColumnIndex(COLUMN_PASSWORD));
                    break;
                }

            }while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return b;
    }

}
