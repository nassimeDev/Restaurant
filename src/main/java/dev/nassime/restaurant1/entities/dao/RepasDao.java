package dev.nassime.restaurant1.entities.dao;

import dev.nassime.restaurant1.entities.Client;
import dev.nassime.restaurant1.entities.Repas;
import org.springframework.data.repository.ListCrudRepository;

public interface RepasDao extends ListCrudRepository<Repas, Long> {
}
