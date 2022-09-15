package com.example.exempel_async;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b = findViewById(R.id.btn);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyAsyncTask mat = new MyAsyncTask(getApplicationContext());
                mat.execute();
            }
        });
    }

    public void onResume(){
        super.onResume();

        if(getIntent().getStringExtra("result") != null){
            Toast.makeText(this, getIntent().getStringExtra("result"), Toast.LENGTH_LONG).show();
        }
    }
}