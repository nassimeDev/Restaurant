package dev.nassime.restaurant1.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@Table(name = "table_reserver")

public class TableReserver {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_table_reserver")
    private long id;

    @Column(name = "date_table", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateTable;

    @Column(name = "heur_table", nullable = false)
    private LocalTime heurTable;

    @Column(name = "nombre_personne_table", nullable = false)
    private int nbPersonneTable;

    @OneToOne()
    @JoinColumn(name = "id_type_table")
    private TypeTable typeTable;

    @OneToOne()
    @JoinColumn(name = "id_client")
    @JsonIgnore
    private Client client;

}
