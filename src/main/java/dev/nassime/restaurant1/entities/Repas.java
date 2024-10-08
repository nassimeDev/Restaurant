package dev.nassime.restaurant1.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.nassime.restaurant1.api.model.RepasDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "repas")
public class Repas {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_repas")
    private long id;

    @Column(name = "image_repas", columnDefinition = "LONGBLOB", nullable = false, unique = true)
    @Lob
    private byte[] imageRepas;

    @Column(name = "nom_repas", nullable = false, unique = true)
    private String nomRepas;

    @Column(name = "prix_repas", nullable = false)
    private float prixRepas;

    @Column(name = "heur_repas", nullable = false)
    private LocalTime heurRepas;

    @Column(name = "type_repas", nullable = false)
    @Enumerated(EnumType.STRING)
    private TypeRepas typeRepas;

    @ManyToMany(mappedBy = "repas")
    @JsonIgnore
    private List<Commande> commandes = new ArrayList<>();

    public RepasDTO toRepasDTO() {
        return new RepasDTO(imageRepas, nomRepas, prixRepas, heurRepas, typeRepas);
    }


}
