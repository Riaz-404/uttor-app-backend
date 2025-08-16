package com.riazulislam.uttorappbackend.controllers;

import com.riazulislam.uttorappbackend.models.Topic;
import com.riazulislam.uttorappbackend.services.TopicService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/topics")
public class TopicsController {
    private final TopicService topicService;

    public TopicsController(TopicService topicService) {
        this.topicService = topicService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTopic(@PathVariable UUID id) {
        return this.topicService.getTopicDetails(id);
    }

    @PostMapping
    public ResponseEntity<?> createTopic(@RequestBody Topic topic) {
        return this.topicService.createNewTopic(topic);
    }
}
