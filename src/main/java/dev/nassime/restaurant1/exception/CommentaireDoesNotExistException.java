package dev.nassime.restaurant1.exception;

public class CommentaireDoesNotExistException extends RuntimeException {
    public CommentaireDoesNotExistException(String message) {
        super(message);
    }
}
