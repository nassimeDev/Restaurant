package dev.nassime.restaurant1.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class EmailVerificationToken {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String token;
    private Timestamp timestamp;

    @ManyToOne
    private Client client;
}
