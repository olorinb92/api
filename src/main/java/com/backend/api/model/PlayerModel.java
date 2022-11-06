package com.backend.api.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document("Player")
public class PlayerModel {
    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    private int score;
    private LocalDateTime createdAt;
}
