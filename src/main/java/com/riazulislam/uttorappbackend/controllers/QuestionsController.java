package com.riazulislam.uttorappbackend.controllers;

import com.riazulislam.uttorappbackend.adapters.CreateQuestionDtoToQuestionAdapter;
import com.riazulislam.uttorappbackend.dtos.QuestionDto;
import com.riazulislam.uttorappbackend.dtos.QuestionResponseDto;
import com.riazulislam.uttorappbackend.services.QuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionsController {
    private final QuestionService questionService;

    private final CreateQuestionDtoToQuestionAdapter createQuestionDtoToQuestionAdapter;

    public QuestionsController(QuestionService questionService, CreateQuestionDtoToQuestionAdapter createQuestionDtoToQuestionAdapter) {
        this.questionService = questionService;
        this.createQuestionDtoToQuestionAdapter = createQuestionDtoToQuestionAdapter;
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
        return this.questionService.createNewQuestion(createQuestionDtoToQuestionAdapter.dtoToQuestion(questionDto));
    }
}
