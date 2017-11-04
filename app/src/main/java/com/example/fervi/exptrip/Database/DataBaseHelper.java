package com.example.fervi.exptrip.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.fervi.exptrip.Model.user;

/**
 * Created by Fervi on 2017-10-24.
 */

public class DataBaseHelper extends SQLiteOpenHelper {

    //user variables
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "ExpTripDatabase.db";
    private static final String TABLE_USER= "user";
    private static final String COLUMN_USER_ID = "user_id";
    private static final String COLUMN_FIRST_NAME = "first_name";
    private static final String COLUMN_LAST_NAME = "last_name";
    private static final String COLUMN_COUNTRY = "country";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_PASSWORD = "password";


    private String CREATE_TABLE_USER = "CREATE TABLE " + TABLE_USER +
            " (" + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            COLUMN_FIRST_NAME + " TEXT," +
            COLUMN_LAST_NAME + " TEXT," +
            COLUMN_COUNTRY + " TEXT," +
            COLUMN_EMAIL + " TEXT," +
            COLUMN_PASSWORD + " TEXT" + ")";



    private String DROP_TABLE_USER = "DROP TABLE IF EXISTS " + TABLE_USER;

    public DataBaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(CREATE_TABLE_USER);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL(DROP_TABLE_USER);
        onCreate(db);
    }

    public void addUser(user user)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_FIRST_NAME, user.getFirst_name());
        values.put(COLUMN_LAST_NAME, user.getLast_name());
        values.put(COLUMN_COUNTRY, user.getCountry());
        values.put(COLUMN_EMAIL, user.getEmail());
        values.put(COLUMN_PASSWORD, user.getPassword());

        db.insert(TABLE_USER, null, values);
        db.close();
    }

    public boolean checkEmail(String email){
        String[] columns = {
                COLUMN_USER_ID
        };
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = COLUMN_EMAIL + " = ?";
        String[] selectionArgs = { email };

        Cursor cursor = db.query(TABLE_USER,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null);
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if (cursorCount > 0){
            return true;
        }
        return false;
    }

    public boolean checkUser(String email, String password)
    {
        String[] columns = {COLUMN_USER_ID};
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = COLUMN_EMAIL + " = ?" + "AND " + COLUMN_PASSWORD + "= ?";
        String[] selectionArgs = { email, password };

        Cursor cursor = db.query(TABLE_USER, columns,
                selection,
                selectionArgs,
                null,
                null,
                null);
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if (cursorCount > 0)
        {
            return true;
        }
        return false;
    }

    //Test for getting first name to main page
    public String getFirstName() throws SQLException {
        String firstName = "";
        Cursor cursor = this.getReadableDatabase().query(
                TABLE_USER, new String[] { COLUMN_FIRST_NAME },
                null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                firstName = cursor.getString(0);
            } while (cursor.moveToNext());
        }
        cursor.close();

        return firstName;
    }

}

