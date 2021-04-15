package com.parkyer.admin2.parking;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ParkingController {

    private final ParkingService parkingService;

    @Autowired
    public ParkingController(ParkingService parkingService) {
        this.parkingService = parkingService;
    }

    @GetMapping( value = { "/parkings" } )
    public List<Parking> getParkings(){
        return parkingService.getParkings();
    }

    @GetMapping( value = { "/parkingsusedby/{id}" } )
    public List<Parking> getParkingsUsedBy(@PathVariable (value = "id") String id_client){
        return parkingService.getParkingsUsedBy(id_client);
    }

    @PutMapping( value = { "/newsuscription/{id}" } )
    public void newSuscription(@PathVariable (value = "id") int id, @RequestBody Parking parking){
        parkingService.createSuscription(id, parking.getId_client());
    }

    @PutMapping( value = { "/deletesuscription/{id}" } )
    public void deleteSuscription(@PathVariable (value = "id") int id){
        parkingService.deleteSuscription(id);
    }

    @GetMapping( value = { "/availableparkings" } )
    public List<Parking> getAvailableParkings(){
        return parkingService.getAvailableParkings();
    }
    
}

