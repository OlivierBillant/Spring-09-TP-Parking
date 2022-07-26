package fr.eni.Spring09TPParking.dal;

import org.springframework.data.repository.CrudRepository;

import fr.eni.Spring09TPParking.bo.Voiture;

public interface VoitureDao extends CrudRepository<Voiture, Integer>{

}
