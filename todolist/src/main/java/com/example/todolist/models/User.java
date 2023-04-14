package com.example.todolist.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User extends Common {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String login;
    private String firstName;
    private String middleName;
    private String lastName;
    private LocalDate birthday;

    @OneToMany(mappedBy = "user")
    private List<Task> tasks;

}
