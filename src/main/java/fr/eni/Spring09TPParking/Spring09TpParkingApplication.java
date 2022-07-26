package fr.eni.Spring09TPParking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.eni.Spring09TPParking.bll.ParkingManager;
import fr.eni.Spring09TPParking.bo.Parking;
import fr.eni.Spring09TPParking.bo.Voiture;

@SpringBootApplication
public class Spring09TpParkingApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Spring09TpParkingApplication.class, args);
	}

	@Autowired
	private ParkingManager parkingManager;

	@Override
	public void run(String... args) throws Exception {

		// Creation Parking
		System.out.println("");
		System.out.println("Creation Parkings");
		Parking kerfautras = new Parking("Kerfautras", 200);
		Parking liberte = new Parking("Liberte", 150);
		Parking ikea = new Parking("Ikea", 1000);

		// Creation Voitures
		System.out.println("");
		System.out.println("Creation Voitures");
		Voiture Captur = new Voiture("AB-123-CD", "Renault", "Captur", kerfautras);
		Voiture Fiesta = new Voiture("EF-456-GH", "Ford", "Fiesta", kerfautras);
		Voiture Focus = new Voiture("IJ-789-KL", "Ford", "Focus", liberte);
		Voiture Zoe = new Voiture("MN-147-OP", "Renault", "Zoe", ikea);

		// Test crud db
		System.out.println("");
		System.out.println("Test CRUD");

		// Ajout
		System.out.println("");
		System.out.println("Ajout");
		parkingManager.ajouterParking(kerfautras);
		parkingManager.ajouterParking(liberte);
		parkingManager.ajouterParking(ikea);
		parkingManager.ajouterVoiture(Captur);
		parkingManager.ajouterVoiture(Fiesta);
		parkingManager.ajouterVoiture(Focus);
		parkingManager.ajouterVoiture(Zoe);

		// Affichage all
		System.out.println("");
		System.out.println("Affichage all");
		parkingManager.afficherToutParking().forEach(System.out::println);
		parkingManager.afficherToutVoiture().forEach(System.out::println);
		
		// Affichage byId
		System.out.println("");
		System.out.println("Affichage byId");
		System.out.println(parkingManager.afficherUnParking(2));
		System.out.println(parkingManager.afficherUnVoiture(1));
	}

}
