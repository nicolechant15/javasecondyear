package com.example.todolist.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todolist.models.Task;
import com.example.todolist.services.TaskService;

@RestController
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping()
    public ResponseEntity<?> createTask(@RequestBody Task item) {
        taskService.create(item);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<?> findAllTasks() {
        List<Task> itemList = taskService.getAll();
        if (itemList.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(itemList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findTaskById(@PathVariable(name = "id") Long id) {
        Optional<Task> currentItem = taskService.getById(id);
        if (currentItem.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(currentItem.get(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTask(@PathVariable(name = "id") Long id, @RequestBody Task newTask) {
        Optional<Task> currentItemOptional = taskService.getById(id);
        if (currentItemOptional.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        Task oldTask = currentItemOptional.get();
        Task changedTask = taskService.update(oldTask, newTask);
        return new ResponseEntity<>(changedTask, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable(name = "id") Long id) {
        Optional<Task> currentItemOptional = taskService.getById(id);
        if (currentItemOptional.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        taskService.delete(currentItemOptional.get());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}