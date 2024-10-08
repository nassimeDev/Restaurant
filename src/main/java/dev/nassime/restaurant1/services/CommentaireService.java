package dev.nassime.restaurant1.services;

import dev.nassime.restaurant1.entities.Client;
import dev.nassime.restaurant1.entities.Commande;
import dev.nassime.restaurant1.entities.Commentaire;
import dev.nassime.restaurant1.entities.dao.CommentaireDao;
import dev.nassime.restaurant1.exception.CommentaireDoesNotExistException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CommentaireService {

    private CommentaireDao commentaireDao;

    public List<Commentaire> getAllCommentaires() {
        return commentaireDao.findAll();
    }

    public Commentaire getCommentaire(long id) {
        return commentaireDao.findById(id).orElse(null);
    }

    public List<Commentaire> getCommentaire(Client client) throws CommentaireDoesNotExistException {
        List<Commentaire> commentaires = commentaireDao.getCommentairesByClient(client);
        if (commentaires.isEmpty()) {
            throw new CommentaireDoesNotExistException("Commentaire Not Found");
        }
        return commentaires;
    }

    public Commentaire addCommentaire(Commentaire commentaire) {
        return commentaireDao.save(commentaire);
    }

    public void deleteCommentaire(long id) throws CommentaireDoesNotExistException {

        Optional<Commentaire> commentaire = commentaireDao.findById(id);
        if (commentaire.isEmpty()){
            throw new CommentaireDoesNotExistException("Commentaire Not Found");
        }
        commentaireDao.deleteById(id);
    }
}
