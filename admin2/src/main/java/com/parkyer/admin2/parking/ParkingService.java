package com.parkyer.admin2.parking;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkingService {

    private final ParkingRepository parkingRepository;

    @Autowired
    public ParkingService(ParkingRepository parkingRepository) {
        this.parkingRepository = parkingRepository;
    }

    public List<Parking> getParkings(){
        return parkingRepository.findAll();
    }

    public List<Parking> getParkingsUsedBy(String id_client){
        List<Parking> parkingsused = new ArrayList<>();
        for(Parking parking : parkingRepository.findAll()){
            if(parking.getId_client().equals(id_client)){
                parkingsused.add(parking);
            }
        }
        return parkingsused;
    }

    public Optional<Parking> createSuscription(int id, String id_client) {
        Optional<Parking> OptionalParking = parkingRepository.findById(id);   
        Parking parking = OptionalParking.get();

        parking.setId_client(id_client); 
        parkingRepository.save(parking); 

        return parkingRepository.findById(id);
    }

    public Optional<Parking> deleteSuscription(int id) {
        Optional<Parking> OptionalParking = parkingRepository.findById(id);   
        Parking parking = OptionalParking.get();

        parking.setId_client("null"); 
        parkingRepository.save(parking);
        
        return parkingRepository.findById(id);
    }

    public List<Parking> getAvailableParkings(){
        List<Parking> availables = new ArrayList<>();
        for(Parking parking : parkingRepository.findAll()){
            if(parking.getId_client().equals("null")){
                availables.add(parking);
            }
        }
        return availables;
    }

    
}
