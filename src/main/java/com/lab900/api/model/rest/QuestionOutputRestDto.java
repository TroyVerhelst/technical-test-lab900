/*-
 * #%L
 * epb-nr-api
 * %%
 * Copyright (C) 2016 - 2020 Vlaamse Overheid
 * %%
 * Licensed under the EUPL, Version 1.1 or – as soon they will be
 * approved by the European Commission - subsequent versions of the
 * EUPL (the "Licence");
 *
 * You may not use this work except in compliance with the Licence.
 * You may obtain a copy of the Licence at:
 *
 * http://ec.europa.eu/idabc/eupl5
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the Licence is distributed on an "AS IS" basis,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Licence for the specific language governing permissions and
 * limitations under the Licence.
 * #L%
 */
package com.lab900.api.model.rest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class QuestionOutputRestDto implements Serializable {
    private UUID id;
    private String description;
    private List<AnswerOutputRestDto> answers;

    public QuestionOutputRestDto() {
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

    public List<AnswerOutputRestDto> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerOutputRestDto> answers) {
        this.answers = answers;
    }

    public void addAnswer(AnswerOutputRestDto answerOutputRestDto) {
        if (this.answers == null) {
            this.answers = new ArrayList<>();
        }
        this.answers.add(answerOutputRestDto);
    }
}
