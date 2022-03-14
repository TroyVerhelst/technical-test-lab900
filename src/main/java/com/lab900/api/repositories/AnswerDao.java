package com.lab900.api.repositories;

import com.lab900.api.model.Answer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class AnswerDao {
    private List<Answer> answerDb = new ArrayList<>();

    public Answer get(UUID questionId)  {
        return answerDb.stream()
                .filter(answer -> questionId.equals(answer.getQuestion().getId()))
                .findFirst()
                .orElse(null);
    }

    public Answer save(Answer answer) {
        if (!answerDb.contains(answer)) {
            answerDb.add(answer);
        }
        return answer;
    }
}
