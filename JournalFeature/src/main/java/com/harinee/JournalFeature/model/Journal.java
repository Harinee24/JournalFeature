package com.harinee.JournalFeature.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

@Document(collection = "journals")
public class Journal {

    @Id
    private String id;
    private String content;
    private LocalDateTime createdAt;

    public Journal() {
    }

    public Journal(String content) {
        this.content = content;
        this.createdAt = LocalDateTime.now();
    }

    public String getFormattedCreatedAt() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return createdAt.format(formatter);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedAt() {
        if (createdAt == null) {
            this.createdAt = LocalDateTime.now(); // Set default value if null
        }
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
