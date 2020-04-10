package com.es.repository.es.contorller;

import com.es.repository.es.entity.Student;
import com.es.repository.es.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;


    @GetMapping("/init")
    public void init() {
        studentService.createIndex();
        List<Student> list = new ArrayList<>();
        list.add(new Student(1L, "Weison", 3, 132l, 1l));
        list.add(new Student(2L, "Even", 2, 222l, 1l));
        list.add(new Student(3L, "Wade", 1, 123l, 1l));
        studentService.saveAll(list);
    }

    @GetMapping("/all")
    public Iterator<Student> all() {
        return studentService.getStudents();
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
        Student student1 = studentService.addStudent(student);
        return student1;
    }

    @GetMapping("/students")
    public Iterator<Student> getStudents() {
        Iterator<Student> students = studentService.getStudents();
        return students;
    }

    @GetMapping("/students/search/{name}")
    public Iterator<Student> search(@PathVariable String name) {
        Iterator<Student> students = studentService.searchByName(name);
        return students;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable Long studentId) {
        Student student = studentService.getStudent(studentId);
        return student;
    }

    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student student) {
        Student student1 = studentService.updateStudent(student);
        return student1;
    }

    @DeleteMapping("/students")
    public Integer deleteStudent(@PathVariable Long studentId) {
        Integer num = studentService.deleteStudent(studentId);
        return num;
    }

}
