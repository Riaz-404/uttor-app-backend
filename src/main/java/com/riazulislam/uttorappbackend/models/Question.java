package com.riazulislam.uttorappbackend.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Question extends BaseModel {
    @Column(nullable = false)
    private String title;

    private String body;

    @ManyToMany
    @JoinTable(
            name = "question_topic",
            joinColumns = @JoinColumn(name = "question_id"),
            inverseJoinColumns = @JoinColumn(name = "topic_id")
    )
    private List<Topic> topics = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    private User user;
}
