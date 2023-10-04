package ru.nataly.tasktracker.infra.jpa.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.nataly.tasktracker.domain.model.Client;
import ru.nataly.tasktracker.infra.jpa.entity.ClientEntity;

@Mapper(componentModel = "spring",
        uses = TaskMapper.class
)
public interface ClientMapper {

    @BeanMapping(ignoreUnmappedSourceProperties = "role")
    Client map(ClientEntity entity);

    @Mapping(target = "role", ignore = true)
    ClientEntity map(Client client);
}
