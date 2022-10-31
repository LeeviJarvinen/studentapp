package com.projekti.studentapp.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projekti.studentapp.data.Course;
import com.projekti.studentapp.data.Student;
import com.projekti.studentapp.fileservice.StudentFileService;

@Service
public class StudentService {

    @Autowired
    StudentFileService fService;

    int tehty = 0;

    private List<Student> students = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();
    
    public void addStudent(Student student) throws IOException{
        fService.createFile();
        students.add(student);
        fService.writeStudentData(students);
    }

    public void addCourse(Course course) throws IOException{
        fService.createFile();
        courses.add(course);
        fService.writeCourseData(courses);
    }

    public List<Course> getAllCourses() throws IOException{
        fService.createFile();
        fService.readCourseData(courses);
        return courses;
    }

    public List<Student> getAllStudents() throws IOException{
        fService.createFile();
        fService.readStudentData(students);
        return students;
    }

    public Student getStudentById(long id) throws IOException{
        fService.createFile();
        for (Student student : students) {
            if(student.getId() == id){
                return student;
            }
        }    
        return null;
        }

    public Course getCourseById(long id) throws IOException{
        fService.createFile();
        for (Course course : courses) {
            if(course.getId() == id){
                return course;
                }
            }
            return null;
        }    

    public Course addStudentToCourse(long courseId, long studentId) throws IOException{
        Course course = getCourseById(courseId);
        Student student = getStudentById(studentId);
        
        if (course != null && student != null){
            course.coursestudents.add(student);
            fService.writeStudentCourseData(students,courses);
        }
        return null;
        }
}

