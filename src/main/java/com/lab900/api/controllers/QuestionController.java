package com.lab900.api.controllers;

import com.lab900.api.mapper.rest.QuestionRestDtoMapper;
import com.lab900.api.model.Question;
import com.lab900.api.model.rest.PutQuestionInputRestDto;
import com.lab900.api.model.rest.QuestionInputRestDto;
import com.lab900.api.model.rest.QuestionOutputRestDto;
import com.lab900.api.services.QuestionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/questions")
public class QuestionController {
    protected static final String SWAGGER_TAG = "Question";

    private QuestionService questionService;

    private QuestionRestDtoMapper questionRestDtoMapper;

    @ApiOperation(value = "Get the data of a question by id.", tags = {SWAGGER_TAG})
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public QuestionOutputRestDto getQuestionById(@PathVariable UUID id) {
        return questionRestDtoMapper.map(questionService.retrieve(id));
    }

    @ApiOperation(value = "Post a question.", tags = {SWAGGER_TAG})
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public QuestionOutputRestDto postQuestion(@RequestBody @Valid QuestionInputRestDto questionInputRestDto) {
        Question question = new Question();
        questionRestDtoMapper.populate(question, questionInputRestDto);
        return questionRestDtoMapper.map(questionService.save(question));
    }

    @ApiOperation(value = "Update a question.", tags = {SWAGGER_TAG})
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public QuestionOutputRestDto putQuestion(@RequestBody @Valid PutQuestionInputRestDto putQuestionInputRestDto) {
        Question question = questionService.retrieve(putQuestionInputRestDto.getId());
        questionRestDtoMapper.populate(question, putQuestionInputRestDto);
        return questionRestDtoMapper.map(questionService.update(question));
    }

    @ApiOperation(value = "Delete a question.", tags = {SWAGGER_TAG})
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteQuestion(@PathVariable UUID id) {
        questionService.remove(id);
    }

    @Autowired
    public void setQuestionService(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Autowired
    public void setQuestionRestDtoMapper(QuestionRestDtoMapper questionRestDtoMapper) {
        this.questionRestDtoMapper = questionRestDtoMapper;
    }
}
