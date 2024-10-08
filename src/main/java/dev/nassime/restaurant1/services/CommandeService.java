package dev.nassime.restaurant1.services;

import dev.nassime.restaurant1.entities.Client;
import dev.nassime.restaurant1.entities.Commande;
import dev.nassime.restaurant1.entities.TableReserver;
import dev.nassime.restaurant1.entities.dao.CommandeDao;
import dev.nassime.restaurant1.exception.CommandeDoesNotExistException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class CommandeService {

    private CommandeDao commandeDao;

    //-------------------- admin feature ----------------------------
    public List<Commande> getCommandes() {
        return commandeDao.findAll();
    }

    public List<Commande> getCommandeByClient(Client client) {
        return commandeDao.findCommandeByClient(client);
    }
//    public Commande getCommandes(long id) {
//        return commandeDao.findById(id).orElse(null);
//    }

    public Commande addCommand(Commande commande) {
        return commandeDao.save(commande);
    }

    public void deleteCommande(long id) throws CommandeDoesNotExistException {
        Optional<Commande> commande = commandeDao.findById(id);
        if (commande.isEmpty()) {
            throw new CommandeDoesNotExistException("Commande Not Found");
        }
        // Supprimer les associations d'abord si nécessaire
        Commande foundCommande = commande.get();
        foundCommande.getRepas().clear(); // Vide la liste des repas
        foundCommande.setClient(null); // Supprime l'association client

        // Sauvegarder les changements avant de supprimer
        commandeDao.save(foundCommande);

        // Maintenant, supprimer la commande
        commandeDao.deleteById(id);
    }



}
