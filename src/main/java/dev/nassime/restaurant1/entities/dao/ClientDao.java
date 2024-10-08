package dev.nassime.restaurant1.entities.dao;

import dev.nassime.restaurant1.entities.Client;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface ClientDao extends ListCrudRepository<Client, Long> {
    Optional<Client> findByUsernameIgnoreCase(String username);

    Optional<Client> findByEmailIgnoreCase(String email);

    Optional<Client> findByRibIgnoreCase(String rib);
}
