package com.faizalas.dev.finalproject4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class adminsignup extends AppCompatActivity {

    Button signUp, signIn;
    EditText et1, et2, et3, et4, et5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminsignup);

        signUp = findViewById(R.id.btn1);
        signIn = findViewById(R.id.btn2);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        et3 = findViewById(R.id.et3);
        et4 = findViewById(R.id.et4);
        et5 = findViewById(R.id.et5);
        DBHelper DB = new DBHelper(this);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullname = et1.getText().toString();
                String email = et2.getText().toString();
                String username = et3.getText().toString();
                String password = et4.getText().toString();
                String code = et5.getText().toString();

                if (fullname.equals("") || email.equals("") || username.equals("") || password.equals("") || code.equals(""))
                    Toast.makeText(adminsignup.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkadminuser = DB.checkadminusername(username);
                    if (checkadminuser==false){
                        if (code.equals("6958")){
                            Boolean insert = DB.insertadmin(fullname,email,username,password);
                            if (insert==true){
                                Toast.makeText(adminsignup.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), adminlogin.class);
                                startActivity(intent);
                            }
                            else {
                                Toast.makeText(adminsignup.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(adminsignup.this, "The Admin Code is Wrong", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(adminsignup.this, "User Already exists please signIN", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), adminlogin.class);
                        startActivity(intent);
                    }
                }
            }
        });
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), adminlogin.class);
                startActivity(intent);
            }
        });
    }
}