package com.example.exempel_skicka_objekt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class student_view extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_view);

        Intent intent = getIntent();
        Student student = (Student) intent.getSerializableExtra("student");

        TextView text = findViewById(R.id.student_text);
        text.setText("ID: " + student.getId() + "\nNamn: " + student.getNamn() + "\nPNR: " + student.getPnr());
    }
}