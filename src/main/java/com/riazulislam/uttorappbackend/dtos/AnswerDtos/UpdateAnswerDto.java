package com.riazulislam.uttorappbackend.dtos.AnswerDtos;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.riazulislam.uttorappbackend.models.Answer}
 */
@Value
public class UpdateAnswerDto implements Serializable {
    String text;
}