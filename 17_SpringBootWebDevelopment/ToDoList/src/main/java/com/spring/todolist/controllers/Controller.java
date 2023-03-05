package com.spring.todolist.controllers;

import com.spring.todolist.model.Task;
import com.spring.todolist.services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class Controller {

    private final Service service;

    @Autowired
    public Controller(Service service) {
        this.service = service;
    }

    @GetMapping("/")
    public ResponseEntity<String> index() {
        Date date = new Date();
        return ResponseEntity.ok(date.toString());
    }

    @GetMapping("/tasks")
    public List<Task> tasks() {
        return service.getAllTasks();
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable int id) {
        if (!service.isExist(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(service.getTaskById(id));
    }

    @DeleteMapping("/tasks/{id}")
    public void deleteTaskById(@PathVariable int id) {
        if (!service.isExist(id)) {
            new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else service.deleteTaskById(id);
    }

    @PostMapping("/tasks")
    public void saveTask(@RequestParam String title,
                         @RequestParam String description) {
        Task task = new Task(title, description);
        service.saveTask(task);
    }

    @PatchMapping("/tasks/{id}")
    public void updateTask(@PathVariable int id,
                           @RequestParam(required = false) String title,
                           @RequestParam(required = false) String description,
                           @RequestParam(required = false) Boolean isdone) {
        if (!service.isExist(id)) {
            new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            Task task = service.getTaskById(id);
            task.setTitle(title);
            task.setDescription(description);
            task.setIsdone(isdone);
            service.saveTask(task);
        }
    }
}