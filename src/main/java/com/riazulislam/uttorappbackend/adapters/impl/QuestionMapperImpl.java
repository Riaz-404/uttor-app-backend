package com.riazulislam.uttorappbackend.adapters.impl;

import com.riazulislam.uttorappbackend.adapters.QuestionMapper;
import com.riazulislam.uttorappbackend.dtos.QuestionDtos.QuestionDto;
import com.riazulislam.uttorappbackend.models.Question;
import com.riazulislam.uttorappbackend.models.Topic;
import com.riazulislam.uttorappbackend.models.User;
import com.riazulislam.uttorappbackend.repositories.TopicRepository;
import com.riazulislam.uttorappbackend.repositories.UserRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QuestionMapperImpl implements QuestionMapper {
    UserRepository userRepository;

    TopicRepository topicRepository;

    QuestionMapperImpl(UserRepository userRepository, TopicRepository topicRepository) {
        this.userRepository = userRepository;
        this.topicRepository = topicRepository;
    }

    @Override
    public Question toEntity(QuestionDto questionDto) {
        try {
            User user = userRepository.findById(questionDto.getUser()).orElseThrow(() -> new RuntimeException("User not found"));

            List<Topic> topics = questionDto.getTopics().stream()
                    .map(topicId -> topicRepository.findById(topicId)
                            .orElseThrow(() -> new IllegalArgumentException("Topic not found")))
                    .toList();

            return Question.builder()
                    .title(questionDto.getTitle())
                    .body(questionDto.getBody())
                    .topics(topics)
                    .user(user)
                    .build();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
