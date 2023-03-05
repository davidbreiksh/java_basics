package com.spring.todolist.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Data
public class Task {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "creationtime")
    private Timestamp creationtime;
    @Basic
    @Column(name = "isdone")
    private Boolean isdone;
    @Basic
    @Column(name = "title")
    private String title;
    @Basic
    @Column(name = "description")
    private String description;

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.isdone = false;
        this.creationtime = new Timestamp(System.currentTimeMillis());
    }

    public Task() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && Objects.equals(creationtime, task.creationtime) && Objects.equals(isdone, task.isdone) && Objects.equals(title, task.title) && Objects.equals(description, task.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, creationtime, isdone, title, description);
    }
}
