package com.faizalas.dev.finalproject4;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class payment_activity extends AppCompatActivity {

    Button buy, cancel, back;
    EditText jumlahPembayaran;

    RadioGroup radioGroup;
    RadioButton radioButton;

    SharedPreferences sharedPreferences;
    private static final String SHARED_PREF = "myPref";
    private static final String IS_CHECKED = "isChecked";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        buy = findViewById(R.id.btnBuy);
        cancel = findViewById(R.id.button05);
        back = findViewById(R.id.btnBack);

        jumlahPembayaran = findViewById(R.id.jumlahPembayaran);

        radioGroup = findViewById(R.id.radioGroup);

        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int jumlahInt = Integer.parseInt(jumlahPembayaran.getText().toString());

                    int radioChecked = radioGroup.getCheckedRadioButtonId();
                    radioButton = findViewById(radioChecked);

                    if(jumlahInt == 0){
                        Toast.makeText(payment_activity.this, "Masukkan jumlah pembayaran", Toast.LENGTH_SHORT).show();
                    }
                    else if ((jumlahInt < 35000) || (jumlahInt > 35000)){
                        Toast.makeText(payment_activity.this, "Jumlah yang dimasukkan tidak Valid", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        alert("Apakah anda yakin membayar sebesar Rp." + jumlahInt + " dengan " + radioButton.getText() + " anda?");
                    }
                }
                catch (NumberFormatException exception){
                    Toast.makeText(payment_activity.this, "Masukkan jumlah pembayaran", Toast.LENGTH_SHORT).show();
                }

            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SeatSelection.class);
                startActivity(intent);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),SeatSelection.class);
                startActivity(intent);
            }
        });

    }

    private void alert(String confirmation){
        AlertDialog dlg = new AlertDialog.Builder(payment_activity.this)
                .setTitle("Confirmation")
                .setMessage(confirmation)
                .setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Intent intent = new Intent(payment_activity.this, SeatSelection.class);
                        startActivity(intent);

                        sharedPreferences = getSharedPreferences(SHARED_PREF,MODE_PRIVATE);
                        boolean isChecked = sharedPreferences.getBoolean(IS_CHECKED, true);

                        isChecked = true;

                        Toast.makeText(payment_activity.this, "Pembayaran Berhasil", Toast.LENGTH_SHORT).show();
                        dialogInterface.dismiss();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(payment_activity.this, "Pembayaran dibatalkan", Toast.LENGTH_SHORT).show();
                        dialogInterface.dismiss();
                    }
                })
                .create();
        dlg.show();
        dlg.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(ContextCompat.getColor(this,R.color.main_color));
        dlg.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(ContextCompat.getColor(this,R.color.main_color));
    }
}