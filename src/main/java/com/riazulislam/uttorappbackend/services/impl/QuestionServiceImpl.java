package com.riazulislam.uttorappbackend.services.impl;

import com.riazulislam.uttorappbackend.adapters.AnswerMapper;
import com.riazulislam.uttorappbackend.dtos.QuestionDtos.QuestionResponseDto;
import com.riazulislam.uttorappbackend.dtos.TopicDto;
import com.riazulislam.uttorappbackend.models.Answer;
import com.riazulislam.uttorappbackend.models.Question;
import com.riazulislam.uttorappbackend.repositories.AnswerRepository;
import com.riazulislam.uttorappbackend.repositories.QuestionRepository;
import com.riazulislam.uttorappbackend.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    AnswerRepository answerRepository;

    @Autowired
    AnswerMapper answerMapper;

    @Override
    public ResponseEntity<?> createNewQuestion(Question question) {
        try {
            Question savedQuestion = this.questionRepository.save(question);

            QuestionResponseDto responseDto = mapToResponseDto(savedQuestion);

            return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<QuestionResponseDto> searchQuestion(String text, List<String> tag) {
        try {
            List<Question> questions;

            boolean hasText = (text != null && !text.isEmpty());
            boolean hasTags = (tag != null && !tag.isEmpty());

            if (!hasText && !hasTags) {
                questions = questionRepository.findAll();
            } else if (hasText && hasTags) {
                questions = questionRepository.findByTitleContainingIgnoreCaseAndTopicsNameIn(text, tag);
            } else if (hasText) {
                questions = questionRepository.findByTitleContainingIgnoreCase(text);
            } else {
                questions = questionRepository.findByTopicsNameIn(tag);
            }
            return questions.stream().map(this::mapToResponseDto).toList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ResponseEntity<?> createAnswerToAQuestion(Answer answer) {
        try {
            Answer createdAnswer = answerRepository.save(answer);

            return new ResponseEntity<>(answerMapper.toResponseDto(createdAnswer), HttpStatus.CREATED);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    private QuestionResponseDto mapToResponseDto(Question question) {
        return QuestionResponseDto.builder()
                .id(question.getId())
                .title(question.getTitle())
                .body(question.getBody())
                .topics(question.getTopics().stream()
                        .map(topic -> new TopicDto(topic.getId(), topic.getName()))
                        .toList())
                .user(question.getUser())
                .build();
    }
}
