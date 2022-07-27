package fr.eni.Spring09TPParking.bll;

import java.util.ArrayList;

import fr.eni.Spring09TPParking.bo.Parking;
import fr.eni.Spring09TPParking.bo.Vehicule;
import fr.eni.Spring09TPParking.bo.Voiture;

public interface ParkingManager {
	public ArrayList<Parking> afficherToutParking();
	public Parking afficherUnParking(Integer id);
	public void ajouterParking(Parking parking);
	public void modifierParking(Parking parking);
	public void supprimerUnParking(Integer id);
	
	public ArrayList<Vehicule> afficherToutVehicule();
	public Voiture afficherUnVoiture(Integer id);
	
	/**
	 * Ajoute un véhicule générique à un parking.
	 * @param vehicule contrainte sur capacité et type véhicule
	 * @throws ParkingException
	 */
	public void ajouterVehicule(Vehicule vehicule) throws ParkingException;
	public void modifierVoiture(Voiture voiture);
	public void supprimerUnVoiture(Integer id);
	
	public Boolean placeDisponible(Parking parking);
}
