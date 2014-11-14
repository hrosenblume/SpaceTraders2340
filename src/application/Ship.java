package application;

import java.util.HashMap;

/**
 * Represents all purchasable ships and their appropriate items
<<<<<<< HEAD
=======
 * 
>>>>>>> a6dd8ed23bf473ebe66d10204bc2583aa9f18a79
 * @author Naman
 *
 */
public class Ship {
    String name;
    int cargoBay, weaponSlots, shieldSlots, gadgetSlots, crew, fuel,
            minTechLevel, fuelCost, price, hullStrength, repairCost;
    static HashMap<String, Ship> ships = generateAllShips();
    private HashMap<String, Integer> weapons = new HashMap<>();
    private HashMap<String, Integer> shields = new HashMap<>();
    private HashMap<String, Integer> gadgets = new HashMap<>();
    Player player = Universe.player;

    /**
     * Constructor for a ship
     * 
     * @param name
     *            name of ship
     * @param cargoBay
     *            how much cargo it can hold
     * @param weaponSlots
     *            how many weapon slots
     * @param shieldSlots
     *            how many shield slots
     * @param gadgetSlots
     *            how many gadget slots
     * @param crew
     *            size of crew
     * @param fuel
     *            how much fuel it can hold
     * @param minTechLevel
     *            minimum tech level required to buy
     * @param fuelCost
     *            cost of fuel with this
     * @param price
     *            full price
     * @param hullStrength
     *            strength of hull
     * @param repairCost
     *            cost to repair
     */
    public Ship(String name, int cargoBay, int weaponSlots, int shieldSlots,
            int gadgetSlots, int crew, int fuel, int minTechLevel,
            int fuelCost, int price, int hullStrength, int repairCost) {
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

    /**
     * Method to generate all ships possible to buy
     */
    static HashMap<String, Ship> generateAllShips() {
        HashMap<String, Ship> ships = new HashMap<>();
        ships.put("flea", new Ship("flea", 10, 0, 0, 0, 1, 9999, 4, 1, 2000,
                25, 1));
        ships.put("gnat", new Ship("gnat", 15, 1, 0, 1, 1, 14, 5, 2, 8000, 100,
                1));
        ships.put("firefly", new Ship("firefly", 20, 1, 1, 1, 1, 17, 6, 3,
                25000, 100, 1));
        ships.put("mosquito", new Ship("mosquito", 15, 2, 1, 1, 1, 13, 6, 5,
                30000, 100, 1));
        ships.put("bumblebee", new Ship("bumblebee", 25, 1, 2, 2, 2, 15, 7, 7,
                60000, 100, 1));
        return ships;
    }

    /**
     * Adds a weapon to the ship.
     * 
     * @param weapon
     *            the weapon to add.
     */
    public void addWeapon(String weapon) {
        Integer count = weapons.get(weapon);
        if (count == null) {
            weapons.put(weapon, 1);
        } else {
            weapons.put(weapon, count + 1);
        }
    }

    /**
     * Adds a shield to the ship.
     * 
     * @param shield
     *            the shield to add.
     */
    public void addShield(String shield) {
        Integer count = shields.get(shield);
        if (count == null) {
            shields.put(shield, 1);
        } else {
            shields.put(shield, count + 1);
        }
    }

    /**
     * Adds a gadget to the ship.
     * 
     * @param gadget
     *            the gadget to add.
     */
    public void addGadget(String gadget) {
        if (gadget.equals("cargo")) {
            cargoBay += 5;
        } else {
            Integer count = gadgets.get(gadget);
            if (count == null) {
                gadgets.put(gadget, 1);
            } else {
                gadgets.put(gadget, count + 1);
            }
        }
    }

    /**
     * Gets the mappings of weapons and amounts.
     * 
     * @return the mappings of weapons and amounts.
     */
    public HashMap<String, Integer> getWeapons() {
        return weapons;
    }

    /**
     * Gets the mappings of shields and amounts.
     * 
     * @return the mappings of shields and amounts.
     */
    public HashMap<String, Integer> getShields() {
        return shields;
    }

    /**
     * Gets the mappings of gadgets and amounts.
     * 
     * @return the mappings of gadgets and amounts.
     */
    public HashMap<String, Integer> getGadgets() {
        return gadgets;
    }
}
