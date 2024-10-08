package dev.nassime.restaurant1.entities.dao;
import dev.nassime.restaurant1.entities.Client;
import dev.nassime.restaurant1.entities.TableReserver;
import org.springframework.data.repository.ListCrudRepository;

public interface TableReseverDao extends ListCrudRepository<TableReserver, Long> {
    TableReserver findByClient(Client client);
}
