package com.example.todolist.models;

import java.time.LocalDateTime;
import java.util.Set;

import org.apache.catalina.User;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "task")
public class Task extends Common {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titleName;
    private String description;
    private Boolean isCompleted;
    private LocalDateTime completedDateTime;

    @ManyToMany(mappedBy = "task")
    private Set<Category> categories;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
