/**
 * Created by Fernando Pereira Borges
 * Assignment2 - Mobile Development 2
 * Date: November 03, 2017
 * Purpose: Database implementation - user Database
 */
package com.example.fervi.exptrip.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.fervi.exptrip.Database.DataBaseHelper;
import com.example.fervi.exptrip.Model.plan;
import com.example.fervi.exptrip.R;

public class CreatePlanPage extends AppCompatActivity{

    private final AppCompatActivity activity = CreatePlanPage.this;

    private EditText txtPlanName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_plan_page);

        txtPlanName = (EditText)findViewById(R.id.txtPlanName);

    }
    public void sendCreate2(View view) {
        Intent intent = new Intent(this, CreatePlan2.class);
        startActivity(intent);
    }
    public void sendToMap(View view) {
        Intent intent = new Intent(this, MapPage.class);
        startActivity(intent);
    }
}

/*
user.setFirst_name(txtFirstName.getText().toString().trim());
        user.setLast_name(txtLastName.getText().toString().trim());
        user.setCountry(txtCountry.getText().toString().trim());
        user.setEmail(txtEmail.getText().toString().trim());
        user.setPassword(txtPassword.getText().toString().trim());

        databaseHelper.addUser(user);

        Toast.makeText(this, SuccessMessage, Toast.LENGTH_LONG).show();

        startActivity(new Intent(this, LoginPage.class)); */