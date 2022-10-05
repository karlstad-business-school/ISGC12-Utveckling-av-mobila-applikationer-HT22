package com.example.exempel_custom_list;

public class Student {
    private String name;
    private int id;


    public Student(int i, String s){
        id = i;
        name = s;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }
}
