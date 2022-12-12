package com.faizalas.dev.finalproject4;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class adminpanel extends AppCompatActivity {
    
    Button add, update, delete, view, logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminpanel);
        
        add = findViewById(R.id.btn_add);
        update = findViewById(R.id.btn_update);
        delete = findViewById(R.id.btn_delete);
        view = findViewById(R.id.btn_View);
        logout = findViewById(R.id.btn_logout);
        DBHelper DB = new DBHelper(this);
        
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), addbus.class);
                startActivity(intent);
            }
        });
        
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), updatebus.class);
                startActivity(intent);
            }
        });
        
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), deletebus.class);
                startActivity(intent);
            }
        });
        
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor result = DB.viewbuses();
                if (result.getCount()==0){
                    Toast.makeText(adminpanel.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (result.moveToNext()){
                    buffer.append("ID"+result.getString(0)+"\n");
                    buffer.append("Departure"+result.getString(1)+"\n");
                    buffer.append("Arrival"+result.getString(2)+"\n");
                    buffer.append("Date"+result.getString(3)+"\n");
                    buffer.append("Total Seates"+result.getString(4)+"\n\n");
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(adminpanel.this);
                builder.setCancelable(true);
                builder.setTitle("ALL BUSES DETAILS");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}