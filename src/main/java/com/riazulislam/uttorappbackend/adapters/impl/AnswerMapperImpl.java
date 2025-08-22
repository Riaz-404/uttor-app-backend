package com.riazulislam.uttorappbackend.adapters.impl;

import com.riazulislam.uttorappbackend.adapters.AnswerMapper;
import com.riazulislam.uttorappbackend.dtos.AnswerDtos.CreateAnswerDto;
import com.riazulislam.uttorappbackend.dtos.AnswerDtos.ResponseAnswerDto;
import com.riazulislam.uttorappbackend.models.Answer;
import com.riazulislam.uttorappbackend.models.Question;
import com.riazulislam.uttorappbackend.models.User;
import com.riazulislam.uttorappbackend.repositories.QuestionRepository;
import com.riazulislam.uttorappbackend.repositories.UserRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AnswerMapperImpl implements AnswerMapper {
    UserRepository userRepository;
    QuestionRepository questionRepository;

    AnswerMapperImpl(UserRepository userRepository, QuestionRepository questionRepository) {
        this.userRepository = userRepository;
        this.questionRepository = questionRepository;
    }

    @Override
    public Answer toEntity(UUID questionId, CreateAnswerDto createAnswerDto) {
        try {
            User user = userRepository.findById(createAnswerDto.getUser()).orElseThrow(() -> new RuntimeException("User not found with id " + createAnswerDto.getUser()));

            Question question = questionRepository.findById(questionId).orElseThrow(() -> new RuntimeException("Question not found with id " + questionId));

            return Answer.builder()
                    .text(createAnswerDto.getText())
                    .user(user)
                    .question(question)
                    .build();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ResponseAnswerDto toResponseDto(Answer answer) {
        return ResponseAnswerDto.builder()
                .id(answer.getId())
                .text(answer.getText())
                .user(answer.getUser())
                .question(answer.getQuestion())
                .createdAt(answer.getCreatedAt())
                .updatedAt(answer.getUpdatedAt())
                .deletedAt(answer.getDeletedAt())
                .build();
    }
}
