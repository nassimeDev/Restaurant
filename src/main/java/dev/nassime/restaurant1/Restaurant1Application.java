package dev.nassime.restaurant1;

import dev.nassime.restaurant1.api.model.ClientRegistrationDTO;
import dev.nassime.restaurant1.api.model.RepasDTO;
import dev.nassime.restaurant1.entities.*;
import dev.nassime.restaurant1.entities.dao.ClientDao;
import dev.nassime.restaurant1.entities.dao.CommandeDao;
import dev.nassime.restaurant1.entities.dao.RepasDao;
import dev.nassime.restaurant1.entities.dao.TypeTableDao;
import dev.nassime.restaurant1.services.ClientService;
import dev.nassime.restaurant1.services.CommandeService;
import dev.nassime.restaurant1.services.RepasService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Restaurant1Application {

    public static void main(String[] args) {
        SpringApplication.run(Restaurant1Application.class, args);
    }



    @Bean
    public CommandLineRunner start(ClientService clientService, TypeTableDao typeTableDao, CommandeService commandeService, RepasService repasService) {
        return args -> {
//            //---------- ajouter des client-----------------------------------------
//            clientService.addClient(new ClientRegistrationDTO("nassime", "1234", "test@nassime", "4700776"));
//            clientService.addClient(new ClientRegistrationDTO("samir", "1234", "test@samir", "470000776"));
//
//            //----------- ajouter des tables---------------------------------------
//            typeTableDao.save(new TypeTable("Table Standard",
//                    "Une table classique conçue pour accueillir un petit groupe de personnes.",
//                    20));
//            typeTableDao.save(new TypeTable("Table à deux",
//                    "Une table plus petite conçue spécifiquement pour deux personnes, souvent utilisée pour des dîners intimes.",
//                    20));
//            typeTableDao.save(new TypeTable("Table romantique",
//                    "Une table spécialement aménagée pour les couples, avec une ambiance intime et romantique.",
//                      40));
//            typeTableDao.save(new TypeTable("Table VIP",
//                    "Une table spéciale réservée pour des clients VIP ou pour des occasions spéciales, offrant un service personnalisé et des avantages supplémentaires.",
//                    40));
//            typeTableDao.save(new TypeTable("Table en terrasse",
//                    "Une table située sur la terrasse du restaurant, offrant une ambiance extérieure et souvent une vue panoramique.",
//                    40));
//            typeTableDao.save(new TypeTable("Table  familiale",
//                    "Une grande table conçue pour accueillir des familles ou des groupes plus importants.",
//                    50));
        };
    }

    public void addImage(RepasService repasService) throws IOException {
        repasService.addRepas(new RepasDTO(
                loadImg("C://resource Image/boire.png"),"boire",15,
                LocalTime.of(6,0), TypeRepas.FOOD));
        repasService.addRepas(new RepasDTO(
                loadImg("C://resource Image/cereale.gif"),"cereale",20,
                LocalTime.of(6,0), TypeRepas.FOOD));
        repasService.addRepas(new RepasDTO(
                loadImg("C://resource Image/cola.png"),"cola",20,
                LocalTime.of(6,0), TypeRepas.POISSON));
        repasService.addRepas(new RepasDTO(
                loadImg("C://resource Image/cola_cannette.png"),"cola cannette",25,
                LocalTime.of(6,0), TypeRepas.POISSON));
        repasService.addRepas(new RepasDTO(
                loadImg("C://resource Image/crepes.gif"),"crepes",20,
                LocalTime.of(6,0), TypeRepas.PATISSERIE));
        repasService.addRepas(new RepasDTO(
                loadImg("C://resource Image/dejeuner.png"),"dejeuner",90,
                LocalTime.of(6,0), TypeRepas.FOOD));
        repasService.addRepas(new RepasDTO(
                loadImg("C://resource Image/dinde.png"),"dinde",80,
                LocalTime.of(6,0), TypeRepas.FOOD));
        repasService.addRepas(new RepasDTO(
                loadImg("C://resource Image/dinner.png"),"dinner",100,
                LocalTime.of(6,0), TypeRepas.FOOD));
        repasService.addRepas(new RepasDTO(
                loadImg("C://resource Image/drink_juice1.png"),"drink_juice1",15,
                LocalTime.of(6,0), TypeRepas.POISSON));
        repasService.addRepas(new RepasDTO(
                loadImg("C://resource Image/drink_juice2.png"),"drink_juice2",15,
                LocalTime.of(6,0), TypeRepas.POISSON));
        repasService.addRepas(new RepasDTO(
                loadImg("C://resource Image/drink_juice3.png"),"drink_juice3",15,
                LocalTime.of(6,0), TypeRepas.POISSON));
        repasService.addRepas(new RepasDTO(
                loadImg("C://resource Image/drink_juice4.png"),"drink_juice4",15,
                LocalTime.of(6,0), TypeRepas.POISSON));
        repasService.addRepas(new RepasDTO(
                loadImg("C://resource Image/drink_juice5.png"),"drink_juice5",15,
                LocalTime.of(6,0), TypeRepas.POISSON));
        repasService.addRepas(new RepasDTO(
                loadImg("C://resource Image/drink1.png"),"drink1",17.5f,
                LocalTime.of(6,0), TypeRepas.POISSON));
        repasService.addRepas(new RepasDTO(
                loadImg("C://resource Image/drink2.png"),"drink2",17.5f,
                LocalTime.of(6,0), TypeRepas.POISSON));
        repasService.addRepas(new RepasDTO(
                loadImg("C://resource Image/drink3.png"),"drink3",17.5f,
                LocalTime.of(6,0), TypeRepas.POISSON));
        repasService.addRepas(new RepasDTO(
                loadImg("C://resource Image/drink4.png"),"drink4",17.5f,
                LocalTime.of(6,0), TypeRepas.POISSON));
        repasService.addRepas(new RepasDTO(
                loadImg("C://resource Image/hot_dog.png"),"hot_dog",40,
                LocalTime.of(6,0), TypeRepas.FOOD));
        repasService.addRepas(new RepasDTO(
                loadImg("C://resource Image/lait.gif"),"lait",15,
                LocalTime.of(6,0), TypeRepas.POISSON));repasService.addRepas(new RepasDTO(
                loadImg("C://resource Image/nourriture.png"),"nourriture",30,
                LocalTime.of(6,0), TypeRepas.FOOD));
        repasService.addRepas(new RepasDTO(
                loadImg("C://resource Image/oeufs.gif"),"oeufs",20,
                LocalTime.of(6,0), TypeRepas.FOOD));
        repasService.addRepas(new RepasDTO(
                loadImg("C://resource Image/pain.gif"),"pain",12.5f,
                LocalTime.of(6,0), TypeRepas.FOOD));

        repasService.addRepas(new RepasDTO(
                loadImg("C://resource Image/petit_dejeuner.png"),"petit dejeuner",12.5f,
                LocalTime.of(6,0), TypeRepas.FOOD));
        repasService.addRepas(new RepasDTO(
                loadImg("C://resource Image/pizza.png"),"pizza",12.5f,
                LocalTime.of(6,0), TypeRepas.FOOD));
        repasService.addRepas(new RepasDTO(
                loadImg("C://resource Image/soupe.png"),"soupe",12.5f,
                LocalTime.of(6,0), TypeRepas.FOOD));
        repasService.addRepas(new RepasDTO(
                loadImg("C://resource Image/tacos.png"),"tacos",12.5f,
                LocalTime.of(6,0), TypeRepas.FOOD));
        repasService.addRepas(new RepasDTO(
                loadImg("C://resource Image/tarte1.png"),"tarte 1",19.5f,
                LocalTime.of(6,0), TypeRepas.PATISSERIE));
        repasService.addRepas(new RepasDTO(
                loadImg("C://resource Image/tarte2.png"),"tarte 2",16.5f,
                LocalTime.of(6,0), TypeRepas.PATISSERIE));
        repasService.addRepas(new RepasDTO(
                loadImg("C://resource Image/tarte3.png"),"tarte 3",17.5f,
                LocalTime.of(6,0), TypeRepas.PATISSERIE));
        repasService.addRepas(new RepasDTO(
                loadImg("C://resource Image/tarte4.png"),"tarte 4",22.5f,
                LocalTime.of(6,0), TypeRepas.PATISSERIE));
        repasService.addRepas(new RepasDTO(
                loadImg("C://resource Image/tarte5.png"),"tarte 5",12.5f,
                LocalTime.of(6,0), TypeRepas.PATISSERIE));
        repasService.addRepas(new RepasDTO(
                loadImg("C://resource Image/tarte6.png"),"tarte 6",22.5f,
                LocalTime.of(6,0), TypeRepas.PATISSERIE));
        repasService.addRepas(new RepasDTO(
                loadImg("C://resource Image/tarte7.png"),"tarte 7",14.5f,
                LocalTime.of(6,0), TypeRepas.PATISSERIE));
        repasService.addRepas(new RepasDTO(
                loadImg("C://resource Image/tarte8.png"),"tarte 8",12.5f,
                LocalTime.of(6,0), TypeRepas.PATISSERIE));
        repasService.addRepas(new RepasDTO(
                loadImg("C://resource Image/tarte9.png"),"tarte 9",12.5f,
                LocalTime.of(6,0), TypeRepas.PATISSERIE));
        repasService.addRepas(new RepasDTO(
                loadImg("C://resource Image/un_soda.png"),"un soda",16.5f,
                LocalTime.of(6,0), TypeRepas.POISSON));


    }

    public byte[] loadImg(String imagePath) throws IOException {
        return Files.readAllBytes(Paths.get(imagePath));
    }
}
