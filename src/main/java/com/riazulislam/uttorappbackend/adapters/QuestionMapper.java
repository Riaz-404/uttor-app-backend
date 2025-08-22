package com.riazulislam.uttorappbackend.adapters;

import com.riazulislam.uttorappbackend.dtos.QuestionDtos.QuestionDto;
import com.riazulislam.uttorappbackend.models.Question;

public interface QuestionMapper {
    Question toEntity(QuestionDto questionDto);
}
