package com.example.todolist.models;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Common {

    LocalDateTime createdDateTime = LocalDateTime.now();

    LocalDateTime changedDateTime = LocalDateTime.now();
}