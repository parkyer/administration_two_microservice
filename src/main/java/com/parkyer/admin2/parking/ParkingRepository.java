package com.parkyer.admin2.parking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingRepository 
    extends JpaRepository<Parking, Integer>{

}
