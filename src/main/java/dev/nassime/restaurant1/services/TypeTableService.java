package dev.nassime.restaurant1.services;

import dev.nassime.restaurant1.entities.TableReserver;
import dev.nassime.restaurant1.entities.TypeTable;
import dev.nassime.restaurant1.entities.dao.TypeTableDao;
import dev.nassime.restaurant1.exception.CommentaireDoesNotExistException;
import dev.nassime.restaurant1.exception.TableReserverDoesNotExistException;
import dev.nassime.restaurant1.exception.TypeTableDoesNotExistException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TypeTableService {

    private TypeTableDao typeTableDao;

    //----------------------admin feature----------------------------
    public TypeTable addTypeTable(TypeTable typeTable) {
        return typeTableDao.save(typeTable);
    }

    public List<TypeTable> getTypeTables() throws TypeTableDoesNotExistException {
        List<TypeTable> tables =  typeTableDao.findAll();
        if(tables.isEmpty()) {
            throw new TypeTableDoesNotExistException("Type table doesn't exist");
        }
        return tables;
    }

    public TypeTable getTypeTable(long id) {
        return typeTableDao.findById(id).orElse(null);
    }

    //----------------------admin feature----------------------------
    public void deleteTypeTable(long id) throws TypeTableDoesNotExistException {
        Optional<TypeTable> typeTable = typeTableDao.findById(id);
        if (typeTable.isEmpty()){
            throw new CommentaireDoesNotExistException("Table Not Found");
        }
        typeTableDao.deleteById(id);
    }
}
