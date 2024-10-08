package dev.nassime.restaurant1.api.model;


import dev.nassime.restaurant1.entities.Client;
import dev.nassime.restaurant1.entities.Repas;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommandeDTO {
    Client client;
    List<RepasDTO> repas = new ArrayList<RepasDTO>();
}
