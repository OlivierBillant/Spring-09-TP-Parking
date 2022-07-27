package fr.eni.Spring09TPParking;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.eni.Spring09TPParking.bll.ParkingManager;
import fr.eni.Spring09TPParking.bo.Moto;
import fr.eni.Spring09TPParking.bo.Parking;
import fr.eni.Spring09TPParking.bo.Velo;
import fr.eni.Spring09TPParking.bo.Voiture;

@SpringBootApplication
public class Spring09TpParkingApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Spring09TpParkingApplication.class, args);
	}

	@Autowired
	private ParkingManager parkingManager;

	@Transactional
	@Override
	public void run(String... args) throws Exception {

		// Creation Parking
		System.out.println("");
		System.out.println("Creation Parkings");
		Parking kerfautras = new Parking("Kerfautras", 2);
		Parking liberte = new Parking("Liberte", 150);
		Parking ikea = new Parking("Ikea", 1000);

		// Creation Voitures
		System.out.println("");
		System.out.println("Creation Voitures");
		Voiture Captur = new Voiture("AB-123-CD", "Renault", "Captur", kerfautras);
		Voiture Fiesta = new Voiture("EF-456-GH", "Ford", "Fiesta", kerfautras);
		Voiture Focus = new Voiture("IJ-789-KL", "Ford", "Focus", liberte);
		Voiture Zoe = new Voiture("MN-147-OP", "Renault", "Zoe", kerfautras);
		Moto Bandit = new Moto("XYZ-321-ABC", "Suzuki", "Bandi", liberte);
		Velo vog = new Velo("O2Feels", "Vog");
		vog.setParking(liberte);
		
		// Test crud db
		System.out.println("");
		System.out.println("Test CRUD");

//		// Ajout
//
//		System.out.println("");
//		System.out.println("Ajout");
//		parkingManager.ajouterParking(kerfautras);
//		parkingManager.ajouterParking(liberte);
//		parkingManager.ajouterParking(ikea);
//		parkingManager.ajouterVehicule(Captur);
//		parkingManager.ajouterVehicule(Fiesta);
//		parkingManager.ajouterVehicule(Focus);
//		parkingManager.ajouterVehicule(Zoe);
//		parkingManager.ajouterVehicule(Bandit);
//		parkingManager.ajouterVehicule(vog);
//		
//		
//
//		// Affichage all
//		System.out.println("");
//		System.out.println("Affichage all");
//		parkingManager.afficherToutParking().forEach(System.out::println);
//		parkingManager.afficherToutVehicule().forEach(System.out::println);
//
//		// Affichage byId
//		System.out.println("");
//		System.out.println("Affichage byId");
//		System.out.println(parkingManager.afficherUnParking(2));
//		System.out.println(parkingManager.afficherUnVoiture(1));
//		System.out.println(parkingManager.afficherUnVehicule(1));
	}

}
