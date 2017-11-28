/**
 * Created by Fernando Pereira Borges
 * Assignment2 - Mobile Development 2
 * Date: November 03, 2017
 * Purpose: Database implementation - user Database
 */

package com.example.fervi.exptrip.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.fervi.exptrip.Model.user;
import com.example.fervi.exptrip.Model.plan;
import com.example.fervi.exptrip.Model.location;

public class DataBaseHelper extends SQLiteOpenHelper {

    //Database
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "ExpTripDatabase.db";

    //user variables
    private static final String TABLE_USER= "user";
    private static final String COLUMN_USER_ID = "user_id";
    private static final String COLUMN_FIRST_NAME = "first_name";
    private static final String COLUMN_LAST_NAME = "last_name";
    private static final String COLUMN_COUNTRY = "country";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_PASSWORD = "password";

    //plan variables
    private static final String TABLE_PLAN = "plan";
    private static final String COLUMN_PLAN_ID = "plan_id";
    private static final String COLUMN_PLAN_NAME = "plan_name";
    private static final String COLUMN_BUDGET = "budget";
    private static final String COLUMN_DESCRIPTION = "description";

    //plan_location variables
    private static final String TABLE_PLAN_LOCATION = "plan_location";
    private static final String COLUMN_KEY_ID = "id";


    //location variables
    private static final String TABLE_LOCATION= "location";
    private static final String COLUMN_LOCATION_ID = "location_id";
    private static final String COLUMN_LOCATION_NAME = "location_name";
    private static final String COLUMN_START_DATE = "start_date";
    private static final String COLUMN_END_DATE = "end_date";


    //Create user table
    private String CREATE_TABLE_USER = "CREATE TABLE " + TABLE_USER +
            " (" + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            COLUMN_FIRST_NAME + " TEXT," +
            COLUMN_LAST_NAME + " TEXT," +
            COLUMN_COUNTRY + " TEXT," +
            COLUMN_EMAIL + " TEXT," +
            COLUMN_PASSWORD + " TEXT" + ")";



    //create plan table
    private String CREATE_TABLE_PLAN = "CREATE TABLE " + TABLE_PLAN +
            " (" + COLUMN_PLAN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            COLUMN_PLAN_NAME + " TEXT," +
            COLUMN_BUDGET + " DOUBLE," +
            COLUMN_DESCRIPTION + " TEXT," +
            COLUMN_USER_ID + " INTEGER,"
            + " FOREIGN KEY ("+COLUMN_USER_ID+") REFERENCES " + TABLE_USER + "("+COLUMN_USER_ID+"));";



    //create location table
    private String CREATE_TABLE_LOCATION = "CREATE TABLE " + TABLE_LOCATION +
            " (" + COLUMN_LOCATION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            COLUMN_LOCATION_NAME + " TEXT," +
            COLUMN_START_DATE + " TEXT," +
            COLUMN_END_DATE + " TEXT" + ")";


    //create plan_location table
     private String CREATE_TABLE_PLAN_LOCATION = "CREATE TABLE " + TABLE_PLAN_LOCATION +
           " (" + COLUMN_KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            COLUMN_PLAN_ID + " INTEGER," + COLUMN_LOCATION_ID + " INTEGER" + ")";


    private String DROP_TABLE_USER = "DROP TABLE IF EXISTS " + TABLE_USER;

    private String DROP_TABLE_PLAN = "DROP TABLE IF EXISTS " + TABLE_PLAN;

    private String DROP_TABLE_LOCATION = "DROP TABLE IF EXISTS " + TABLE_LOCATION;

    private String DROP_TABLE_PLAN_LOCATION = "DROP TABLE IF EXISTS " + TABLE_PLAN_LOCATION;

    public DataBaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(CREATE_TABLE_USER);
        db.execSQL(CREATE_TABLE_PLAN);
        db.execSQL(CREATE_TABLE_LOCATION);
        db.execSQL(CREATE_TABLE_PLAN_LOCATION);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL(DROP_TABLE_USER);
        db.execSQL(DROP_TABLE_PLAN);
        db.execSQL(DROP_TABLE_LOCATION);
        db.execSQL(DROP_TABLE_PLAN_LOCATION);
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

    public void addPlan(plan plan)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_PLAN_NAME, plan.getPlan_name());
        values.put(COLUMN_BUDGET, plan.getBudget());
        values.put(COLUMN_DESCRIPTION, plan.getDescription());

        db.insert(TABLE_PLAN, null, values);
        db.close();
    }

    public void addLocation(location location)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_LOCATION_NAME, location.getLocation_name());
        values.put(COLUMN_START_DATE, location.getStart_date());
        values.put(COLUMN_END_DATE, location.getEnd_date());

        db.insert(TABLE_LOCATION, null, values);
        db.close();
    }

    //check
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

        //Method to get all information from user
    public Cursor getProfile(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor profile = db.rawQuery("SELECT * FROM " + TABLE_USER, null);
        return profile;
    }

    //Get the first name of user
    public String currentEmail(String curEmail)
    {
        String firstName = "";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT " + COLUMN_FIRST_NAME + " FROM " + TABLE_USER + " WHERE TRIM(email) = '"+curEmail.trim()+"'", null);
        if (c.moveToFirst()) {
            do {
                firstName = c.getString(0);
            } while (c.moveToNext());
        }
        c.close();

        return firstName;
    }
}

