package dev.nassime.restaurant1.api.controller;

import dev.nassime.restaurant1.api.model.CommandeDTO;
import dev.nassime.restaurant1.api.model.RepasDTO;
import dev.nassime.restaurant1.entities.Client;
import dev.nassime.restaurant1.entities.Commande;
import dev.nassime.restaurant1.entities.Repas;
import dev.nassime.restaurant1.entities.TableReserver;
import dev.nassime.restaurant1.exception.ClientDoesNotExistException;
import dev.nassime.restaurant1.exception.CommandeDoesNotExistException;
import dev.nassime.restaurant1.exception.RepasDoesNotExistException;
import dev.nassime.restaurant1.exception.TableReserverDoesNotExistException;
import dev.nassime.restaurant1.services.CommandeService;
import dev.nassime.restaurant1.services.RepasService;
import dev.nassime.restaurant1.services.TableReserverService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commande")
@AllArgsConstructor
public class CommandeController {

    private CommandeService commandeService;
    private RepasService repasService;
    //-------------------- admin feature ----------------------------
    @GetMapping(path = "/getAll")
    public List<Commande> getCommandes() {
        return commandeService.getCommandes();
    }
    @PostMapping("/delete")
    public ResponseEntity<String> deleteCommande(@RequestBody long id)
            throws CommandeDoesNotExistException {
        commandeService.deleteCommande(id);
        return new ResponseEntity<>("Succes", HttpStatus.OK);

    }

    @GetMapping("/get")
    public List<Commande> getCommande(@AuthenticationPrincipal Client client){
        return commandeService.getCommandeByClient(client);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<String> addCommande(@AuthenticationPrincipal Client client,@RequestBody List<Long> repasId) {
        if(client != null){
            Commande commande = new Commande();
            commande.setClient(client);
            Repas repas;
            for(int i=0; i<repasId.size(); i++){
                repas = repasService.getRepas(repasId.get(i));
                if(repas != null){
                    commande.getRepas().add(repas);
                }
            }
            commandeService.addCommand(commande);
            return new ResponseEntity<>("succes", HttpStatus.OK);
        }
        return new ResponseEntity<>("failure", HttpStatus.CONFLICT);

    }

}
