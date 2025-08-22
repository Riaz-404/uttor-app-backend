package com.riazulislam.uttorappbackend.adapters;

import com.riazulislam.uttorappbackend.dtos.QuestionDto;
import com.riazulislam.uttorappbackend.models.Question;

public interface CreateQuestionDtoToQuestionAdapter {
    Question dtoToQuestion(QuestionDto questionDto);
}
