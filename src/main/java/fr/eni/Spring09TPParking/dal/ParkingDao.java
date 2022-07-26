package fr.eni.Spring09TPParking.dal;

import org.springframework.data.repository.CrudRepository;

import fr.eni.Spring09TPParking.bo.Parking;

public interface ParkingDao extends CrudRepository<Parking, Integer>{

}
