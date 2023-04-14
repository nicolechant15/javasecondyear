package com.example.todolist.services;

import com.example.todolist.models.Category;
import com.example.todolist.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Optional<Category> getById(Long id) {
        return categoryRepository.findById(id);
    }

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    public void create(Category category) {
        categoryRepository.save(category);
    }

    public Category update(Category oldCategory, Category newCategory) {

        oldCategory.setName(newCategory.getName());
        oldCategory.setTasks(newCategory.getTasks());
        oldCategory.setChangedDateTime(newCategory.getCreatedDateTime());
        categoryRepository.save(oldCategory);
        return oldCategory;
    }

    public void delete(Category category) {
        categoryRepository.delete(category);
    }
}