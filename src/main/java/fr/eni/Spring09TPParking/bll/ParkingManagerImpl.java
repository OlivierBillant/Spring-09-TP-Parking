package fr.eni.Spring09TPParking.bll;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.Spring09TPParking.bo.Parking;
import fr.eni.Spring09TPParking.bo.Voiture;
import fr.eni.Spring09TPParking.dal.ParkingDao;
import fr.eni.Spring09TPParking.dal.VoitureDao;

@Service
public class ParkingManagerImpl implements ParkingManager {
	@Autowired
	private ParkingDao parkingDao;

	@Autowired
	private VoitureDao voitureDao;

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
	public ArrayList<Voiture> afficherToutVoiture() {
		return (ArrayList<Voiture>) voitureDao.findAll();
	}

	@Override
	public Voiture afficherUnVoiture(Integer id) {
		return voitureDao.findById(id).orElse(null);
	}

	@Override
	public void ajouterVoiture(Voiture voiture) {
		try {
			if (placeDisponible(voiture.getParking())) {
				voiture.getParking().garerVoiture(voiture);
				voitureDao.save(voiture);
			} else {
				throw new ParkingException("Aucune place disponible dans ce parking");
			}
		} catch (ParkingException pe) {
			System.out.println("ERREUR : "+pe.getMessage());
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
		System.out.println("Nombre de voitures dans le parking : "+parking.getListeVoitures().size());
		if (parking.getListeVoitures().size() < parking.getCapacite()) {
			return placeDisponible;
		} else {
			return !placeDisponible;
		}
	}

}
