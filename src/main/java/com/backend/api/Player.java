package com.backend.api;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
public class Player {
    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    private Integer score;
    private LocalDateTime created;
}
