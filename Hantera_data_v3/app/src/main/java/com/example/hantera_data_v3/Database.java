package com.example.hantera_data_v3;
import android.util.Log;

import java.util.ArrayList;

public class Database {
    private ArrayList<Student> students;

    public static Database instance;

    public Database(){
        students = new ArrayList<Student>();
    }

    public static Database getInstance(){
        if(instance == null){
            instance = new Database();
        }

        return instance;
    }

    public void add(Student s){
        students.add(s);
    }

    public void remove(int id){
        Student s = null;
        for(int i = 0; i < students.size(); i++){
            if(students.get(i).getId() == id){
                students.remove(students.get(i));
                break;
            }
        }
    }

    public Student get(int id){
        for(int i = 0; i < students.size(); i++){
            if(students.get(i).getId() == id){
                return students.get(i);
            }
        }

        return null;
    }

    public String printStudents(){
        String print = "";

        for(int i = 0; i < students.size(); i++){
            print += students.get(i).getId() + " ";
            print += students.get(i).getName() + " ";
            print += students.get(i).getpNr() + "\n";
        }

        return print;
    }

    public ArrayList<Student> getStudents(){
        return this.students;
    }
}