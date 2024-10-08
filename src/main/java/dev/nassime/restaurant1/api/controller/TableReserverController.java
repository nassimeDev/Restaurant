package dev.nassime.restaurant1.api.controller;

import dev.nassime.restaurant1.api.model.TableReseverDTO;
import dev.nassime.restaurant1.entities.Client;
import dev.nassime.restaurant1.entities.TableReserver;
import dev.nassime.restaurant1.entities.TypeTable;
import dev.nassime.restaurant1.exception.ClientDoesNotExistException;
import dev.nassime.restaurant1.exception.RepasDoesNotExistException;
import dev.nassime.restaurant1.exception.TableReserverDoesNotExistException;
import dev.nassime.restaurant1.services.TableReserverService;
import dev.nassime.restaurant1.services.TypeTableService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.annotation.AuthenticationPrincipal;


@RestController
@RequestMapping("/tableReserver")
@AllArgsConstructor
public class TableReserverController {

    private TypeTableService typeTableService;
    private TableReserverService tableReserverService;

    //-------- admin feature property-------------------
//    @GetMapping(path = "/get")
//    public List<TableReserver> getTablesReserver(){
//        return tableReserverService.getTableReserver();
//    }

    @PostMapping(path = "/add")
    public ResponseEntity<String> addTablesReserver(@AuthenticationPrincipal Client client, @Valid @RequestBody TableReseverDTO tableReserverDTO)
            throws TableReserverDoesNotExistException, ClientDoesNotExistException {

        TypeTable typeTable = typeTableService.getTypeTable(tableReserverDTO.getTypeTableId());
        TableReserver tableReserver = new TableReserver();
        tableReserver.setDateTable(tableReserverDTO.getDateTable());
        tableReserver.setHeurTable(tableReserverDTO.getHeurTable());
        tableReserver.setNbPersonneTable(tableReserverDTO.getNbPersonneTable());
        tableReserver.setClient(client);
        tableReserver.setTypeTable(typeTable);

        tableReserverService.addTableReserver(tableReserver);
        return new ResponseEntity<>("Succes", HttpStatus.CREATED);

    }

    @PostMapping("/delete")
    public ResponseEntity<String> deleteTableReserver(@RequestBody long id)
            throws RepasDoesNotExistException {
        tableReserverService.deleteTableReserver(id);
        return new ResponseEntity<>("Succes", HttpStatus.OK);

    }

    @GetMapping("/getReservation")
    public ResponseEntity<TableReserver> getReservation(@AuthenticationPrincipal Client client){
        TableReserver tableReserver = tableReserverService.getReservation(client);
        return new ResponseEntity<>(tableReserver, HttpStatus.OK);
    }
}
