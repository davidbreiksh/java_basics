package com.spring.todolist.repositories;

import com.spring.todolist.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Task, Integer> {


}
