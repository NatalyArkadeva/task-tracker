package ru.nataly.tasktracker.infra.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nataly.tasktracker.infra.jpa.entity.ClientEntity;

public interface ClientJpaRepository extends JpaRepository<ClientEntity, Long> {

    ClientEntity findByPhoneNumber(String phoneNumber);
}
