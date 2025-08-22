package com.riazulislam.uttorappbackend.services;

import com.riazulislam.uttorappbackend.dtos.QuestionResponseDto;
import com.riazulislam.uttorappbackend.models.Question;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuestionService {
    ResponseEntity<?> createNewQuestion(Question question);

    List<QuestionResponseDto> searchQuestion(String text, List<String> tag);
}
