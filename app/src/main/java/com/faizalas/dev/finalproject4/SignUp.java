package com.faizalas.dev.finalproject4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    EditText et1, et2, et3, et4;
    Button btnsignup, btnsignin;
    DBHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        btnsignup = findViewById(R.id.btn1);
        btnsignin = findViewById(R.id.btn2);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        et3 = findViewById(R.id.et3);
        et4 = findViewById(R.id.et4);
        DB = new DBHelper(this);

        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullname = et1.getText().toString();
                String email = et2.getText().toString();
                String username = et3.getText().toString();
                String password = et4.getText().toString();

                if (fullname.equals("") ||email.equals("")||username.equals("")||password.equals(""))
                    Toast.makeText(SignUp.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkuser = DB.checkusername(username);
                    if (checkuser==false){
                        Boolean insert = DB.insertData(fullname,email,username,password);
                        if (insert==true){
                            Toast.makeText(SignUp.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), Login.class);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(SignUp.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(SignUp.this, "User Already exists please signin", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), Login.class);
                        startActivity(intent);
                    }
                }
            }
        });
        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
            }
        });
    }
}