package com.es.repository.es;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EntityScan(basePackages = {"com.es.repository.es.document"})
@EnableElasticsearchRepositories(basePackages = {"com.es.repository.es.repository"})
public class SpringBootJpaEsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJpaEsApplication.class, args);
    }

}
