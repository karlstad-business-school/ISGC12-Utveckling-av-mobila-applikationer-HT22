package com.example.hantera_data_v3;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Database database;

    private EditText id_ET, namn_ET, pnr_ET;
    //private TextView stundet_list_TV;
    private StudentListAdapter sla;
    private ListView student_list;
    private Button addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = Database.getInstance();

        sla = new StudentListAdapter(this, R.layout.list_item, Database.getInstance().getStudents());
        student_list = findViewById(R.id.student_list);
        student_list.setAdapter(sla);


        id_ET = findViewById(R.id.student_id);
        namn_ET = findViewById(R.id.student_namn);
        pnr_ET = findViewById(R.id.student_pnr);

        addBtn = findViewById(R.id.add_btn);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = Integer.parseInt(id_ET.getText().toString());
                String namn = namn_ET.getText().toString();
                String pnr = pnr_ET.getText().toString();
                saveStudent(id, namn, pnr);
            }
        });
    }

    @Override
    public void onResume(){
        super.onResume();
        updateStudentList();
    }


    public void searchStudent(View view){
        EditText sId = (EditText)findViewById(R.id.search_id);
        if(!sId.getText().toString().matches("")){
            int id = Integer.parseInt(sId.getText().toString());
            Student student = Database.instance.get(id);
            if(student != null){
                Intent intent = new Intent(MainActivity.this, student_view.class);
                intent.putExtra("student_id", id);
                startActivity(intent);
                sId.setText("");
            }else{
                Toast.makeText(getApplicationContext(), "Studenten med ID: " + id + " finns inte i v??r databas!", Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(getApplicationContext(), "Du m??ste ange ett ID", Toast.LENGTH_LONG).show();
        }

    }


    private  void saveStudent(int id, String namn, String pnr){
        Student s = new Student(id, namn, pnr);
        database.add(s);

        id_ET.setText("");
        namn_ET.setText("");
        pnr_ET.setText("");
        updateStudentList();
    }


    private void updateStudentList(){
        /*String students = database.printStudents();
        if(students == ""){
            students = "Det finns inga studenter i databasen";
        }else{

        }
        stundet_list_TV.setText(students);*/
        sla.update(Database.getInstance().getStudents());
    }
}