package dev.nassime.restaurant1.exception;

public class CommandeDoesNotExistException extends RuntimeException {
    public CommandeDoesNotExistException(String message) {
        super(message);
    }
}
