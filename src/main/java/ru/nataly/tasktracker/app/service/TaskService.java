package ru.nataly.tasktracker.app.service;

import org.springframework.stereotype.Service;
import ru.nataly.tasktracker.infra.jpa.entity.EmployeeEntity;
import ru.nataly.tasktracker.infra.jpa.entity.TaskEntity;

import java.util.List;

@Service
public interface TaskService {

    TaskEntity save(TaskEntity task);

    List<TaskEntity> findAllByEmployee(EmployeeEntity employee);

    List<TaskEntity> findAllByEmployeeAndIsDone(EmployeeEntity employee, boolean isDone);

    List<TaskEntity> findAll();

    List<TaskEntity> findAllInProgress();

    TaskEntity findById(Long id);
}
