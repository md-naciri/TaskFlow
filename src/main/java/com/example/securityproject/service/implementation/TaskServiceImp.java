package com.example.securityproject.service.implementation;
import com.example.securityproject.entity.Task;
import com.example.securityproject.handler.OperationException;
import com.example.securityproject.repository.TaskRepo;
import com.example.securityproject.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImp implements TaskService {
    private final TaskRepo taskRepository;
    @Override
    public Task createTask(Task task) {
        if (task.getStartDate().isBefore(LocalDate.now())) {
            throw new OperationException("Cannot create a task in the past.");
        }
//        if (task.getTags() == null || task.getTags().isEmpty()) {
//            throw new OperationException("A task must have at least one tag.");
//        }
        if (task.getStartDate().isAfter(LocalDate.now().plusDays(3))) {
            throw new OperationException("Tasks cannot be scheduled more than 3 days in advance.");
        }
        return taskRepository.save(task);
    }

    @Override
    public Task getTask(Long id) {
        return taskRepository.findById(id).orElseThrow(() ->
                new OperationException("Task does not exist."));
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
}
