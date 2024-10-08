package dev.nassime.restaurant1.exception;


public class ClientNotVerifiedException extends Exception {
    private boolean newEmailResent;

    public ClientNotVerifiedException(boolean newEmailResent) {
        this.newEmailResent = newEmailResent;
    }

    public boolean isNewEmailResent() {
        return newEmailResent;
    }

    public void setNewEmailResent(boolean newEmailResent) {
        this.newEmailResent = newEmailResent;
    }
}
