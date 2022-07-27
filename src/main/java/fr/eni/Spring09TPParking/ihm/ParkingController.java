package fr.eni.Spring09TPParking.ihm;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.eni.Spring09TPParking.bll.ParkingManager;
import fr.eni.Spring09TPParking.bo.Parking;

@Controller
@RequestMapping("/ihm")
public class ParkingController {
@Autowired
private ParkingManager parkingManager;
	
	@GetMapping("/hello")
	public String display(Model model) {
		model.addAttribute("message", "Hello there!");
		return "hello";
	}
	
	@GetMapping("/parking")
	public String displayParking(Model model) {
		ArrayList<Parking> listeParking = parkingManager.afficherToutParking();
		model.addAttribute("listeParking", listeParking);
		return "parking";
	}
}
