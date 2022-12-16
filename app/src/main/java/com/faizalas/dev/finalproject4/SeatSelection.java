package com.faizalas.dev.finalproject4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SeatSelection extends AppCompatActivity {

    Button btncardpay;
    EditText seatSelection;


    SharedPreferences sharedPreferences;
    private static final String SHARED_PREF = "myPref";
    private static final String IS_CHECKED = "isChecked";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat_selection);

        btncardpay = findViewById(R.id.btncardpay);
        seatSelection = findViewById(R.id.editTextTextPersonName);
        DBHelper DB = new DBHelper(this);

        btncardpay = (Button) findViewById(R.id.btncardpay);


        btncardpay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String seats = seatSelection.getText().toString();

                if (seats.equals("")){
                    Toast.makeText(SeatSelection.this, "Silahkan Pilih Bangku", Toast.LENGTH_SHORT).show();
                }
                else{
                    switch (seats){
                        case "A1":
                            cekKetersediaan();
                            break;

                        case "A2":
                            cekKetersediaan();
                            break;

                        case "A3":
                            cekKetersediaan();
                            break;

                        case "A4":
                            cekKetersediaan();
                            break;

                        case "A5":
                            cekKetersediaan();
                            break;

                        case "A6":
                            cekKetersediaan();
                            break;

                        case "A7":
                            cekKetersediaan();
                            break;

                        case "A8":
                            cekKetersediaan();
                            break;

                        case "B1":
                            cekKetersediaan();
                            break;

                        case "B2":
                            cekKetersediaan();
                            break;

                        case "B3":
                            cekKetersediaan();
                            break;

                        case "B4":
                            cekKetersediaan();
                            break;

                        case "B5":
                            cekKetersediaan();
                            break;

                        case "B6":
                            cekKetersediaan();
                            break;

                        case "B7":
                            cekKetersediaan();
                            break;

                        case "B8":
                            cekKetersediaan();
                            break;

                        case "C1":
                            cekKetersediaan();
                            break;

                        case "C2":
                            cekKetersediaan();
                            break;

                        case "C3":
                            cekKetersediaan();
                            break;

                        case "C4":
                            cekKetersediaan();
                            break;

                        case "C5":
                            cekKetersediaan();
                            break;

                        case "C6":
                            cekKetersediaan();
                            break;

                        case "C7":
                            cekKetersediaan();
                            break;

                        case "C8":
                            cekKetersediaan();
                            break;

                        case "D1":
                            cekKetersediaan();
                            break;

                        case "D2":
                            cekKetersediaan();
                            break;

                        case "D3":
                            cekKetersediaan();
                            break;

                        case "D4":
                            cekKetersediaan();
                            break;

                        case "D5":
                            cekKetersediaan();
                            break;

                        case "D6":
                            cekKetersediaan();
                            break;

                        case "D7":
                            cekKetersediaan();
                            break;

                        case "D8":
                            cekKetersediaan();
                            break;

                        case "E1":
                            cekKetersediaan();
                            break;

                        case "E2":
                            cekKetersediaan();
                            break;

                        case "E3":
                            cekKetersediaan();
                            break;

                        case "E4":
                            cekKetersediaan();
                            break;

                        default:
                            Toast.makeText(SeatSelection.this, "Tidak Tersedia", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }

            }
        });


    }
    public void cardpay(View view) {
        Intent intent = new Intent(SeatSelection.this, payment_activity.class);
        startActivity(intent);

    }

    public void cekKetersediaan(){

        sharedPreferences = getSharedPreferences(SHARED_PREF, MODE_PRIVATE);
        boolean isChecked = sharedPreferences.getBoolean(IS_CHECKED, false);

        if(!isChecked){
            Intent intent = new Intent(SeatSelection.this, payment_activity.class);
            startActivity(intent);
        }
        else if(isChecked){
            Toast.makeText(this, "Sudah diambil,silahkan pilih yang lain", Toast.LENGTH_SHORT).show();
        }

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(IS_CHECKED, true);

    }
}