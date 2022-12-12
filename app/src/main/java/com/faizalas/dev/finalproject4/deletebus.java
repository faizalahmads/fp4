package com.faizalas.dev.finalproject4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class deletebus extends AppCompatActivity {

    Button deletebus, back;
    EditText busid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deletebus);

        busid = findViewById(R.id.busid);
        deletebus = findViewById(R.id.deletebus);
        back = findViewById(R.id.button03);
        DBHelper DB = new DBHelper(this);

        deletebus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = busid.getText().toString();
                if (id.equals(""))
                {
                    Toast.makeText(deletebus.this, "Please Enter Bus ID", Toast.LENGTH_SHORT).show();
                }
                else {
                    Boolean checkid = DB.checkid(id);
                    if (checkid == true) {
                        Boolean delete = DB.deleteBus(id);
                        if (delete==true){
                            Toast.makeText(deletebus.this, "Bus delete successfully", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), adminpanel.class);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(deletebus.this, "Entry not deleted", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(deletebus.this, "ID doesnot exists", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), adminpanel.class);
                startActivity(intent);
            }
        });
    }
}