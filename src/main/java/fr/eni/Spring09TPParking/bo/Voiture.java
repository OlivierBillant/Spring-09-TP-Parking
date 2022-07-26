package fr.eni.Spring09TPParking.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Voiture {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idVoiture;
	private String immatriculation;
	private String marque;
	private String modele;
	
	@ManyToOne
	private Parking parking;

	public Voiture(String immatriculation, String marque, String modele, Parking parking) {
		super();
		this.immatriculation = immatriculation;
		this.marque = marque;
		this.modele = modele;
		this.parking = parking;
	}
	
	
}
