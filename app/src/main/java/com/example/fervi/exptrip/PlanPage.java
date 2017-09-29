package com.example.fervi.exptrip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PlanPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_page);
    }

    public void SendCreate(View view){
        Intent intent = new Intent(this, CreatePlanPage.class);
        startActivity(intent);
    }
}
