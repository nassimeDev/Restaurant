package dev.nassime.restaurant1.entities.dao;

import dev.nassime.restaurant1.entities.Client;
import dev.nassime.restaurant1.entities.Commande;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface CommandeDao extends ListCrudRepository<Commande, Long> {
    List<Commande> findCommandeByClient(Client client);
}
