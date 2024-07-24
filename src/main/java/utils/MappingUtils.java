package utils;

import dto.ClientDto;
import entities.ClientEntity;
import org.springframework.stereotype.Service;

@Service
public class MappingUtils {
    //из entity в dto
    public ClientDto mapToClientDto(ClientEntity entity){
        ClientDto dto = new ClientDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setPhone(entity.getPhone());
        dto.setBalancing(entity.getBalancing());
        return dto;
    }
    //из dto в entity
    public ClientEntity mapToClientEntity(ClientDto dto){
        ClientEntity entity = new ClientEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setPhone(dto.getPhone());
        entity.setBalancing(dto.getBalancing());
        return entity;
    }
}