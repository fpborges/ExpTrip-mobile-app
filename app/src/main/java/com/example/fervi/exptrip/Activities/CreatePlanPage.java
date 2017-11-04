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

import com.example.fervi.exptrip.R;

public class CreatePlanPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_plan_page);
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
