package com.projekti.studentapp.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projekti.studentapp.data.Course;
import com.projekti.studentapp.data.Student;
import com.projekti.studentapp.service.StudentService;

@RestController
public class StudentRestController {

    @Autowired
    StudentService sService;

    //Student hommat tänne

    @GetMapping("students")
        public List<Student> getStudents() throws IOException{
            return sService.getAllStudents(); 
        }


    @GetMapping("student/{id}")
        public Student getStudentBy(@PathVariable int id) throws IOException {
            return sService.getStudentById(id);
        }

    @PostMapping("addstudent")
        public Student addStudent(
        @RequestParam String studentname) throws IOException{

            Student s = new Student(studentname);
            sService.addStudent(s);
            return s;
        }

    //Course hommat tänne

    @GetMapping("courses")
        public List<Course> getCourses() throws IOException{
            return sService.getAllCourses();
        }

    @GetMapping("course/{id}")
        public Course getVourseBy(@PathVariable int id) throws IOException {
            return sService.getCourseById(id);
        }

    @PostMapping("addcourse")
        public Course addCourse(
        @RequestParam String course,
        @RequestParam String teacher,
        @RequestParam String classroom) throws IOException{

            Course c = new Course(course, teacher, classroom);
            sService.addCourse(c);
            return c;
        }

        @PostMapping("addstudentcourse")
        public Course addstudentCourse(
        @RequestParam long courseid,
        @RequestParam long studentid) throws IOException{

            sService.getCourseById(courseid);
            sService.getStudentById(studentid);
            
            return sService.addStudentToCourse(courseid, studentid);
        }
    }