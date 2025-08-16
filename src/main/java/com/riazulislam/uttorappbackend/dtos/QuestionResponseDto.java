package com.riazulislam.uttorappbackend.dtos;

import com.riazulislam.uttorappbackend.models.User;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionResponseDto {
    private UUID id;
    private String title;
    private String body;
    private List<TopicDto> topics;
    private User user;
}
