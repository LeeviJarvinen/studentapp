package com.projekti.studentapp.fileservice;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.projekti.studentapp.data.Course;
import com.projekti.studentapp.data.Student;

@Service
public class StudentFileService {
    public List<Student> students = new ArrayList<>();
    public List<Course> courses = new ArrayList<>();
    public List<Student> coursestudents = new ArrayList<>();

    int x,y,z = 0;


    /**
     * @throws IOException
     */
    public void createFile() throws IOException {
        File f = new File("files");
        f.mkdir();
        f = new File("files/studentdata.txt");
        f = new File("files/coursedata.txt");
        f = new File("files/coursestudentdata.txt");
        f.createNewFile();
    }

    public void readStudentData(List <Student> students) throws IOException {
        Scanner sc = new Scanner(new File("files/studentdata.txt"));
        if (x == 0){
        while(sc.hasNextLine()){
            String[] studentInfo = sc.nextLine().split("---");
            Student s = new Student(studentInfo[1], Long.parseLong(studentInfo[0]));
            
            students.add(s);
            x++;
        }
        sc.close();
        }
    }

    public void readCourseData(List <Course> courses) throws IOException {
        Scanner sc = new Scanner(new File("files/coursedata.txt"));
        if (y == 0){
        while(sc.hasNextLine()){
            String[] courseInfo = sc.nextLine().split("---");
            Course c = new Course(courseInfo[1],courseInfo[2],courseInfo[3],Long.parseLong(courseInfo[0]));
            
            courses.add(c);
            y++;
        }
        sc.close();
        }
    }

    public void writeStudentData(List<Student> students) throws IOException{
        FileWriter fw = new FileWriter(new File("files/studentdata.txt"));
            for (Student student : students) {
                fw.write(student.getId()+"---");
                fw.write(student.getStudentname()+System.lineSeparator());
            }
            fw.close();
        }

    public void writeCourseData(List<Course> courses) throws IOException{
        FileWriter fw = new FileWriter(new File("files/coursedata.txt"));
            for (Course course : courses) {
                fw.write(course.getId()+"---");
                fw.write(course.getCourse()+"---");
                fw.write(course.getTeacher()+"---");
                fw.write(course.getClassroom()+System.lineSeparator());
            }
            fw.close();
        }

    public void writeStudentCourseData(List<Student> students, List<Course> courses) throws IOException{
        FileWriter fw = new FileWriter(new File("files/coursestudentdata.txt"));
        for (Course course : courses) {
            for (Student student : students) {
                fw.write(student.getId()+"---");
                fw.write(student.getStudentname()+"---");
                }
            fw.write(course.getId()+"---");
            fw.write(course.getCourse()+"---");
            fw.write(course.getTeacher()+"---");
            fw.write(course.getClassroom()+System.lineSeparator());
                }
                fw.close();
            }
        }
