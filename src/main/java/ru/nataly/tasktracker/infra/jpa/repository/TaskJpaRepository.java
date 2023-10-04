package ru.nataly.tasktracker.infra.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nataly.tasktracker.infra.jpa.entity.EmployeeEntity;
import ru.nataly.tasktracker.infra.jpa.entity.TaskEntity;

import java.util.List;

public interface TaskJpaRepository extends JpaRepository<TaskEntity, Long> {

    List<TaskEntity> findAllByEmployee(EmployeeEntity employee);

    List<TaskEntity> findAllByEmployeeAndIsDone(EmployeeEntity employee, boolean isDone);

    List<TaskEntity> findAllByIsDone(boolean isDone);
}
