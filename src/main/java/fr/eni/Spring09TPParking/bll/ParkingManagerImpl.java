package fr.eni.Spring09TPParking.bll;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.Spring09TPParking.bo.Parking;
import fr.eni.Spring09TPParking.bo.Vehicule;
import fr.eni.Spring09TPParking.bo.Velo;
import fr.eni.Spring09TPParking.bo.Voiture;
import fr.eni.Spring09TPParking.dal.ParkingDao;
import fr.eni.Spring09TPParking.dal.VehiculeDao;
import fr.eni.Spring09TPParking.dal.VoitureDao;

@Service
public class ParkingManagerImpl implements ParkingManager {
	@Autowired
	private ParkingDao parkingDao;

	@Autowired
	private VoitureDao voitureDao;

	@Autowired
	private VehiculeDao vehiculeDao;

	@Override
	public ArrayList<Parking> afficherToutParking() {
		return (ArrayList<Parking>) parkingDao.findAll();
	}

	@Override
	public Parking afficherUnParking(Integer id) {
		return parkingDao.findById(id).orElse(null);
	}

	@Override
	public void ajouterParking(Parking parking) {
		parkingDao.save(parking);
	}

	@Override
	public void modifierParking(Parking parking) {
		parkingDao.save(parking);

	}

	@Override
	public void supprimerUnParking(Integer id) {
		parkingDao.deleteById(id);
	}

	@Override
	public ArrayList<Vehicule> afficherToutVehicule() {
		return (ArrayList<Vehicule>) vehiculeDao.findAll();
	}

	@Override
	public Vehicule afficherUnVehicule(Integer id) {
		return vehiculeDao.findById(id).orElse(null);
	}

	@Override
	public void ajouterVehicule(Vehicule vehicule) throws ParkingException{
		try {
			if (placeDisponible(vehicule.getParking())) {
				if (vehiculeAutorise(vehicule)) {
					vehicule.getParking().garerVehicule(vehicule);
					vehiculeDao.save(vehicule);
				} else {
					throw new ParkingException("Véhicule non-autorisé");
				}
			} else {
				throw new ParkingException("Aucune place disponible dans ce parking");
			}
		} catch (ParkingException pe) {
			System.out.println("ERREUR : " + pe.getMessage());
		}
	}

	@Override
	public void modifierVoiture(Voiture voiture) {
		voitureDao.save(voiture);

	}

	@Override
	public void supprimerUnVoiture(Integer id) {
		voitureDao.deleteById(id);
	}

	@Override
	public Boolean placeDisponible(Parking parking) {
		Boolean placeDisponible = true;
//		System.out.println("Nombre de voitures dans le parking : " + parking.getListeVehicules().size());
		if (parking.getListeVehicules().size() < parking.getCapacite()) {
			return placeDisponible;
		} else {
			return !placeDisponible;
		}
	}

	public Boolean vehiculeAutorise(Vehicule vehicule) {
		Boolean vehiculeAutorise = true;
		if (vehicule instanceof Velo) {
			return !vehiculeAutorise;
		} else {
			return vehiculeAutorise;
		}
	}

}
