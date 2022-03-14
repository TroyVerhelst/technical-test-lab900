/*-
 * #%L
 * epb-nr-api
 * %%
 * Copyright (C) 2016 - 2019 Vlaamse Overheid
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
package com.lab900.api.services;

import com.lab900.api.model.Answer;

import java.util.UUID;

public interface AnswerService {

    /**
     * Save answer.
     *
     * @param questionId the id
     * @param answer     the answer
     * @return the answer
     */
    Answer save(UUID questionId, Answer answer);
}
