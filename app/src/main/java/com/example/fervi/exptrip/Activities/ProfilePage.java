package com.example.fervi.exptrip.Activities;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fervi.exptrip.Database.DataBaseHelper;
import com.example.fervi.exptrip.R;



public class ProfilePage extends AppCompatActivity implements View.OnClickListener{


    DataBaseHelper databaseHelper;
    private Button btnBack;
    private Button btnUpdate;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);

        databaseHelper = new DataBaseHelper(this);

        btnBack = (Button)findViewById(R.id.btnBack);
        btnUpdate = (Button)findViewById(R.id.btnUpdate);

        EditText textViewFirstName = (EditText) findViewById(R.id.textViewName);
        EditText textViewLastName= (EditText) findViewById(R.id.textViewLastName);
        EditText textViewCountry = (EditText)findViewById(R.id.textViewCountry);
        EditText textViewEmail = (EditText) findViewById(R.id.textViewEmail);

        Intent intent = getIntent();

        String first_name = intent.getStringExtra("F_NAME");
        String last_name = intent.getStringExtra("L_NAME");
        String country = intent.getStringExtra("U_COUNTRY");
        String user_email = intent.getStringExtra("U_EMAIL");

        textViewFirstName.setText(first_name);
        textViewLastName.setText(last_name);
        textViewCountry.setText(country);
        textViewEmail.setText(user_email);

        btnBack.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnUpdate:
                Toast.makeText(this, "Implementation soon...", Toast.LENGTH_LONG).show();
                break;
            case R.id.btnBack:
                startActivity(new Intent(ProfilePage.this, PlanPage.class));
                break;
        }
    }
}
