package com.riazulislam.uttorappbackend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Topic extends BaseModel {
    @Column(nullable = false)
    private String name;

    @JsonBackReference
    @ManyToMany(mappedBy = "topics")
    private List<Question> questions;
}
