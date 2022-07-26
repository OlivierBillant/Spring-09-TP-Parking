package fr.eni.Spring09TPParking.bll;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParkingException extends Exception{
	private String message;

	
}
