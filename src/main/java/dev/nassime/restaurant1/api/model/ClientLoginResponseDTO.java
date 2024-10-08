package dev.nassime.restaurant1.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientLoginResponseDTO {

    private String jwt;
}
