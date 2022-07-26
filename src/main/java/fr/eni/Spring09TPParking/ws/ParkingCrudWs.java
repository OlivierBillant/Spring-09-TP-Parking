package fr.eni.Spring09TPParking.ws;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.eni.Spring09TPParking.bll.ParkingManager;
import fr.eni.Spring09TPParking.bo.Parking;
import fr.eni.Spring09TPParking.bo.Vehicule;
import fr.eni.Spring09TPParking.bo.Voiture;

@RestController
//@RequestMapping("/parking")
public class ParkingCrudWs {

	@Autowired
	private ParkingManager parkingManager;

	@GetMapping("/voiture")
	public ArrayList<Vehicule> afficherToutVoiture() {
		return parkingManager.afficherToutVehicule();
	}

	@GetMapping("/voiture/{id}")
	public Voiture afficherUnVoiture(@PathVariable("id") Integer id) {
		return parkingManager.afficherUnVoiture(id);
	}

	@DeleteMapping("/voiture/{id}")
	public void effacerVoiture(@PathVariable("id") Integer id) {
		parkingManager.supprimerUnVoiture(id);
	}

	@PostMapping("/voiture")
	public void ajouterVehicule(@RequestBody Vehicule vehicule) {
		parkingManager.ajouterVehicule(vehicule);
	}

	/*
	 * { 
	 * "immatriculation": "QR-369-ST", 
	 * "marque": "Tesla", 
	 * "modele": "Model3",
	 * "parking": { 
	 * 	"idParking": 2, 
	 * 	"adresse": "Liberte", 
	 * 	"capacite": 150 
	 * } 
	 * }
	 */

	@PutMapping("/voiture")
	public void editVoiture(@RequestBody Voiture voiture) {
		parkingManager.modifierVoiture(voiture);
	}

	@GetMapping("/parking")
	public ArrayList<Parking> afficherToutParking() {
		return parkingManager.afficherToutParking();
	}

	@GetMapping("/parking/{id}")
	public Parking afficherUnParking(@PathVariable("id") Integer id) {
		return parkingManager.afficherUnParking(id);
	}

	@DeleteMapping("/parking/{id}")
	public void effacerParking(@PathVariable("id") Integer id) {
		parkingManager.supprimerUnParking(id);
	}

	@PostMapping("/parking")
	public void ajouterParking(@RequestBody Parking parking) {
		parkingManager.ajouterParking(parking);
	}

	@PutMapping("/parking")
	public void editParking(@RequestBody Parking parking) {
		parkingManager.modifierParking(parking);
	}
}
