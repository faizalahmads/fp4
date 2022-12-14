package com.faizalas.dev.finalproject4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SeatSelection extends AppCompatActivity {

    Button btncardpay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat_selection);

        btncardpay = findViewById(R.id.btncardpay);

        btncardpay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SeatSelection.this, payment_activity.class);
                startActivity(i);
            }
        });

    }
    public void cardpay(View view) {
        Intent intent = new Intent(SeatSelection.this, payment_activity.class);
        startActivity(intent);
    }
}