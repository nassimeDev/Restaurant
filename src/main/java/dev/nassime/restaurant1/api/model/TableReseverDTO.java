package dev.nassime.restaurant1.api.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
public class TableReseverDTO {

    @NotNull
    private LocalDate dateTable;
    @NotNull
    private LocalTime heurTable;
    @NotNull
    private int nbPersonneTable;
    @NotNull
    private long typeTableId;
}
