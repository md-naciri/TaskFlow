package com.example.securityproject.VM;
import com.example.securityproject.entity.Task;
import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;
public record TaskResponseVM(
        Long id,
        String name,
        String description,
        LocalDate startDate,
        LocalDate endDate,
        String status,
        Set<String> tags
) {
    public static TaskResponseVM fromTask(Task task) {
        return new TaskResponseVM(
                task.getId(),
                task.getName(),
                task.getDescription(),
                task.getStartDate(),
                task.getEndDate(),
                task.getStatus().name(),
                task.getTags().stream().map(tag -> tag.getName()).collect(Collectors.toSet())
        );
    }
}
