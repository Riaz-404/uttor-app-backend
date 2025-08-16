package com.riazulislam.uttorappbackend.services;

import com.riazulislam.uttorappbackend.dtos.QuestionDto;
import com.riazulislam.uttorappbackend.dtos.QuestionResponseDto;
import com.riazulislam.uttorappbackend.dtos.TopicDto;
import com.riazulislam.uttorappbackend.models.Question;
import com.riazulislam.uttorappbackend.models.Topic;
import com.riazulislam.uttorappbackend.models.User;
import com.riazulislam.uttorappbackend.repositories.QuestionRepository;
import com.riazulislam.uttorappbackend.repositories.TopicRepository;
import com.riazulislam.uttorappbackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TopicRepository topicRepository;

    @Override
    public ResponseEntity<?> createNewQuestion(QuestionDto question) {
        try {
            UUID userId = question.getUser();
            Optional<User> user = this.userRepository.findById(userId);

            if (user.isEmpty()) {
                return new ResponseEntity<>("User not found with id: " + userId, HttpStatus.NOT_FOUND);
            }

            List<Topic> topics = question.getTopics().stream()
                    .map(topicId -> topicRepository.findById(topicId)
                            .orElseThrow(() -> new IllegalArgumentException("Topic not found")))
                    .toList();

            Question newQuestion = new Question();

            newQuestion.setTitle(question.getTitle());
            newQuestion.setBody(question.getBody());
            newQuestion.setUser(user.get());
            newQuestion.setTopics(topics);

            Question savedQuestion = this.questionRepository.save(newQuestion);

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
