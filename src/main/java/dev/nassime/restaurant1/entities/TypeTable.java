package dev.nassime.restaurant1.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
@Table(name = "type_table")
public class TypeTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_type_table")
    private long id;

    @Column(name = "nom_table", nullable = false, unique = true)
    private String nomTable;

    @Column(name = "description_table", nullable = false, unique = true)
    private String descriptionTable;

    @Column(name = "prix")
    private float prix;

    @OneToOne(mappedBy = "typeTable")
    @JsonIgnore
    private TableReserver tableReserver;

    public TypeTable(String nomTable, String descriptionTable, float prix) {
        this.nomTable = nomTable;
        this.descriptionTable = descriptionTable;
        this.prix = prix;
    }
}
