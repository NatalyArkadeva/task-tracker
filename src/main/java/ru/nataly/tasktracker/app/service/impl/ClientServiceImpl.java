package ru.nataly.tasktracker.app.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nataly.tasktracker.app.service.ClientService;
import ru.nataly.tasktracker.infra.jpa.entity.ClientEntity;
import ru.nataly.tasktracker.infra.jpa.repository.ClientJpaRepository;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientJpaRepository clientJpaRepository;

    @Override
    public ClientEntity findByPhoneNumber(String phoneNumber) {
        return clientJpaRepository.findByPhoneNumber(phoneNumber);
    }

    @Override
    public void save(ClientEntity client) {
        clientJpaRepository.save(client);
    }
}
