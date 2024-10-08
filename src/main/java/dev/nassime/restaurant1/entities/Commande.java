package dev.nassime.restaurant1.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "commande")
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_commande")
    private long id;

    @OneToOne
    @JoinColumn(name = "id_client")

    private Client client;

    @ManyToMany
    @JoinTable(
            name = "commande_repas", // nom de la table d'association
            joinColumns = @JoinColumn(name = "commande_id"), // clé étrangère pour Commande
            inverseJoinColumns = @JoinColumn(name = "repas_id") // clé étrangère pour Repas
    )
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Repas> repas = new ArrayList<>();

}
