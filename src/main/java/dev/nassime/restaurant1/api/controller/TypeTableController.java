package dev.nassime.restaurant1.api.controller;

import dev.nassime.restaurant1.entities.TypeTable;
import dev.nassime.restaurant1.exception.RepasDoesNotExistException;
import dev.nassime.restaurant1.services.TypeTableService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/typeTable")
@AllArgsConstructor
public class TypeTableController {

    private TypeTableService typeTableService;

    @PostMapping("/add")
    public TypeTable addTypeTable(@RequestBody TypeTable typeTable) {
        return typeTableService.addTypeTable(typeTable);
    }

    @GetMapping("/get")
    public List<TypeTable> getTypeTable() {
        return typeTableService.getTypeTables();
    }

    @PostMapping("/delete")
    public ResponseEntity<String> deleteTypeTable(@RequestBody long id)
            throws RepasDoesNotExistException {
        typeTableService.deleteTypeTable(id);
        return new ResponseEntity<>("Succes", HttpStatus.OK);

    }
}
