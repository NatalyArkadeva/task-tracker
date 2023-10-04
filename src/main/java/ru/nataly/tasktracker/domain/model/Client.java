package ru.nataly.tasktracker.domain.model;

import lombok.Builder;
import lombok.Value;
import ru.nataly.tasktracker.infra.jpa.entity.TaskEntity;

import java.util.List;

@Value
@Builder(toBuilder = true)
public class Client {
    Long id;
    String name;
    String phoneNumber;
    List<Task> tasks;
}
