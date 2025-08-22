package com.riazulislam.uttorappbackend.adapters;

import com.riazulislam.uttorappbackend.dtos.AnswerDtos.CreateAnswerDto;
import com.riazulislam.uttorappbackend.dtos.AnswerDtos.ResponseAnswerDto;
import com.riazulislam.uttorappbackend.models.Answer;

import java.util.UUID;

public interface AnswerMapper {
    Answer toEntity(UUID questionId, CreateAnswerDto createAnswerDto);

    ResponseAnswerDto toResponseDto(Answer answer);
}
