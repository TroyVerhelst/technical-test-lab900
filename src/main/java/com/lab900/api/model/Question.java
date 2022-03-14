package com.lab900.api.model;

import java.util.List;
import java.util.UUID;

public class Question {

    private UUID id;
    private String description;
    private List<Answer> answers;

    public Question() {
    }

    public Question(UUID id, String description, List<Answer> answers) {
        this.id = id;
        this.description = description;
        this.answers = answers;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
