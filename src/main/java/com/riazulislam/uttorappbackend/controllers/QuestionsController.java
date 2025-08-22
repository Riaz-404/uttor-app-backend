package com.riazulislam.uttorappbackend.controllers;

import com.riazulislam.uttorappbackend.adapters.AnswerMapper;
import com.riazulislam.uttorappbackend.adapters.QuestionMapper;
import com.riazulislam.uttorappbackend.dtos.AnswerDtos.CreateAnswerDto;
import com.riazulislam.uttorappbackend.dtos.QuestionDtos.QuestionDto;
import com.riazulislam.uttorappbackend.dtos.QuestionDtos.QuestionResponseDto;
import com.riazulislam.uttorappbackend.services.QuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/questions")
public class QuestionsController {
    private final QuestionService questionService;

    private final QuestionMapper questionMapper;

    private final AnswerMapper answerMapper;

    public QuestionsController(QuestionService questionService, QuestionMapper questionMapper, AnswerMapper answerMapper) {
        this.questionService = questionService;
        this.questionMapper = questionMapper;
        this.answerMapper = answerMapper;
    }

    @GetMapping("/search")
    public List<QuestionResponseDto> searchQuestions(
            @RequestParam(required = false) String text,
            @RequestParam(required = false) List<String> tag
    ) {
        return this.questionService.searchQuestion(text, tag);
    }

    @PostMapping
    public ResponseEntity<?> createQuestion(@RequestBody QuestionDto questionDto) {
        return this.questionService.createNewQuestion(questionMapper.toEntity(questionDto));
    }

    @PostMapping("{questionId}/answers")
    public ResponseEntity<?> createAnswers(@PathVariable UUID questionId, @Validated @RequestBody CreateAnswerDto createAnswerDto) {
        return this.questionService.createAnswerToAQuestion(answerMapper.toEntity(questionId, createAnswerDto));
    }
}
