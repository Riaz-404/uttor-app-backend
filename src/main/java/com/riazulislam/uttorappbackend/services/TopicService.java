package com.riazulislam.uttorappbackend.services;

import com.riazulislam.uttorappbackend.models.Topic;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface TopicService {
    ResponseEntity<?> getTopicDetails(UUID id);

    ResponseEntity<?> createNewTopic(Topic topic);
}
