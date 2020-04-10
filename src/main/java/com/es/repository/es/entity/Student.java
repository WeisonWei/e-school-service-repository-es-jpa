package com.es.repository.es.entity;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "school", type = "student", refreshInterval = "30s", indexStoreType = "niofs", shards = 2, replicas = 0)
@Accessors(chain = true)
public class Student implements Serializable {

    @Id
    private Long id;

    //@Field(type = FieldType.Text, analyzer = "ik_max_word")
    @Field(type = FieldType.Text)
    private String name;

    @Field(type = FieldType.Integer)
    private Integer age;

    @Field(type = FieldType.Long)
    private Long addressId;

    @Field(type = FieldType.Long)
    @Version
    private Long version;
}
