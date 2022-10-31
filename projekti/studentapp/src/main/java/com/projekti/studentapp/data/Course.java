package com.projekti.studentapp.data;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String course;
    private String teacher;
    private String classroom;
    private long id;
    private static long idCount = 0;

        public List<Student> coursestudents = new ArrayList<>();

    public Course() {
        this("","","");
    }


    public Course(String course, String teacher, String classroom) {
        this.course = course;
        this.teacher = teacher;
        this.classroom = classroom;
        this.id = idCount++;
    }

    public Course(String course, String teacher, String classroom, long id) {
        this.course = course;
        this.teacher = teacher;
        this.classroom = classroom;
        this.id = id;
    }

    public String getCourse() {
        return this.course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getTeacher() {
        return this.teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getClassroom() {
        return this.classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public long getId() {
        return this.id;
    }

    public void addStudent(Student student){
        coursestudents.add(student);
    }
    
    public List<Student> getCoursestudents() {
        return this.coursestudents;
    }
}
