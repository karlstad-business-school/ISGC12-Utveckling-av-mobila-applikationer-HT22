package com.example.exempel_skicka_objekt;

import java.io.Serializable;

public class Student implements Serializable {
    private int id;
    private String namn;
    private String pnr;

    public Student(int id, String namn, String pnr){
        this.id = id;
        this.namn = namn;
        this.pnr = pnr;
    }

    public int getId(){
        return this.id;
    }

    public String getNamn(){
        return this.namn;
    }

    public String getPnr(){
        return this.pnr;
    }
}
