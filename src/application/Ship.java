package application;

import java.util.HashMap;

public class Ship {
	String name;
	int cargoBay, weaponSlots, shieldSlots, gadgetSlots, crew, fuel, minTechLevel, fuelCost, price, hullStrength, repairCost;
	static HashMap<String, Ship> ships = generateAllShips();

	public Ship(String name, int cargoBay, int weaponSlots, int shieldSlots, int gadgetSlots, int crew, int fuel, int minTechLevel, int fuelCost, int price, int hullStrength, int repairCost) {
		this.name = name;
		this.cargoBay = cargoBay;
        this.weaponSlots = weaponSlots;
        this.shieldSlots = shieldSlots;
        this.gadgetSlots = gadgetSlots;
        this.crew = crew;
        this.fuel = fuel;
        this.minTechLevel = minTechLevel;
        this.fuelCost = fuelCost;
        this.price = price;
        this.hullStrength = hullStrength;
        this.repairCost = repairCost;
	}
	
	
	static HashMap<String, Ship> generateAllShips() {
		HashMap<String, Ship> ships = new HashMap<>();
		ships.put("flea", new Ship("flea", 10, 0, 0, 0, 1, 9999, 4, 1, 2000, 25, 1));
		ships.put("gnat", new Ship("gnat", 15, 1, 0, 1, 1, 14, 5, 2, 10000, 100, 1));
		ships.put("firefly", new Ship("firefly", 20, 1, 1, 1, 1, 17, 6, 3, 25000, 100, 1));
		ships.put("mosquito", new Ship("mosquito", 15, 2, 1, 1, 1, 13, 6, 5, 30000, 100, 1));
		ships.put("bumblebee", new Ship("bumblebee", 25, 1, 2, 2, 2, 15, 7, 7, 60000, 100, 1));
		return ships;
	}
}
