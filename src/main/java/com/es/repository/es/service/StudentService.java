package com.es.repository.es.service;


import com.es.repository.es.entity.Student;
import org.springframework.data.domain.Page;

import java.util.Iterator;
import java.util.List;

public interface StudentService {

    void createIndex();

    void deleteIndex(String index);

    Student addStudent(Student student);

    Iterator<Student> saveAll(List<Student> studentList);

    Iterator<Student> getStudents();

    Iterator<Student> searchByName(String name);

    Page<Student> findByContent(String content);

    Student getStudent(Long studentId);

    Student updateStudent(Student student);

    Integer deleteStudent(Long studentId);

    String getStudentByIdFromRest(Long studentId);

    String getStudentByIdFromJpa(Long studentId);
}
