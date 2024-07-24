package utils;

import dto.ClientDto;
import dto.PaymentDto;
import entities.ClientEntity;
import entities.PaymentEntity;
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

    public PaymentEntity mapToPaymentEntity(PaymentDto dto){
        PaymentEntity entity = new PaymentEntity();
        entity.setId(dto.getId());
        entity.setDate(dto.getDate());
        entity.setAmount(dto.getAmount());
        entity.setRecipient(dto.getRecipient());
        entity.setMessage(dto.getMessage());
        return entity;
    }

    public PaymentDto mapToPaymentDto(PaymentEntity entity){
        PaymentDto dto = new PaymentDto();
        dto.setId(entity.getId());
        dto.setDate(entity.getDate());
        dto.setAmount(entity.getAmount());
        dto.setRecipient(entity.getRecipient());
        dto.setMessage(entity.getMessage());
        return dto;
    }
}