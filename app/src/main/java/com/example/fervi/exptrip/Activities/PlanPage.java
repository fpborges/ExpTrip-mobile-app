package com.example.fervi.exptrip.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.fervi.exptrip.Activities.CreatePlanPage;
import com.example.fervi.exptrip.Database.DataBaseHelper;
import com.example.fervi.exptrip.R;

public class PlanPage extends AppCompatActivity {

    private TextView textViewUserEmail;
    private DataBaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_page);

        textViewUserEmail = (TextView) findViewById(R.id.welcomeUser);
        //textViewUserName.setText("Welcome " + databaseHelper.getFirstName());
        String nameFromIntent = getIntent().getStringExtra("EMAIL");
        textViewUserEmail.setText("Welcome " + nameFromIntent);

    }

    public void SendCreate(View view){
        Intent intent = new Intent(this, CreatePlanPage.class);
        startActivity(intent);
    }
}
