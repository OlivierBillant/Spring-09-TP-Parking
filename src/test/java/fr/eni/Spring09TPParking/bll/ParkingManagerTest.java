package fr.eni.Spring09TPParking.bll;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.eni.Spring09TPParking.bo.Moto;
import fr.eni.Spring09TPParking.bo.Parking;
import fr.eni.Spring09TPParking.bo.Vehicule;
import fr.eni.Spring09TPParking.bo.Velo;
import fr.eni.Spring09TPParking.bo.Voiture;

@SpringBootTest
class ParkingManagerTest {
	@Autowired
	ParkingManager parkingManager;

	@Transactional
	@Test
	void ajouterVehiculeTestVoiture() throws ParkingException {
		Parking kerfautras = new Parking("Kerfautras", 2);
		Voiture Captur = new Voiture("AB-123-CD", "Renault", "Captur", kerfautras);
		parkingManager.ajouterParking(kerfautras);
		parkingManager.ajouterVehicule(Captur);
		Voiture voitureTest = (Voiture) parkingManager.afficherToutVehicule().get(0);
		assertNotNull(voitureTest);
	}

	@Transactional
	@Test
	void ajouterVehiculeTestMoto() throws ParkingException {
		Parking kerfautras = new Parking("Kerfautras", 2);
		Moto Bandit = new Moto("XYZ-321-ABC", "Suzuki", "Bandi", kerfautras);
		parkingManager.ajouterParking(kerfautras);
		parkingManager.ajouterVehicule(Bandit);
		Vehicule vehiculeTest = parkingManager.afficherToutVehicule().get(0);
		assertNotNull(vehiculeTest);
	}

	@Transactional
	@Test
	void ajouterVehiculeCtCapacite() {
		Parking kerfautras = new Parking("Kerfautras", 0);
		Voiture Captur = new Voiture("AB-123-CD", "Renault", "Captur", kerfautras);
		parkingManager.ajouterParking(kerfautras);
		assertThrows(ParkingException.class, () -> {
			parkingManager.ajouterVehicule(Captur);
		});
	}

	@Transactional
	@Test
	void ajouterVehiculeCtType() {
		Parking kerfautras = new Parking("Kerfautras", 2);
		Velo vog = new Velo("O2Feels", "Vog");
		vog.setParking(kerfautras);
		parkingManager.ajouterParking(kerfautras);
		assertThrows(ParkingException.class, () -> {
			parkingManager.ajouterVehicule(vog);
		});
	}
	
	@Transactional
	@Test
	void afficherToutVehiculeTest() throws ParkingException {
		Parking kerfautras = new Parking("Kerfautras", 2);
		Moto Bandit = new Moto("XYZ-321-ABC", "Suzuki", "Bandi", kerfautras);
		Voiture Captur = new Voiture("AB-123-CD", "Renault", "Captur", kerfautras);
		parkingManager.ajouterParking(kerfautras);
		parkingManager.ajouterVehicule(Bandit);
		parkingManager.ajouterVehicule(Captur);
		assertEquals(2, parkingManager.afficherToutVehicule().size());
	}

}
