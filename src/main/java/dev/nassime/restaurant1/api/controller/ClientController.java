package dev.nassime.restaurant1.api.controller;

import dev.nassime.restaurant1.api.model.ClientLoginDTO;
import dev.nassime.restaurant1.api.model.ClientLoginResponseDTO;
import dev.nassime.restaurant1.api.model.ClientRegistrationDTO;
import dev.nassime.restaurant1.entities.Client;
import dev.nassime.restaurant1.exception.ClientAlreadyExistException;
import dev.nassime.restaurant1.exception.ClientDoesNotExistException;
import dev.nassime.restaurant1.services.ClientService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/client")
@AllArgsConstructor
public class ClientController {
    private ClientService clientService;

//    @GetMapping("/get")
//    public List<Client> getClients(){
//        return clientService.getClients();
////        try{
////            List<Client> clients = clientService.getClients();
////            return new ResponseEntity<>(clients, HttpStatus.OK);
////        }catch (Exception e){
////            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
////        }
//    }
//
//    @GetMapping("/getById/{id}")
//    public Client getClient(@PathVariable long id) throws ClientDoesNotExistException {
//        return clientService.getClient(id);
//    }
//
//    @GetMapping("/getByUsername/{username}")
//    public Client getClient(@PathVariable String username) throws ClientDoesNotExistException {
//        return clientService.getClient(username);
//    }

    @PostMapping(path = "/add")
    public ResponseEntity<String> addClient(@RequestBody ClientRegistrationDTO registrationDTO)
            throws ClientAlreadyExistException {
        clientService.addClient(registrationDTO);
        return new ResponseEntity<>("succes", HttpStatus.CREATED);
    }

    @PostMapping("/delete")
    public ResponseEntity<String> deleteClient(@RequestBody long id)
            throws ClientDoesNotExistException {

        clientService.deleteClient(id);
        return new ResponseEntity<>("Succes", HttpStatus.OK);

    }

    @PostMapping(path = "/login")
    public ClientLoginResponseDTO login(@RequestBody ClientLoginDTO clientLoginDTO){
        String jwt = clientService.loginClient(clientLoginDTO);
        if(jwt == null){
            return null;
        }else {
            return new ClientLoginResponseDTO(jwt);
        }
    }

    @GetMapping("/actual")
    public ClientRegistrationDTO getActualClient(@AuthenticationPrincipal Client client) {

        if (client.getUsername() != null) {
            ClientRegistrationDTO clientRegistrationDTO = new ClientRegistrationDTO(client.getUsername(),
                    client.getPassword(), client.getEmail(), client.getRib());
            System.out.println("Client Response: " + clientRegistrationDTO.toString());
            return clientRegistrationDTO;
        }
        // Retourne une réponse explicite avec un statut 401 et un message JSON
        return null;
    }
}
