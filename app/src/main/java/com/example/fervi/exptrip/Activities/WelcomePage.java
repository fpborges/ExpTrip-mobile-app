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

import com.example.fervi.exptrip.Activities.LoginPage;
import com.example.fervi.exptrip.Activities.RegisterPage;
import com.example.fervi.exptrip.R;

public class WelcomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);
    }
    public void sendLogin(View view)
    {
        Intent intent = new Intent(this, LoginPage.class );
        startActivity(intent);
    }

    public void sendRegister(View view)
    {
        Intent intent = new Intent(this, RegisterPage.class);
        startActivity(intent);
    }
}
