package com.projekti.studentapp.data;

public class Student {
    private String studentname;
    private long id;
    private static long idCount = 0;

    public Student() {
        this("");
    }

    public Student(String studentname) {
        this.studentname = studentname;
        this.id = idCount++;
    }


    public Student(String studentname, long id) {
        this.studentname = studentname;
        this.id = id;
    }

    public String getStudentname() {
        return this.studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public long getId() {
        return this.id;
    }
}