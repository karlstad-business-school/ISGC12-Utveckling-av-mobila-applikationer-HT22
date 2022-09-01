package com.example.exempel_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnActivity1 = findViewById(R.id.btn_activity_1);
        Button btnActivity2 = findViewById(R.id.btn_activity_2);
        Button btnActivity3 = findViewById(R.id.btn_activity_3);


        //Tänk på "this" i detta fall
        //This refererar till det vi är inte och inte enbart huvudklassen
        btnActivity1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, activity_test1.class);
                startActivity(i);
            }
        });


        btnActivity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity2();
            }
        });

        btnActivity3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String CUSTOM_ACTION = "com.example.exempel_activity.TriggerA";

                Intent i = new Intent();
                i.setAction(CUSTOM_ACTION);
                startActivity(i);
            }
        });
    }


    private void startActivity2(){
        Intent i = new Intent(this, activity_test2.class);
        startActivity(i);
    }
}