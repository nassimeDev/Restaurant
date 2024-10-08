package dev.nassime.restaurant1.exception;

public class ClientDoesNotExistException extends RuntimeException {
    public ClientDoesNotExistException(String message) {
        super(message);
    }
}
