package fr.eni.Spring09TPParking.bo;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
//@DiscriminatorColumn(name = "ty_vehicule", length = 5)
//@DiscriminatorValue("VELO")
public class Velo extends Vehicule{
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Integer idMoto;

	public Velo(String marque, String modele) {
		super();
		this.marque = marque;
		this.modele = modele;
		this.moteur = false;
		this.ty_vehicule = "VELO";
	}

	
}
