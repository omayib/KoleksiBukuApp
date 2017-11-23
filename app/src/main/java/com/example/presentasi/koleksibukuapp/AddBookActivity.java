package com.example.presentasi.koleksibukuapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddBookActivity extends AppCompatActivity {
    Button buttonSubmit;
    EditText editTextJudul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);

        buttonSubmit = (Button) findViewById(R.id.buttonSubmit);
        editTextJudul = (EditText) findViewById(R.id.editTextJudul);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newEntry = editTextJudul.getText().toString();
                Intent nextIntent = new Intent(AddBookActivity.this, MainActivity.class);
                nextIntent.putExtra("new_entry",newEntry );
                startActivity(nextIntent);
            }
        });
    }
}
