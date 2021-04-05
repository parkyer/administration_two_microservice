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
                null, 
                "calle 141bis #16a - 39",
                "carro"
            );
            Parking p2 = new Parking(
                4,
                null, 
                "calle 141bis #15 - 45",
                "carro"
            );
            Parking p3 = new Parking(
                6,
                null, 
                "calle 141bis #15 - 45",
                "carro"
            );
            Parking p4 = new Parking(
                9,
                null, 
                "calle 50 #20 - 45",
                "moto"
            );

            repository.save(p1);
            repository.save(p2);
            repository.save(p3);
            repository.save(p4);
        };
    }
}


