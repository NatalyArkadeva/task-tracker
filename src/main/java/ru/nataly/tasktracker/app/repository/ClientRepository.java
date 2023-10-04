package ru.nataly.tasktracker.app.repository;

import org.springframework.stereotype.Repository;
import ru.nataly.tasktracker.domain.model.Client;
import ru.nataly.tasktracker.domain.model.Task;

import java.util.List;

@Repository
public interface ClientRepository {

    Client findByPhoneNumber(String phoneNumber);

    void save(Client client);
}
