package com.lab900.api.repositories;

import com.lab900.api.model.Question;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Repository
public class QuestionDao {
    private List<Question> questionDb = Arrays.asList(
            new Question(UUID.fromString("0364d44d-6571-4c91-a7c8-3b9a855ddd65"), "How likely are you to recommend being part of the HR Digital team to a Solvay colleague?", new ArrayList<>()),
            new Question(UUID.fromString("cced48db-1860-4747-bd4f-73969d85408a"), "Which part of your job do you like the best?", new ArrayList<>()),
            new Question(UUID.fromString("21b0ad38-4373-442c-83c2-4f1ccc7a5bbd"), "Which transportation method do you use to get to work?", new ArrayList<>()),
            new Question(UUID.fromString("7f710519-cd79-47f2-83cc-f4a8a4a4adc8"), "What should our team do more of in the future?", new ArrayList<>())
    );

    public Question get(UUID id)  {
        return questionDb.stream()
                .filter(question -> question.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Question save(Question questionToSave)  {
        questionDb.add(questionToSave);
        return questionToSave;
    }

    public Question update(Question questionToSave)  {
        questionDb.stream()
                .filter(q -> q.getId().equals(questionToSave.getId()))
                .findFirst()
                .ifPresent(question -> {
                    question.setDescription(questionToSave.getDescription());
                });
        return questionToSave;
    }

    public void updateAnswers(Question questionToSave)  {
        questionDb.stream()
                .filter(q -> q.getId().equals(questionToSave.getId()))
                .findFirst()
                .ifPresent(question -> question.setAnswers(questionToSave.getAnswers()));
    }

    // TODO: werkt niet, moest nog nakijken
    public void delete(UUID id) {
        questionDb.stream()
                .filter(question -> question.getId().equals(id))
                .findFirst()
                .ifPresent(question -> questionDb.remove(question));
    }
}
