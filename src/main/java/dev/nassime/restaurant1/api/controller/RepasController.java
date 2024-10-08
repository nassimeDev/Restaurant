package dev.nassime.restaurant1.api.controller;

import dev.nassime.restaurant1.api.model.RepasDTO;
import dev.nassime.restaurant1.entities.Repas;
import dev.nassime.restaurant1.entities.TypeRepas;
import dev.nassime.restaurant1.exception.RepasDoesNotExistException;
import dev.nassime.restaurant1.services.RepasService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.time.LocalTime;
import java.util.List;

@RestController()
@RequestMapping("/repas")
@AllArgsConstructor
public class RepasController {

    private RepasService repasService;

    @PostMapping("/add")
    public ResponseEntity<String> addRepas(@RequestParam("imageRepas") MultipartFile imageRepas,
                                            @RequestParam("nomRepas") String nomRepas,
                                            @RequestParam("prixRepas") float prixRepas,
                                            @RequestParam("heurRepas") LocalTime heurRepas,
                                            @RequestParam("typeRepas") TypeRepas typeRepas
                                            ) {
        try{
            RepasDTO repasDTO = new RepasDTO(imageRepas.getBytes(), nomRepas, prixRepas, heurRepas, typeRepas);
            repasService.addRepas(repasDTO);
            return new ResponseEntity<>("Succes", HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get")
    public ResponseEntity<List<Repas>> getRepas() {
        try{
            return new ResponseEntity<>(repasService.getRepas(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<String> deleteRepas(@RequestBody long id)
            throws RepasDoesNotExistException {
        repasService.deleteRepas(id);
        return new ResponseEntity<>("Succes", HttpStatus.OK);

    }
}
