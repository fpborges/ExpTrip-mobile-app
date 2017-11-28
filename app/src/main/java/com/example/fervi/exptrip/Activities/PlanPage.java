/**
 * Created by Fernando Pereira Borges
 * Assignment2 - Mobile Development 2
 * Date: November 03, 2017
 * Purpose: Database implementation - user Database
 */
package com.example.fervi.exptrip.Activities;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.fervi.exptrip.Activities.CreatePlanPage;
import com.example.fervi.exptrip.Database.DataBaseHelper;
import com.example.fervi.exptrip.R;

public class PlanPage extends AppCompatActivity {

    private TextView textViewFirstName;
    private DataBaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_page);
        databaseHelper = new DataBaseHelper(this);

        textViewFirstName = (TextView) findViewById(R.id.welcomeUser);

        String receiveEmail = getIntent().getExtras().getString("EMAIL");
        textViewFirstName.setText("Welcome " + databaseHelper.currentEmail(receiveEmail));


    }

    public void viewProfile()
    {
        Cursor profile = databaseHelper.getProfile();
        if(profile.getCount() == 0)
        {
            return;
        }
        StringBuffer buffer = new StringBuffer();
        while (profile.moveToNext()){
            buffer.append("Welcome " + profile.getString(1));
        }
        textViewFirstName.setText(buffer.toString());
    }



    public void SendCreate(View view){
        Intent intent = new Intent(this, CreatePlanPage.class);
        startActivity(intent);
    }
}
