package ru.nataly.tasktracker.app.repository.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.nataly.tasktracker.app.repository.ClientRepository;
import ru.nataly.tasktracker.domain.model.Client;
import ru.nataly.tasktracker.infra.jpa.mapper.ClientMapper;
import ru.nataly.tasktracker.infra.jpa.repository.ClientJpaRepository;

@Repository
@RequiredArgsConstructor
public class ClientRepositoryImpl implements ClientRepository {

    private final ClientJpaRepository clientJpaRepository;
    private final ClientMapper clientMapper;

    @Override
    public Client findByPhoneNumber(String phoneNumber) {
        return clientMapper.map(clientJpaRepository.findByPhoneNumber(phoneNumber));
    }

    @Override
    public void save(Client client) {
        clientJpaRepository.save(clientMapper.map(client));
    }
}
