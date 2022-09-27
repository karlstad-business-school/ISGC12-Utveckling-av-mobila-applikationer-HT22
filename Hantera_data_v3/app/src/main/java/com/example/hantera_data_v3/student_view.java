package com.example.hantera_data_v3;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class student_view extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_view);


        Intent intent = getIntent();
        if(intent.hasExtra("student_id")){
            int id = intent.getIntExtra("student_id", -1);
            Student student = Database.getInstance().get(id);

            if(student == null){
                return;
            }

            TextView namnTV = findViewById(R.id.student_view_namn);
            namnTV.setText(student.getName());
            TextView idTV = findViewById(R.id.student_view_id);
            idTV.setText("ID: " + student.getId());
            TextView pnrTV = findViewById(R.id.student_view_pnr);
            pnrTV.setText("Personnummer: " + student.getpNr());

            Button b = findViewById(R.id.remove_btn);
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Database.getInstance().remove(id);
                    finish();
                }
            });
        }
    }
}