package com.riazulislam.uttorappbackend.services;

import com.riazulislam.uttorappbackend.dtos.AnswerDtos.UpdateAnswerDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface AnswerService {
    ResponseEntity<?> updateAnswer(UUID answerId, UpdateAnswerDto updateAnswerDto);
}
