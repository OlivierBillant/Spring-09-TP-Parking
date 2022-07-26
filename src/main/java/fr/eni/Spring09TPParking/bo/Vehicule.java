package fr.eni.Spring09TPParking.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Vehicule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idVehicule;
	protected String marque;
	protected String modele;
	protected Boolean moteur;
	@ManyToOne
	protected Parking parking;
	protected String ty_vehicule;
}
