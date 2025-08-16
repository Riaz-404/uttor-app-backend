package com.riazulislam.uttorappbackend.repositories;

import com.riazulislam.uttorappbackend.models.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TopicRepository extends JpaRepository<Topic, UUID> {
}
