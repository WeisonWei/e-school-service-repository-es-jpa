package com.es.repository.es.service;

import com.es.repository.es.entity.Student;
import com.es.repository.es.repository.StudentEsRepository;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import static org.springframework.data.domain.Sort.Direction.DESC;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    RestTemplate restTemplate;

    /*@Autowired
    private ElasticsearchRestTemplate elasticsearchTemplate;*/

    @Autowired
    StudentEsRepository studentEsRepository;

    @Value("${elasticsearch.url}")
    String esUrl;

    @Override
    public void createIndex() {
        //elasticsearchTemplate.createIndex(Student.class);
    }

    @Override
    public void deleteIndex(String index) {
        //elasticsearchTemplate.deleteIndex(index);
    }


    @Override
    public Student addStudent(Student student) {
        return studentEsRepository.save(student);
    }

    @Override
    public Iterator<Student> saveAll(List<Student> studentList) {
        return studentEsRepository.saveAll(studentList).iterator();
    }

    @Override
    public Iterator<Student> getStudents() {
        Sort sort = Sort.by(DESC, "age");
        Iterator<Student> iterator = studentEsRepository.findAll(sort).iterator();
        return iterator;
    }

    @Override
    public Iterator<Student> searchByName(String name) {
        MatchQueryBuilder nameQuery = QueryBuilders.matchQuery("name", name);
        Iterator<Student> iterator = studentEsRepository.search(nameQuery).iterator();
        return iterator;
    }

    @Override
    public Page<Student> findByContent(String content) {
        return studentEsRepository.findByName(content, PageRequest.of(1, 10));
    }

    @Override
    public Student getStudent(Long studentId) {
        return null;
    }

    @Override
    public Student updateStudent(Student student) {
        return null;
    }

    @Override
    public Integer deleteStudent(Long studentId) {
        return null;
    }

    @Override
    public String getStudentByIdFromRest(Long studentId) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("id", studentId);
        String result = restTemplate.getForObject(esUrl, String.class, params);
        return null;
    }

    @Override
    public String getStudentByIdFromJpa(Long studentId) {
        return null;
    }
}
