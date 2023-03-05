package com.spring.todolist.services;

import com.spring.todolist.model.Task;
import com.spring.todolist.repositories.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {

    private final Repository repository;

    @Autowired
    public Service(Repository repository) {
        this.repository = repository;
    }

    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public Task getTaskById(int id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteTaskById(int id) {
        repository.deleteById(id);
    }

    public void saveTask(Task task) {
        repository.save(task);
    }

    public boolean isExist(int id) {
        return repository.existsById(id);
    }
}
