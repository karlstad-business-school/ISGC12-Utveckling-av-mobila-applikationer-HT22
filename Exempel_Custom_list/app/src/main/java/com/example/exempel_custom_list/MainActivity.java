package com.example.exempel_custom_list;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lv = findViewById(R.id.list_view);
        lv.setAdapter(new CustomListAdapter(this, R.layout.list_item, getStudentList()));
    }

    public ArrayList<Student> getStudentList(){
        Student s = new Student(1, "Test");
        ArrayList list = new ArrayList<Student>();

        list.add(s);
        s = new Student(5, "ABC123");
        list.add(s);
        s = new Student(12, "Hello World");
        list.add(s);

        return list;
    }
}