package ru.nataly.tasktracker.infra.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import ru.nataly.tasktracker.domain.model.Task;
import ru.nataly.tasktracker.infra.jpa.entity.TaskEntity;
import ru.nataly.tasktracker.infra.jpa.repository.ClientJpaRepository;
import ru.nataly.tasktracker.infra.jpa.repository.EmployeeJpaRepository;

@Mapper(componentModel = "spring")
public abstract class TaskMapper {

    @Autowired
    protected EmployeeJpaRepository employeeJpaRepository;
    @Autowired
    protected ClientJpaRepository clientJpaRepository;

    @Mapping(target = "employeeId", source = "employee.id")
    @Mapping(target = "clientId", source = "client.id")
    public abstract Task map(TaskEntity entity);

    @Mapping(target = "employee", expression = "java(employeeJpaRepository.findById(task.getEmployeeId()).orElseThrow())")
    @Mapping(target = "client", expression = "java(clientJpaRepository.findById(task.getClientId()).orElseThrow())")
    public abstract TaskEntity map(Task task);
}
