package dev.nassime.restaurant1.services;

import dev.nassime.restaurant1.api.model.RepasDTO;
import dev.nassime.restaurant1.entities.Commentaire;
import dev.nassime.restaurant1.entities.Repas;
import dev.nassime.restaurant1.entities.dao.RepasDao;
import dev.nassime.restaurant1.exception.CommentaireDoesNotExistException;
import dev.nassime.restaurant1.exception.RepasDoesNotExistException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RepasService {

    RepasDao repasDao;

    public Repas addRepas(RepasDTO repasDTO) {
        Repas repas = new Repas();
        repas.setHeurRepas(repasDTO.getHeurRepas());
        repas.setNomRepas(repasDTO.getNomRepas());
        repas.setImageRepas(repasDTO.getImageRepas());
        repas.setPrixRepas(repasDTO.getPrixRepas());
        repas.setTypeRepas(repasDTO.getTypeRepas());
        return repasDao.save(repas);
    }

    public List<Repas> getRepas() {
        return repasDao.findAll();
    }

    public Repas getRepas(long id){
        Optional<Repas> repas =  repasDao.findById(id);
        return repas.orElse(null);
    }

    public void deleteRepas(long id) throws RepasDoesNotExistException {

        Optional<Repas> repas = repasDao.findById(id);
        if (repas.isEmpty()){
            throw new CommentaireDoesNotExistException("Commentaire Not Found");
        }
        repasDao.deleteById(id);
    }
}
