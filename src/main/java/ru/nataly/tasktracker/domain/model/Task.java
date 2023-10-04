package ru.nataly.tasktracker.domain.model;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;

@Value
@Builder(toBuilder = true)
public class Task {
    Long id;
    String type;
    String description;
    LocalDate startDate;
    LocalDate endDate;
    Boolean isDone;
    Long employeeId;
    Long clientId;
}
