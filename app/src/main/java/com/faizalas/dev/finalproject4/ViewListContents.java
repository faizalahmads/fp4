package com.faizalas.dev.finalproject4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ViewListContents extends AppCompatActivity {

    DBHelper myDB;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_list_contents);

        ListView listView = (ListView) findViewById(R.id.listView);
        myDB = new DBHelper(this);

        //populate an ArrayList<String> from the database and then view it
        ArrayList<String> theList = new ArrayList<>();
        Cursor data = myDB.viewbuses();
        if(data.getCount() == 0){
            Toast.makeText(this, "There are no contents in this list!",Toast.LENGTH_LONG).show();
        }else{
            while(data.moveToNext()) {

                theList.add("ID:"+"   "+data.getString(0)+"                             "
                        +"Kota Asal:"+"  "+data.getString(1) +"                             "
                        +"Kota Tujuan:"+"  "+data.getString(2)+"                              "
                        +"Tanggal:"+"  " +data.getString(3)+"                              "
                        +"Total Bangku:"+"  "+data.getString(4));
                theList.add("");


                ListAdapter listAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,theList);
                listView.setAdapter(listAdapter);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        if (position == 0){
                            Intent intent = new Intent(view.getContext(), SeatSelection.class);
                            startActivity(intent);
                        }
                        if (position == 2){
                            Intent intent = new Intent(view.getContext(), SeatSelection.class);
                            startActivity(intent);
                        }
                        if (position == 4){
                            Intent intent = new Intent(view.getContext(), SeatSelection.class);
                            startActivity(intent);
                        }
                        if (position == 6){
                            Intent intent = new Intent(view.getContext(), SeatSelection.class);
                            startActivity(intent);
                        }
                        if (position == 8){
                            Intent intent = new Intent(view.getContext(), SeatSelection.class);
                            startActivity(intent);
                        }
                        if (position == 10){
                            Intent intent = new Intent(view.getContext(), SeatSelection.class);
                            startActivity(intent);
                        }
                        if (position == 12){
                            Intent intent = new Intent(view.getContext(), SeatSelection.class);
                            startActivity(intent);
                        }
                        if (position == 14){
                            Intent intent = new Intent(view.getContext(), SeatSelection.class);
                            startActivity(intent);
                        }
                        if (position == 16){
                            Intent intent = new Intent(view.getContext(), SeatSelection.class);
                            startActivity(intent);
                        }
                        if (position == 18){
                            Intent intent = new Intent(view.getContext(), SeatSelection.class);
                            startActivity(intent);
                        }
                        if (position == 20){
                            Intent intent = new Intent(view.getContext(), SeatSelection.class);
                            startActivity(intent);
                        }
                    }
                });
            }
        }

    }
}