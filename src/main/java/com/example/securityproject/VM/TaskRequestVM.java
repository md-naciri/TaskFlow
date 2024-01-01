package com.example.securityproject.VM;

import com.example.securityproject.entity.Task;
import com.example.securityproject.entity.TaskStatus;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;

public record TaskRequestVM(
        @NotBlank(message = "Name cannot be blank")
        String name,
        String description,
        @FutureOrPresent(message = "Start date must be in the present or future")
        LocalDate startDate,
        LocalDate endDate,
        @NotNull(message = "Status cannot be null")
        TaskStatus status,
        @Size(min = 1, message = "At least one tag is required")
        Set<String> tags
) {
    public Task toTask() {
        return Task.builder()
                .name(name)
                .description(description)
                .startDate(startDate)
                .endDate(endDate)
                .status(status)
                // .tags(lookupTags(tags)) // This is a placeholder for tag lookup logic
                .build();
    }
}
