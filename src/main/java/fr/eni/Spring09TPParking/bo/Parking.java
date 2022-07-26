package fr.eni.Spring09TPParking.bo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
public class Parking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idParking;
	private String adresse;
	private Integer capacite;
	@OneToMany(mappedBy = "parking")
	@ToString.Exclude
	@JsonIgnore
	private Set<Voiture> listeVoitures = new HashSet<>();
	
	public Parking(String adresse, Integer capacite) {
		super();
		this.adresse = adresse;
		this.capacite = capacite;
	}

	@Override
	public String toString() {
		return "ParkingDao [adresse=" + adresse + ", capacite=" + capacite + "]";
	}
	
	public void garerVoiture(Voiture voiture) {
		listeVoitures.add(voiture);
	}
	
}
