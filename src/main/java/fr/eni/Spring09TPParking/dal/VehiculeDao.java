package fr.eni.Spring09TPParking.dal;

import org.springframework.data.repository.CrudRepository;

import fr.eni.Spring09TPParking.bo.Vehicule;

public interface VehiculeDao extends CrudRepository<Vehicule, Integer>{

}
