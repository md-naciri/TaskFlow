package com.example.securityproject.service.implementation;
import com.example.securityproject.entity.Tag;
import com.example.securityproject.entity.Task;
import com.example.securityproject.handler.OperationException;
import com.example.securityproject.repository.TagRepo;
import com.example.securityproject.repository.TaskRepo;
import com.example.securityproject.service.TaskService;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class TaskServiceImp implements TaskService {
    private final TaskRepo taskRepository;
    private final TagRepo tagRepository;
    @Override
    public Task createTask(Task task, @Size Set<String> tags) {
        Set<Tag> tagSet = new HashSet<>();
        tags.forEach(tagName -> {
            Tag tag = tagRepository.findByName(tagName)
                    .orElseThrow(() -> new OperationException("Tag with name " + tagName + " does not exist."));
            tagSet.add(tag);
        });
        task.setTags(tagSet);


        if (task.getStartDate().isBefore(LocalDate.now())) {
            throw new OperationException("Cannot create a task in the past.");
        }
        if (task.getTags() == null || task.getTags().isEmpty()) {
            throw new OperationException("A task must have at least one tag.");
        }
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
