package com.faizalas.dev.finalproject4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class addbus extends AppCompatActivity {
    
    Button addbus, logout;
    EditText busid, from, to, dt, seats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addbus);

        busid = findViewById(R.id.id);
        from = findViewById(R.id.from);
        to = findViewById(R.id.to);
        dt = findViewById(R.id.date);
        seats = findViewById(R.id.seats);
        addbus = findViewById(R.id.addbus);
        logout = findViewById(R.id.button2);
        DBHelper DB = new DBHelper(this);
        
        addbus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = busid.getText().toString();
                String departure = from.getText().toString();
                String arrival = to.getText().toString();
                String date = dt.getText().toString();
                String total_seats = seats.getText().toString();
                
                if (id.equals("") || departure.equals("") || arrival.equals("") || date.equals("") || seats.equals("")){
                    Toast.makeText(addbus.this, "Please enter all field", Toast.LENGTH_SHORT).show();
                }
                else {
                    Boolean checkid = DB.checkid(id);
                    if (checkid==false){
                        Boolean insert = DB.insertBus(id,departure,arrival,date,total_seats);
                        if (insert==true){
                            Toast.makeText(addbus.this, "Bus has been added", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), adminpanel.class);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(addbus.this, "ERROR", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(addbus.this, "ID already exists", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), adminpanel.class);
                startActivity(intent);
            }
        });
    }
}