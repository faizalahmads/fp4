package com.faizalas.dev.finalproject4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText username, password;
    Button login, back, signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.user);
        password = findViewById(R.id.pass);
        login = findViewById(R.id.btn_login);
        back = findViewById(R.id.btn_Back);
        signUp = findViewById(R.id.btn_signUp);
        DBHelper DB = new DBHelper(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if (user.equals("") || pass.equals(""))
                    Toast.makeText(Login.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass = DB.checkusernamepassword(user, pass);
                    if (checkuserpass==true){
                        Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), Booking.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(Login.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
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

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SignUp.class);
            }
        });
    }
}