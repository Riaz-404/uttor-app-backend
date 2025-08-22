package com.riazulislam.uttorappbackend.controllers;

import com.riazulislam.uttorappbackend.dtos.AnswerDtos.UpdateAnswerDto;
import com.riazulislam.uttorappbackend.services.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/answers")
public class AnswersController {
    @Autowired
    AnswerService answerService;

    @PutMapping("/{answerId}")
    public ResponseEntity<?> updateAnswer(@PathVariable UUID answerId, @Validated @RequestBody UpdateAnswerDto updateAnswerDto) {
        return answerService.updateAnswer(answerId, updateAnswerDto);
    }
}
