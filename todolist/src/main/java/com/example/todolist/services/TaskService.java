package com.example.todolist.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todolist.models.Task;
import com.example.todolist.repositories.TaskRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Optional<Task> getById(Long id) {
        return taskRepository.findById(id);
    }

    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    public void create(Task task) {
        taskRepository.save(task);
    }

    public Task update(Task oldTask, Task newTask) {
        oldTask.setTitleName(newTask.getTitleName());
        oldTask.setDescription(newTask.getDescription());
        oldTask.setCompletedDateTime(newTask.getCompletedDateTime());
        oldTask.setIsCompleted(newTask.getIsCompleted());
        oldTask.setCategories(newTask.getCategories());
        oldTask.setUser(newTask.getUser());
        oldTask.setChangedDateTime(newTask.getCreatedDateTime());
        taskRepository.save(oldTask);
        return oldTask;
    }

    public void delete(Task task) {
        taskRepository.delete(task);
    }

}
