package com.lab900.api.controllers;

import com.lab900.api.mapper.rest.AnswerRestDtoMapper;
import com.lab900.api.model.Answer;
import com.lab900.api.model.rest.AnswerInputRestDto;
import com.lab900.api.model.rest.AnswerOutputRestDto;
import com.lab900.api.services.AnswerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/answers")
public class AnswerController {
    protected static final String SWAGGER_TAG = "Answer";

    private AnswerService answerService;

    private AnswerRestDtoMapper answerRestDtoMapper;

    @ApiOperation(value = "Post an answer to a question.", tags = {SWAGGER_TAG})
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public AnswerOutputRestDto postAnswer(@RequestBody @Valid AnswerInputRestDto answerInputRestDto) {
        Answer answer = new Answer();
        answerRestDtoMapper.populate(answer, answerInputRestDto);
        return answerRestDtoMapper.map(answerService.save(answerInputRestDto.getQuestionId(), answer));
    }

    @Autowired
    public void setAnswerService(AnswerService answerService) {
        this.answerService = answerService;
    }

    @Autowired
    public void setAnswerRestDtoMapper(AnswerRestDtoMapper answerRestDtoMapper) {
        this.answerRestDtoMapper = answerRestDtoMapper;
    }
}
