package com.riazulislam.uttorappbackend.services;

import com.riazulislam.uttorappbackend.dtos.QuestionDto;
import com.riazulislam.uttorappbackend.dtos.QuestionResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuestionService {
    ResponseEntity<?> createNewQuestion(QuestionDto question);

    List<QuestionResponseDto> searchQuestion(String text, List<String> tag);
}
