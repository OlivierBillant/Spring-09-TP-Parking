package fr.eni.Spring09TPParking.bo;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
//@DiscriminatorColumn(name = "ty_vehicule", length = 5)
//@DiscriminatorValue("MOTO")
public class Moto extends Vehicule{
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Integer idMoto;
	private String immatriculation;
	
	public Moto(String immatriculation, String marque, String modele, Parking parking) {
		super();
		this.immatriculation = immatriculation;
		this.marque = marque;
		this.modele = modele;
		this.moteur = true;
		this.parking = parking;
		this.ty_vehicule = "MOTO";
	}
	
	
}
