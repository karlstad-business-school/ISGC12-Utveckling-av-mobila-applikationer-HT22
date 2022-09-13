package com.example.exempel_intent_skicka_data;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class getData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_data);


        Intent intent = getIntent();
        TextView stringTV = findViewById(R.id.string_text);
        TextView intTV = findViewById(R.id.int_text);

        Bundle extras = intent.getExtras();
        String text = extras.getString("text_string");

        int  number = intent.getIntExtra("text_int", -1);

        stringTV.setText(text);
        intTV.setText(String.valueOf(number));
    }
}