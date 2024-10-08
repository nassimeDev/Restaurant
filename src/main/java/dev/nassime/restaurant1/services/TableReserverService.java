package dev.nassime.restaurant1.services;

import dev.nassime.restaurant1.entities.Client;
import dev.nassime.restaurant1.entities.TableReserver;
import dev.nassime.restaurant1.entities.dao.TableReseverDao;
import dev.nassime.restaurant1.exception.TableReserverDoesNotExistException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class TableReserverService {

    private TableReseverDao tableReserverDao;

    public TableReserver addTableReserver(TableReserver tableResever) {
        return tableReserverDao.save(tableResever);
    }

    //------------ admin feature -----------------------
//    public List<TableReserver> getTableReserver() {
//        return tableReserverDao.findAll();
//    }

//    public TableReserver getTableReserver(long id) throws TableReserverDoesNotExistException {
//        Optional<TableReserver> tableReserver =  tableReserverDao.findById(id);
//        if (tableReserver.isEmpty()){
//            throw new TableReserverDoesNotExistException("TableReserver Not Found");
//        }
//        return tableReserver.get();
//    }

    public void deleteTableReserver(long id) throws TableReserverDoesNotExistException {
        Optional<TableReserver> optableReserver = tableReserverDao.findById(id);
        if (optableReserver.isEmpty()){
            throw new TableReserverDoesNotExistException("Table Reservation Not Found");
        }
        optableReserver.get().setTypeTable(null);
        optableReserver.get().setClient(null);
        tableReserverDao.deleteById(id);
    }

        public TableReserver getReservation(long id){
        Optional<TableReserver> tableReserver =  tableReserverDao.findById(id);
        if (tableReserver.isEmpty()){
            throw new TableReserverDoesNotExistException("Table Reserved, Not Found");
        }
        return tableReserver.get();
    }
    public TableReserver getReservation(Client client){
        TableReserver tableReserver =  tableReserverDao.findByClient(client);
        if (tableReserver == null){
            throw new TableReserverDoesNotExistException("Table Reserved, Not Found");
        }
        return tableReserver;
    }
}
