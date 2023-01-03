package com.example.studentdatabase;

public class Student {
    int _cnum;
    String _name;
    public Student(){   }
    public Student(int cnum, String name){
        this._cnum = cnum;
        this._name = name;
    }

    public Student(String name){
        this._name = name;
    }

    public int getID(){
        return this._cnum;
    }

    public void setID(int cnum){
        this._cnum = cnum;
    }

    public String getName(){
        return this._name;
    }

    public void setName(String name){
        this._name = name;
    }
}
