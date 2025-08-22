package com.riazulislam.uttorappbackend.dtos.AnswerDtos;

import lombok.Value;

import java.util.UUID;

@Value
public class CreateAnswerDto {
    String text;
    UUID user;
}
