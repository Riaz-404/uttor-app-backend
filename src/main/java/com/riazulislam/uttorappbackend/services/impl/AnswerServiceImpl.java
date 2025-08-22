package com.riazulislam.uttorappbackend.services.impl;

import com.riazulislam.uttorappbackend.dtos.AnswerDtos.UpdateAnswerDto;
import com.riazulislam.uttorappbackend.models.Answer;
import com.riazulislam.uttorappbackend.repositories.AnswerRepository;
import com.riazulislam.uttorappbackend.services.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AnswerServiceImpl implements AnswerService {
    @Autowired
    AnswerRepository answerRepository;

    @Override
    public ResponseEntity<?> updateAnswer(UUID answerId, UpdateAnswerDto updateAnswerDto) {
        try {
            Answer existingAnswer = answerRepository.findById(answerId).orElseThrow(() -> new RuntimeException("Answer with id " + answerId + " not found"));

            if (updateAnswerDto.getText() != null) {
                existingAnswer.setText(updateAnswerDto.getText());
            }

            Answer savedAnswer = answerRepository.save(existingAnswer);

            return new ResponseEntity<>(savedAnswer, HttpStatus.OK);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
