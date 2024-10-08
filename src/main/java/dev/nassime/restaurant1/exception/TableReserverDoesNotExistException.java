package dev.nassime.restaurant1.exception;

public class TableReserverDoesNotExistException extends RuntimeException {
    public TableReserverDoesNotExistException(String message) {
        super(message);
    }
}
