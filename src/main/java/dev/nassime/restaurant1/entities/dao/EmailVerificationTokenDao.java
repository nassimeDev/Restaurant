package dev.nassime.restaurant1.entities.dao;

import dev.nassime.restaurant1.entities.Client;
import dev.nassime.restaurant1.entities.EmailVerificationToken;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;
import java.util.Optional;

public interface EmailVerificationTokenDao extends ListCrudRepository<EmailVerificationToken, Long> {

    Optional<EmailVerificationToken> getByToken(String token);

    void deleteByClient(Client client);
}
