package com.example.presentasi.koleksibukuapp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //1
    ListView listViewBuku;
    ArrayList<String> koleksiBuku;
    ArrayAdapter<String> adapter;
    FloatingActionButton nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //2
        listViewBuku = (ListView) findViewById(R.id.listViewBuku);
        nextButton = (FloatingActionButton) findViewById(R.id.floatingActionButton2);
        koleksiBuku = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, koleksiBuku);
        listViewBuku.setAdapter(adapter);

        //3
        koleksiBuku.add("Pemrograman Android untuk Pemula");
        koleksiBuku.add("Pemrograman Android tingkat mahir");
        koleksiBuku.add("1001 Pemrograman C++");
        koleksiBuku.add("Proyek Game menggunakan Python");
        koleksiBuku.add("NodeJS vs Golang");
        koleksiBuku.add("Mechine Learning with Python");

        //4
        adapter.notifyDataSetChanged();

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextIntent = new Intent(MainActivity.this, AddBookActivity.class);
                startActivity(nextIntent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("coba","on resume");
        if (getIntent().getStringExtra("new_entry") != null){
            String newEntry = getIntent().getStringExtra("new_entry");
            koleksiBuku.add(newEntry);
            adapter.notifyDataSetChanged();
        }

    }
}
