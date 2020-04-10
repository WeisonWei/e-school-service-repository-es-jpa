package com.es.repository.es.repository;

import com.es.repository.es.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentEsRepository extends ElasticsearchRepository<Student, Long> {

    //默认的注释
    //@Query("{\"bool\" : {\"must\" : {\"field\" : {\"content\" : \"?\"}}}}")
    Page<Student> findByName(String name, Pageable pageable);

    @Query("{\"bool\" : {\"must\" : {\"field\" : {\"name\" : \"?\"}}}}")
    Page<Student> findByName1(String name, Pageable pageable);

    @Query("{\"bool\" : {\"must\" : {\"field\" : {\"age\" : \"?\"}}}}")
    Page<Student> findByAge(Long age, Pageable pageable);
}
