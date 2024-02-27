package com.manager.entity;

import java.time.LocalDateTime; // Import LocalDateTime
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tasks {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String title;
    LocalDateTime due; // Change type to LocalDateTime
    String priority;
    boolean completed;

    public Tasks() {
        super();
    }

    public Tasks(int id, String title, LocalDateTime due, String priority, boolean completed) {
        super();
        this.id = id;
        this.title = title;
        this.due = due;
        this.priority = priority;
        this.completed = completed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getDue() {
        return due;
    }

    public void setDue(LocalDateTime due) {
        this.due = due;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "Tasks [id=" + id + ", title=" + title + ", due=" + due + ", priority=" + priority + ", completed="
                + completed + "]";
    }

}
