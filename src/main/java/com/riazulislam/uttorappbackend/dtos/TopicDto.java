package com.riazulislam.uttorappbackend.dtos;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TopicDto {
    private UUID id;
    private String name;
}
