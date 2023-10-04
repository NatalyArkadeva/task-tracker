package ru.nataly.tasktracker.infra.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nataly.tasktracker.infra.jpa.entity.Account;
import ru.nataly.tasktracker.infra.jpa.entity.EmployeeEntity;

public interface AccountJpaRepository extends JpaRepository<Account, Long> {
}
