package ru.nataly.tasktracker.app.service;

import org.springframework.stereotype.Service;
import ru.nataly.tasktracker.domain.model.Client;
import ru.nataly.tasktracker.infra.jpa.entity.ClientEntity;

@Service
public interface ClientService {

    ClientEntity findByPhoneNumber(String phoneNumber);

    void save(ClientEntity client);
}
