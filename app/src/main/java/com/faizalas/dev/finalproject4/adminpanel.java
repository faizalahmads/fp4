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

    Button add, update, delete, view, end;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminpanel);

        add = findViewById(R.id.add);
        update=findViewById(R.id.update);
        delete=findViewById(R.id.delete);
        view = findViewById(R.id.view);
        end = findViewById(R.id.logout);
        DBHelper DB = new DBHelper(this);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), addbus.class);
                startActivity(intent);
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), updatebus.class);
                startActivity(intent);
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), deletebus.class);
                startActivity(intent);
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor result = DB.viewbuses();
                if (result.getCount()==0){
                    Toast.makeText(adminpanel.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (result.moveToNext()){
                    buffer.append("ID :"+result.getString(0)+"\n");
                    buffer.append("Kota Asal :"+result.getString(1)+"\n");
                    buffer.append("Kota Tujuan :"+result.getString(2)+"\n");
                    buffer.append("Tanggal :"+result.getString(3)+"\n");
                    buffer.append("Total Bangku :"+result.getString(4)+"\n\n");
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(adminpanel.this);
                builder.setCancelable(true);
                builder.setTitle("DETAIL BUS");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });
        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}