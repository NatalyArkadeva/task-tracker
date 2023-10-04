package ru.nataly.tasktracker.app.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nataly.tasktracker.app.service.EmployeeService;
import ru.nataly.tasktracker.infra.jpa.entity.EmployeeEntity;
import ru.nataly.tasktracker.infra.jpa.repository.EmployeeJpaRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeJpaRepository employeeJpaRepository;

    @Override
    public EmployeeEntity findById(Long id) {
        return employeeJpaRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(EmployeeEntity employee) {
        employeeJpaRepository.save(employee);
    }

    @Override
    public List<EmployeeEntity> findAll() {
        return employeeJpaRepository.findAll();
    }
}
