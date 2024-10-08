package dev.nassime.restaurant1.api.model;

import dev.nassime.restaurant1.entities.TypeRepas;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@AllArgsConstructor
public class RepasDTO {

    @NotNull
    @NotBlank
    private byte[] imageRepas;
    @NotNull
    @NotBlank
    private String nomRepas;
    @NotNull
    @NotBlank
    private float prixRepas;
    @NotNull
    @NotBlank
    private LocalTime heurRepas;
    @NotNull
    @NotBlank
    private TypeRepas typeRepas;
}
