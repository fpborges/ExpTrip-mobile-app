package com.example.fervi.exptrip.Activities;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fervi.exptrip.Database.DataBaseHelper;
import com.example.fervi.exptrip.Model.user;
import com.example.fervi.exptrip.R;

import static com.example.fervi.exptrip.Database.DataBaseHelper.COLUMN_COUNTRY;
import static com.example.fervi.exptrip.Database.DataBaseHelper.COLUMN_EMAIL;
import static com.example.fervi.exptrip.Database.DataBaseHelper.COLUMN_FIRST_NAME;
import static com.example.fervi.exptrip.Database.DataBaseHelper.COLUMN_LAST_NAME;
import static com.example.fervi.exptrip.Database.DataBaseHelper.COLUMN_PASSWORD;


public class ProfilePage extends AppCompatActivity implements View.OnClickListener{


    DataBaseHelper databaseHelper;
    public EditText textViewFirstName;
    public EditText textViewLastName;
    public EditText textViewCountry;
    public EditText textViewEmail;
    public EditText textViewPassword;
    private Button btnBack;
    private Button btnUpdate;
    private Button btnDelete;
    public String current_email;
    public static final String MY_PREF_NAME = "UserEmail";
    SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);

        databaseHelper = new DataBaseHelper(this);

        btnBack = (Button)findViewById(R.id.btnBack);
        btnUpdate = (Button)findViewById(R.id.btnUpdate);
        btnDelete = (Button)findViewById(R.id.btnDelete);

        textViewFirstName = (EditText) findViewById(R.id.textViewName);
        textViewLastName= (EditText) findViewById(R.id.textViewLastName);
        textViewCountry = (EditText)findViewById(R.id.textViewCountry);
        textViewEmail = (EditText) findViewById(R.id.textViewEmail);
        textViewPassword = (EditText) findViewById(R.id.textViewPassword);

        //USING SHARED PREFERENCES TO RETRIEVE THE EMAIL:
        SharedPreferences prefs = getSharedPreferences(MY_PREF_NAME, MODE_PRIVATE);
        current_email = prefs.getString("CUR_EMAIL", "No name defined");//"No name defined" is the default value.

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
        btnDelete.setOnClickListener(this);

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnUpdate:
                updateUser();
                Toast.makeText(this, "User Updated", Toast.LENGTH_LONG).show();
                startActivity(new Intent(ProfilePage.this, PlanPage.class));
                break;
            case R.id.btnBack:
                startActivity(new Intent(ProfilePage.this, PlanPage.class));
                break;
            case R.id.btnDelete:
                AlertDialog diaBox = AskForDelete();
                diaBox.show();
                break;
        }
    }

    private AlertDialog AskForDelete()
    {
        AlertDialog myQuittingDialogBox =new AlertDialog.Builder(this)
                .setTitle("Delete")
                .setMessage("Do you want delete your profile?")
                .setIcon(R.drawable.delete)
                .setPositiveButton("Delete", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int whichButton) {
                        db.delete(DataBaseHelper.TABLE_USER , COLUMN_EMAIL+"=? ",
                                new String[]{current_email});
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create();
        return myQuittingDialogBox;
    }

    public void updateUser()
    {
        ContentValues data = new ContentValues();
        data.put(COLUMN_FIRST_NAME, textViewFirstName.toString().trim());
        data.put(COLUMN_LAST_NAME, textViewLastName.toString().trim());
        data.put(COLUMN_COUNTRY, textViewCountry.toString().trim());
        data.put(COLUMN_EMAIL, textViewEmail.toString().trim());
        data.put(COLUMN_PASSWORD, textViewPassword.toString().trim());
        db.update(DataBaseHelper.TABLE_USER, data, COLUMN_EMAIL+"=? ",
                new String[]{current_email});
    }
}
