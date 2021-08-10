package com.parkyer.admin2.parking;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ParkingConfig {
    
    @Bean
    CommandLineRunner commandLineRunner(
        ParkingRepository repository){
        return args -> {
            Parking p1 = new Parking(
                1,
                "null",
                "4.740596106774402",
                "-74.03132287148797", 
                "calle 141bis #16a - 39",
                "carro"
            );
            Parking p2 = new Parking(
                4,
                "null", 
                "4.6458605",
                "-74.0795711", 
                "el campin",
                "carro"
            );
            Parking p3 = new Parking(
                6,
                "null", 
                "4.6381991",
                "-74.0862404", 
                "nacho",
                "carro"
            );
            Parking p4 = new Parking(
                9,
                "null", 
                "4.61213",
                "-74.0769421", 
                "la piscina 😏",
                "moto"
            );

            repository.save(p1);
            repository.save(p2);
            repository.save(p3);
            repository.save(p4);
        };
    }
}


