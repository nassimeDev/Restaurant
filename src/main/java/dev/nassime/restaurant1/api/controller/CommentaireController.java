package dev.nassime.restaurant1.api.controller;

import dev.nassime.restaurant1.api.model.CommentaireDTO;
import dev.nassime.restaurant1.entities.Client;
import dev.nassime.restaurant1.entities.Commentaire;
import dev.nassime.restaurant1.exception.ClientDoesNotExistException;
import dev.nassime.restaurant1.exception.CommandeDoesNotExistException;
import dev.nassime.restaurant1.exception.CommentaireDoesNotExistException;
import dev.nassime.restaurant1.services.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commentaire")
@AllArgsConstructor
public class CommentaireController {

    private CommentaireService commentaireService;

    @GetMapping(path = "/getAll")
    public List<Commentaire> getAllCommentaires() {
        return commentaireService.getAllCommentaires();
    }

    @GetMapping(path = "/get")
    public List<Commentaire> getCommentaires(@AuthenticationPrincipal Client client) {
        return commentaireService.getCommentaire(client);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<String> addCommande(@AuthenticationPrincipal Client client, @RequestBody CommentaireDTO commentaireDTO)
    throws ClientDoesNotExistException {
        Commentaire commentaire = new Commentaire();
        commentaire.setCommentaire(commentaireDTO.getCommentaire());
        commentaire.setClient(client);
        commentaireService.addCommentaire(commentaire);

        return new ResponseEntity<>("Succes", HttpStatus.CREATED);
    }

    @PostMapping("/delete")
    public ResponseEntity<String> deleteCommentaire(@RequestBody Long id)
            throws CommentaireDoesNotExistException {

        commentaireService.deleteCommentaire(id);
        return new ResponseEntity<>("Succes", HttpStatus.OK);

    }
}
