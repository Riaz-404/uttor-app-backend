package com.riazulislam.uttorappbackend.repositories;

import com.riazulislam.uttorappbackend.models.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AnswerRepository extends JpaRepository<Answer, UUID> {
}
