package com.faizalas.dev.finalproject4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class adminlogin extends AppCompatActivity {

    EditText username, password;
    Button login, signup, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlogin);

        username = findViewById(R.id.user);
        password = findViewById(R.id.pass);
        login = findViewById(R.id.btn_login);
        signup = findViewById(R.id.btn_signUp);
        back = findViewById(R.id.btn_Back);
        DBHelper DB = new DBHelper(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if (user.equals("") || pass.equals(""))
                    Toast.makeText(adminlogin.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkadminuserpass = DB.checkadminusernamepassword(user, pass);
                    if (checkadminuserpass==true){
                        Toast.makeText(adminlogin.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), adminpanel.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(adminlogin.this, "Invalid Credential", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), adminsignup.class);
                startActivity(intent);
            }
        });
    }
}