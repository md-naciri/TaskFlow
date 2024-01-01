package com.example.securityproject.service;

import com.example.securityproject.entity.Task;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.Set;

public interface TaskService {
    Task createTask(Task task, @Size Set<String> tags);
    Task getTask(Long id);
    List<Task> getAllTasks();
}
