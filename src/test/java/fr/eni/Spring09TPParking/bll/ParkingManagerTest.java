package fr.eni.Spring09TPParking.bll;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import fr.eni.Spring09TPParking.bll.ParkingException;
import fr.eni.Spring09TPParking.bll.ParkingManager;
import fr.eni.Spring09TPParking.bo.Parking;
import fr.eni.Spring09TPParking.bo.Voiture;

@SpringBootTest
class ParkingManagerTest {
	@Autowired
	ParkingManager parkingManager;

	@Test
	void ajouterVehiculeTest() throws ParkingException {
		Parking kerfautras = new Parking("Kerfautras", 2);
		Voiture Captur = new Voiture("AB-123-CD", "Renault", "Captur", kerfautras);
		parkingManager.ajouterParking(kerfautras);
		parkingManager.ajouterVehicule(Captur);
		Voiture voitureTest = parkingManager.afficherUnVoiture(1);
		assertNotNull(voitureTest);
	}

	@Test
	void ajouterVehiculeCTCapacite() {
		Parking kerfautras = new Parking("Kerfautras", 0);
		Voiture Captur = new Voiture("AB-123-CD", "Renault", "Captur", kerfautras);
		parkingManager.ajouterParking(kerfautras);
		assertThrows(ParkingException.class, () -> {
			parkingManager.ajouterVehicule(Captur);
		});
	}

}
