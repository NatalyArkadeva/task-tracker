package ru.nataly.tasktracker.infra.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nataly.tasktracker.infra.jpa.entity.EmployeeEntity;
import ru.nataly.tasktracker.infra.jpa.entity.TaskEntity;

public interface EmployeeJpaRepository extends JpaRepository<EmployeeEntity, Long> {
}
