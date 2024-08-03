package com.course.hsa.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "tasks")
public class Task {

    @Id
    private String id;
    private String name;
    private String user;
}
