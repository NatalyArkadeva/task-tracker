package ru.nataly.tasktracker.app.service;

import org.springframework.stereotype.Service;
import ru.nataly.tasktracker.infra.jpa.entity.EmployeeEntity;

import java.util.List;

@Service
public interface EmployeeService {

    EmployeeEntity findById(Long id);

    void save(EmployeeEntity employee);

    List<EmployeeEntity> findAll();
}
