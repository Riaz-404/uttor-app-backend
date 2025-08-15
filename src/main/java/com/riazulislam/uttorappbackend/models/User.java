package com.riazulislam.uttorappbackend.models;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User extends BaseModel {

    private String username;

    private String email;

    @Column(nullable = true)
    private String bio;
}
