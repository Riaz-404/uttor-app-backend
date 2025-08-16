package com.riazulislam.uttorappbackend.dtos;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDto {
    private String title;
    private String body;
    private List<UUID> topics;
    private UUID user;
}
