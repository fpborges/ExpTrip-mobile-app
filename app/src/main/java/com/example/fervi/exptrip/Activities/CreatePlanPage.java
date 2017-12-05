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
import android.widget.Toast;

import com.example.fervi.exptrip.R;

public class CreatePlanPage extends AppCompatActivity implements View.OnClickListener{


    private EditText txtPlanName;
    private EditText txtLocation;
    private Button btnNext;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_plan_page);

        txtPlanName = (EditText)findViewById(R.id.txtPlanName);
        txtLocation = (EditText)findViewById(R.id.txtWhere);
        btnNext = (Button)findViewById(R.id.btnGoCreate);

        btnNext.setOnClickListener(this);

    }

    public void sendToMap(View view) {
        Intent intent = new Intent(this, MapPage.class);
        startActivity(intent);
    }

    public void ValidateCreatePlan1()
    {
        String planName = txtPlanName.getText().toString();
        String locationName = txtLocation.getText().toString();

        if(planName.isEmpty() || locationName.isEmpty())
        {
            Toast.makeText(this, "Please enter Plan name and location name", Toast.LENGTH_LONG).show();
        }
        else
        {
            Intent  nextPage = new Intent(CreatePlanPage.this, CreatePlan2.class);
            nextPage.putExtra("PLAN_NAME", planName.trim());
            nextPage.putExtra("LOCATION_NAME", locationName.trim());
            startActivity(nextPage);
        }
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnGoCreate:
                ValidateCreatePlan1();
                break;
        }
    }
}

