package dev.nassime.restaurant1.services;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class EncryptionService {

    @Value("${encryption.salt.round}")
    private int saltRound;

    private String salt;

    @PostConstruct
    public void postConstruct() {
        salt = BCrypt.gensalt(saltRound);
    }

    //---------------cryptage---------------------
    public String encryptPassword(String password) {
        return BCrypt.hashpw(password, salt);
    }
    //---------------verification------------------
    public boolean checkPassword(String password, String encryptedPassword) {
        return BCrypt.checkpw(password, encryptedPassword);
    }
}
