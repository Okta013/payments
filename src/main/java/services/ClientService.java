package services;

import dto.ClientDto;
import entities.ClientEntity;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repositories.ClientRepository;
import utils.MappingUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final MappingUtils mappingUtils;

    public ClientService(ClientRepository clientRepository, MappingUtils mappingUtils) {
        this.clientRepository = clientRepository;
        this.mappingUtils = mappingUtils;
    }

    public List<ClientDto> findAll() {
        return clientRepository.findAll().stream().
                map(mappingUtils::mapToClientDto).collect(Collectors.toList());
    }

    public ClientDto findById(Long id) {
        return mappingUtils.mapToClientDto(clientRepository.findById(id).orElse(new ClientEntity()));
    }

    public ClientDto save(ClientDto clientDto) {
        ClientEntity clientEntity = mappingUtils.mapToClientEntity(clientDto);
        clientEntity = clientRepository.save(clientEntity);
        return mappingUtils.mapToClientDto(clientEntity);
    }

    public ClientDto update(Long id, ClientDto clientDto) {
        ClientEntity clientEntity = clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client not found"));
        clientEntity.setName(clientDto.getName());
        clientEntity.setPhone(clientDto.getPhone());
        clientEntity.setBalancing(clientDto.getBalancing());
        clientRepository.save(clientEntity);
        return mappingUtils.mapToClientDto(clientEntity);
    }

    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    @Transactional
    public void pay(Long idDonor, Long idRecepient, Double amount) {
        try {
            ClientEntity donorEntity = clientRepository.findById(idDonor).orElseThrow(()
                    -> new RuntimeException("Client not found"));
            ClientEntity recepientEntity = clientRepository.findById(idRecepient).orElseThrow(()
                    -> new RuntimeException("Client not found"));
            donorEntity.setBalancing(donorEntity.getBalancing() - amount);
            recepientEntity.setBalancing(recepientEntity.getBalancing() + amount);
            clientRepository.save(donorEntity);
            clientRepository.save(recepientEntity);
        }
        catch (RuntimeException e) {
            throw e;
        }
    }
}
