package dev.nassime.restaurant1.entities.dao;

import dev.nassime.restaurant1.entities.Client;
import dev.nassime.restaurant1.entities.Commentaire;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface CommentaireDao extends ListCrudRepository<Commentaire, Long> {
    List<Commentaire> getCommentairesByClient(Client client);
}
