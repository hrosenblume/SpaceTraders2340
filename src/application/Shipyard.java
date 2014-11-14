package application;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Creates a shipyard that determines which ships you can buy on the current
 * planet
<<<<<<< HEAD
=======
 * 
>>>>>>> a6dd8ed23bf473ebe66d10204bc2583aa9f18a79
 * @author Naman
 *
 */
public class Shipyard {
    Planet currentPlanet;
    ArrayList<Ship> availableShips = new ArrayList<>();

    /**
     * Constructor for a ShipYard
     * 
     * @param p
     *            current planet
     */
    public Shipyard(Planet p) {
        currentPlanet = p;
        availableShips = pickShips(p);
    }

    /**
     * Picks the ships to add to the current planet's shipyard
     * 
     * @param p
     *            current planet
     * @return picked ships
     */
    private ArrayList<Ship> pickShips(Planet p) {
        ArrayList<Ship> ships = new ArrayList<>();
        String[] names = { "flea", "gnat", "firefly", "mosquito", "bumblebee" };
        HashMap<String, Ship> allShips = Ship.generateAllShips();
        for (int i = 0; i < 5; i++) {
            Ship ship = allShips.get(names[i]);
            if (p.getTechLevel() >= ship.minTechLevel) {
                ships.add(ship);
            }
        }
        return ships;
    }
}
