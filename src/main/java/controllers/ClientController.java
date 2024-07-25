package controllers;

import dto.ClientDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import services.ClientService;

import java.util.List;

@Controller
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<ClientDto> getAllClients() {
        return clientService.findAll();
    }

    @GetMapping("/{id}")
    public ClientDto getClientById(@PathVariable Long id) {
        return clientService.findById(id);
    }

    @GetMapping("/new")
    public String newClientForm(Model model) {
        ClientDto clientDto = new ClientDto();
        model.addAttribute("client", clientDto);
        return "newClient";
    }

    @PostMapping
    public ClientDto createClient(@Valid @RequestBody ClientDto clientDto) {
        ClientDto client = new ClientDto();
        client.setName(clientDto.getName());
        client.setPhone(clientDto.getPhone());
        client.setBalancing(clientDto.getBalancing());
        return clientService.save(client);
    }

//    @PutMapping("/{id}/edit")
//    public ResponseEntity<ClientEntity> updateClient(@PathVariable Long id, @Valid @RequestBody ClientDto clientDto) {
//        }
//    }




}
