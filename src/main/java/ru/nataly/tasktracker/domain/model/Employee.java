package ru.nataly.tasktracker.domain.model;

import lombok.Builder;
import lombok.Value;
import ru.nataly.tasktracker.infra.jpa.entity.TaskEntity;
import ru.nataly.tasktracker.infra.jpa.enums.Role;

import java.util.List;

@Value
@Builder(toBuilder = true)
public class Employee {
    Long id;
    String name;
    String phoneNumber;
    String email;
    Role role;
    List<Task> tasks;
}
