package com.example.fervi.exptrip.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.fervi.exptrip.Database.DataBaseHelper;
import com.example.fervi.exptrip.R;

import static com.example.fervi.exptrip.R.id.textViewLastName;
import static com.example.fervi.exptrip.R.id.textViewLname;
import static com.example.fervi.exptrip.R.id.textViewLocation;

public class PlanProfile extends AppCompatActivity {

    DataBaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_profile);
        databaseHelper = new DataBaseHelper(this);

        EditText textViewPlanName = (EditText)findViewById(R.id.textViewPname);
        EditText textViewLocationName = (EditText)findViewById(textViewLname);
        EditText textViewStartDate = (EditText)findViewById(R.id.textViewSdate);
        EditText textViewEndDate = (EditText)findViewById(R.id.textViewEdate);
        EditText textViewBudget = (EditText)findViewById(R.id.textViewPbudget);
        EditText txtDescription = (EditText)findViewById(R.id.editTextDesc);

        Intent intent = getIntent();

        String p_name = intent.getStringExtra("P_NAME");
        String l_name = intent.getStringExtra("P_LOCATION");
        String s_date = intent.getStringExtra("S_DATE");
        String e_date = intent.getStringExtra("E_DATE");
        String stringDoubleBudget= Double.toString(getIntent().getDoubleExtra("P_BUDGET", 0));
        String p_desc = intent.getStringExtra("P_DESC");

        textViewPlanName.setText(p_name);
        textViewLocationName.setText(l_name);
        textViewStartDate.setText(s_date);
        textViewEndDate.setText(e_date);
        textViewBudget.setText(stringDoubleBudget);
        txtDescription.setText(p_desc);
    }
}
