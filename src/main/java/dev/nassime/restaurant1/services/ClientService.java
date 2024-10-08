package dev.nassime.restaurant1.services;

import dev.nassime.restaurant1.api.model.ClientLoginDTO;
import dev.nassime.restaurant1.api.model.ClientRegistrationDTO;
import dev.nassime.restaurant1.entities.Client;
import dev.nassime.restaurant1.entities.dao.ClientDao;
import dev.nassime.restaurant1.exception.ClientAlreadyExistException;
import dev.nassime.restaurant1.exception.ClientDoesNotExistException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClientService {

    private ClientDao clientDao;
    private EncryptionService encryptionService;
    private JWTService jWTService;

    public List<Client> getClients() {
        return clientDao.findAll();
    }

    public Client getClient(long id) throws ClientDoesNotExistException {
        Optional<Client> client =  clientDao.findById(id);
        if(client.isEmpty()) {
            throw new ClientDoesNotExistException("Client not found");
        }
        return client.get();
    }
    public Client getClient(String username) throws ClientDoesNotExistException {
        Optional<Client> client =  clientDao.findByUsernameIgnoreCase(username);
        if(client.isEmpty()) {
            throw new ClientDoesNotExistException("Client not found");
        }
        return client.get();
    }

    public Client addClient(ClientRegistrationDTO c) throws ClientAlreadyExistException {
        if (clientDao.findByUsernameIgnoreCase(c.getUsername()).isPresent() ||
            clientDao.findByEmailIgnoreCase(c.getEmail()).isPresent() ||
            clientDao.findByRibIgnoreCase(c.getRib()).isPresent()){
            throw new ClientAlreadyExistException();
        }
        String passwordCypter = encryptionService.encryptPassword(c.getPassword());
        Client client = new Client(c.getUsername(), passwordCypter, c.getEmail(), c.getRib());
        return clientDao.save(client);
    }

    public void deleteClient(long id) throws ClientDoesNotExistException {
        Optional<Client> client =  clientDao.findById(id);
        if(client.isEmpty()) {
            throw new ClientDoesNotExistException("Client not found");
        }
        clientDao.deleteById(id);
    }

    public String loginClient(ClientLoginDTO c){
        Optional<Client> client =  clientDao.findByUsernameIgnoreCase(c.getUsername());
        if(client.isPresent()) {
            if(encryptionService.checkPassword(c.getPassword(), client.get().getPassword())) {
                return jWTService.generateToken(c.getUsername());
            }
        }
        return null;
    }
}
