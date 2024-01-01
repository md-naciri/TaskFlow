package com.example.securityproject.controller;

import com.example.securityproject.VM.TaskRequestVM;
import com.example.securityproject.VM.TaskResponseVM;
import com.example.securityproject.entity.Task;
import com.example.securityproject.handler.ResponseHandler;
import com.example.securityproject.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/task")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;
    @PostMapping
    public ResponseEntity<?> createTask(@RequestBody @Valid TaskRequestVM taskRequestVM) {
        Task task = taskService.createTask(taskRequestVM.toTask());
        return ResponseHandler.created(TaskResponseVM.fromTask(task), "Task created successfully");
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getTask(@PathVariable Long id) {
        TaskResponseVM taskResponseVM = TaskResponseVM.fromTask(taskService.getTask(id));
        return ResponseHandler.ok(taskResponseVM, "Task Found Successfully");
    }
    @GetMapping
    public ResponseEntity<?> getAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        List<TaskResponseVM> response = tasks.stream()
                .map(TaskResponseVM::fromTask)
                .collect(Collectors.toList());
        return ResponseHandler.ok(response, "Tasks Found Successfully");
    }
}
