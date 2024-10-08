package dev.nassime.restaurant1.exception;

public class TypeTableDoesNotExistException extends RuntimeException {
    public TypeTableDoesNotExistException(String message) {
        super(message);
    }
}
