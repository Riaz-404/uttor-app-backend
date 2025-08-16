package com.riazulislam.uttorappbackend.services;

import com.riazulislam.uttorappbackend.models.Topic;
import com.riazulislam.uttorappbackend.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class TopicService {
    @Autowired
    TopicRepository topicRepository;

    public ResponseEntity<?> getTopicDetails (UUID id) {
        try {
            Optional<Topic> topic = this.topicRepository.findById(id);

            if (topic.isEmpty()) {
                return new ResponseEntity<>("Topic not found with id: " + id, HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<>(topic, HttpStatus.OK);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public ResponseEntity<?> createNewTopic (Topic topic) {
        try {
            Topic createdTopic = this.topicRepository.save(topic);

            return new ResponseEntity<>(createdTopic, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
