package dev.nassime.restaurant1.api.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CommentaireDTO {
    @NotNull
    private String commentaire;
}
