package com.example.securityproject.service;

import com.example.securityproject.entity.Task;

import java.util.List;

public interface TaskService {
    Task createTask(Task task);
    Task getTask(Long id);
    List<Task> getAllTasks();
}
