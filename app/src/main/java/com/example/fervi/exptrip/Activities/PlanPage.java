/**
 * Created by Fernando Pereira Borges
 * Assignment2 - Mobile Development 2
 * Date: November 03, 2017
 * Purpose: Database implementation - user Database
 */
package com.example.fervi.exptrip.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fervi.exptrip.Database.DataBaseHelper;
import com.example.fervi.exptrip.R;

import java.util.ArrayList;

import static com.example.fervi.exptrip.Activities.LoginPage.MY_PREF_NAME;

public class PlanPage extends AppCompatActivity implements View.OnClickListener {

    private final AppCompatActivity activity = PlanPage.this;

    private TextView textViewFirstName;
    private DataBaseHelper databaseHelper;
    private Button btnProfile;
    private Button btnGoToCreate;
    public String cur_email;
    Cursor cursor;
    SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_page);

        ListView listView = (ListView) findViewById(R.id.planList);

        databaseHelper = new DataBaseHelper(activity);
        db = databaseHelper.getReadableDatabase();

        btnProfile = (Button)findViewById(R.id.btnProfile);
        btnGoToCreate = (Button)findViewById(R.id.btnGoCreate);

        textViewFirstName = (TextView)findViewById(R.id.welcomeUser);

        //USING SHARED PREFERENCES TO RETRIEVE THE EMAIL:
        SharedPreferences prefs = getSharedPreferences(MY_PREF_NAME, MODE_PRIVATE);
        cur_email = prefs.getString("CUR_EMAIL", "No name defined");//"No name defined" is the default value.

        //textViewFirstName.setText(cur_email);

        ArrayList<String> plan_list = new ArrayList<>();
        ArrayList<String> plan_location = new ArrayList<>();
        Cursor planData = databaseHelper.getPlanList();
        Cursor planLocation = databaseHelper.getLocation();
        if(planData.getCount() == 0 && planLocation.getCount() == 0)
        {
            Toast.makeText(this, "no data found", Toast.LENGTH_LONG).show();
        }
        else{
            while(planData.moveToNext() && planLocation.moveToNext())
            {
                plan_list.add(planData.getString(1));
                plan_location.add(planLocation.getString(1));
                ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,plan_list);
                listView.setAdapter(listAdapter);
            }
        }

        btnGoToCreate.setOnClickListener(this);
        btnProfile.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnProfile:
                ViewProfile();
                break;
            case R.id.btnGoCreate:
                startActivity(new Intent(PlanPage.this, CreatePlanPage.class));
                break;
        }
    }

    public void ViewProfile()
    {
        cursor = db.rawQuery("SELECT * FROM " + DataBaseHelper.TABLE_USER
                + " WHERE "+ DataBaseHelper.COLUMN_EMAIL+"=? ", new String[]{cur_email});
        if(cursor != null)
        {
            if(cursor.getCount() > 0)
            {
                cursor.moveToFirst();
                String fName = cursor.getString(cursor.getColumnIndex(DataBaseHelper.COLUMN_FIRST_NAME));
                String lName = cursor.getString(cursor.getColumnIndex(DataBaseHelper.COLUMN_LAST_NAME));
                String uCountry = cursor.getString(cursor.getColumnIndex(DataBaseHelper.COLUMN_COUNTRY));
                String uEmail = cursor.getString(cursor.getColumnIndex(DataBaseHelper.COLUMN_EMAIL));
                Intent intent = new Intent(PlanPage.this, ProfilePage.class);
                intent.putExtra("F_NAME", fName);
                intent.putExtra("L_NAME", lName);
                intent.putExtra("U_COUNTRY", uCountry);
                intent.putExtra("U_EMAIL", uEmail);
                startActivity(intent);
                finish();
            }
        }
    }
}
