package dev.nassime.restaurant1.exception;

public class RepasDoesNotExistException extends RuntimeException {
    public RepasDoesNotExistException(String message) {
        super(message);
    }
}
