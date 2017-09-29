package com.example.fervi.exptrip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginPage extends AppCompatActivity {

    private EditText txtEmail;
    private EditText txtPassword;
    Button btnSignIn;
    // Error Messages
    private static final String empty_field = "required";
    private static final String email_msg = "invalid email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        btnSignIn = (Button)findViewById(R.id.btnSignIn);
        txtEmail = (EditText)findViewById(R.id.txtEmail);
        txtPassword = (EditText)findViewById(R.id.txtPassword);

        btnSignIn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                validationFields();
            }
        });

    }
    public void validationFields(){
        txtEmail.setError(null);
        txtPassword.setError(null);
        String userEmail = txtEmail.getText().toString();
        String userPassword = txtPassword.getText().toString();

        /*
        if (userEmail.isEmpty()) {
            txtEmail.setError(empty_field);
        }

        if( userPassword.isEmpty()) {
            txtEmail.setError(empty_field);
        }
        */

        if(userEmail.equals("test@test.com") && userPassword.equals("test"))
        {
            txtEmail.setError(null);
            txtPassword.setError(null);
            sendLogin();
        }
        else if(userEmail.isEmpty() || userPassword.isEmpty())
        {
            Toast.makeText(this, "Email and Password are Required!", Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(this, "Account does not exist please try email 'test@test.com' " +
                    "and password 'test'!", Toast.LENGTH_LONG).show();
        }
    }

    public void sendRegister(View view) {
        Intent intent = new Intent(this, RegisterPage.class);
        startActivity(intent);
    }
    public void sendLogin() {
        Intent intent = new Intent(this, PlanPage.class);
        startActivity(intent);
    }

}
