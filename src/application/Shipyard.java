package application;

import java.util.ArrayList;
import java.util.HashMap;

public class Shipyard {
	Planet currentPlanet;
	ArrayList<Ship> availableShips = new ArrayList<>();
	
	public Shipyard(Planet p) {
		currentPlanet = p;
		availableShips = pickShips(p);
	}
	
	private ArrayList<Ship> pickShips(Planet p) {
		ArrayList<Ship> ships = new ArrayList<>();
		String[] names = {"flea", "gnat", "firefly", "mosquito", "bumblebee"};
		HashMap<String, Ship> allShips = Ship.generateAllShips();
		for (int i=0; i < 5; i++) {
			Ship ship = allShips.get(names[i]);
			if (p.getTechLevel() >= ship.minTechLevel) {
				ships.add(ship);
			}
		}
		return ships;
	}
}
