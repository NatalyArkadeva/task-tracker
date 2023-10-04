package ru.nataly.tasktracker.app.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nataly.tasktracker.app.service.TaskService;
import ru.nataly.tasktracker.infra.jpa.entity.EmployeeEntity;
import ru.nataly.tasktracker.infra.jpa.entity.TaskEntity;
import ru.nataly.tasktracker.infra.jpa.repository.TaskJpaRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskJpaRepository taskJpaRepository;

    @Override
    public TaskEntity save(TaskEntity task) {
        return taskJpaRepository.save(task);
    }

    @Override
    public List<TaskEntity> findAllByEmployee(EmployeeEntity employee) {
        return taskJpaRepository.findAllByEmployee(employee);
    }

    @Override
    public List<TaskEntity> findAllByEmployeeAndIsDone(EmployeeEntity employee, boolean isDone) {
        return taskJpaRepository.findAllByEmployeeAndIsDone(employee, isDone);
    }

    @Override
    public List<TaskEntity> findAll() {
        return taskJpaRepository.findAll();
    }

    @Override
    public List<TaskEntity> findAllInProgress() {
        return taskJpaRepository.findAllByIsDone(false);
    }

    @Override
    public TaskEntity findById(Long id) {
        return taskJpaRepository.findById(id).orElseThrow();
    }
}
