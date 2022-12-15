package com.faizalas.dev.finalproject4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SeatSelection extends AppCompatActivity {

    Button btncardpay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat_selection);

        btncardpay = findViewById(R.id.btncardpay);
        DBHelper DB = new DBHelper(this);

        btncardpay = (Button) findViewById(R.id.btncardpay);

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

//    String seats = pickseats.getText().toString();
//
//                if (seats.equals("")){
//        Toast.makeText(SeatSelection.this, "Silahkan Pilih Bangku", Toast.LENGTH_SHORT).show();
//    }
//                else{
//        Boolean insert = DB.ticket(seats);
//        if (insert==true){
//            Toast.makeText(SeatSelection.this, "Pembayaran Diterima", Toast.LENGTH_SHORT).show();
//        }
//        else {
//            Toast.makeText(SeatSelection.this, "Pembayaran Gagal", Toast.LENGTH_SHORT).show();
//        }
//    }
}