package fr.eni.Spring09TPParking.bo;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
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
//@DiscriminatorColumn(name = "ty_vehicule", length = 5)
//@DiscriminatorValue("VOIT")
public class Voiture extends Vehicule{
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Integer idVoiture;
	private String immatriculation;

	public Voiture(String immatriculation, String marque, String modele, Parking parking) {
		super();
		this.immatriculation = immatriculation;
		this.marque = marque;
		this.modele = modele;
		this.moteur = true;
		this.parking = parking;
		this.ty_vehicule = "VOIT";
	}

	@Override
	public String toString() {
		return "Voiture [immatriculation=" + immatriculation + ", marque=" + marque + ", modele=" + modele + ", moteur="
				+ moteur + ", parking=" + parking + ", ty_vehicule=" + ty_vehicule + "]";
	}


}
