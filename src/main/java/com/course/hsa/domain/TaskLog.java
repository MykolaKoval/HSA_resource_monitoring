package com.course.hsa.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@Document(indexName = "taskindex")
public class TaskLog {

    @Id
    private String id;
    @Field(type = FieldType.Text, analyzer = "standard")
    private String name;
    @Field(type = FieldType.Text, analyzer = "standard")
    private String user;
}
