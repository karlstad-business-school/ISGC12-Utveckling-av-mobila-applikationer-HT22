package com.example.exempel_intent_skicka_data;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b = findViewById(R.id.button);
        EditText etString = findViewById(R.id.text_string);
        EditText etInt = findViewById(R.id.text_int);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, getData.class);
                intent.putExtra("text_string", etString.getText().toString());
                intent.putExtra("text_int", Integer.parseInt(etInt.getText().toString()));
                startActivity(intent);
            }
        });
    }
}