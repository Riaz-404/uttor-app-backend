package com.riazulislam.uttorappbackend.dtos.AnswerDtos;

import com.riazulislam.uttorappbackend.models.Question;
import com.riazulislam.uttorappbackend.models.User;
import lombok.Builder;
import lombok.Value;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * DTO for {@link com.riazulislam.uttorappbackend.models.Answer}
 */
@Value
@Builder
public class ResponseAnswerDto implements Serializable {
    UUID id;
    Date createdAt;
    Date updatedAt;
    Date deletedAt;
    String text;
    User user;
    Question question;
}