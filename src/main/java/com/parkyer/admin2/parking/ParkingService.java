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

    public List<Parking> getParkingsUsedBy(Integer id_client){
        List<Parking> parkingsused = new ArrayList<>();
        for(Parking parking : parkingRepository.findAll()){
            if(parking.getId_client() == id_client){
                parkingsused.add(parking);
            }
        }
        return parkingsused;
    }

    public void createSuscription(int id, Integer id_client) {
        Optional<Parking> OptionalParking = parkingRepository.findById(id);   
        Parking parking = OptionalParking.get();

        parking.setId_client(id_client); 
        parkingRepository.save(parking);     
    }

    public void deleteSuscription(int id) {
        Optional<Parking> OptionalParking = parkingRepository.findById(id);   
        Parking parking = OptionalParking.get();

        parking.setId_client(null); 
        parkingRepository.save(parking);     
    }

    public List<Parking> getAvailableParkings(){
        List<Parking> availables = new ArrayList<>();
        for(Parking parking : parkingRepository.findAll()){
            if(parking.getId_client() == null){
                availables.add(parking);
            }
        }
        return availables;
    }

    
}
