package application;

import java.util.HashMap;

/**
 * Represents the in-game character.
 * 
 * @author Hunter Rosenblume, Naman Shah, Stephen Song, Bhavesh Suhagia, Pranil
 *         Vora
 */
public class Player {
    private int pilotSkillLevel, fighterSkillLevel, traderSkillLevel,
            engineerSkillLevel, investorSkillLevel, money, fuel;
    Ship ship;
    private String name;
    private HashMap<String, Integer> cargo = new HashMap<String, Integer>();

    /**
     * Constructs a new player.
     * 
     * @param name
     *            the player's name
     * @param pilot
     *            the number of pilot points the player has.
     * @param fighter
     *            the number of fighter points the player has.
     * @param trader
     *            the number of trader points the player has.
     * @param engineer
     *            the number of engineer points the player has.
     * @param investor
     *            the number of investor points the player has.
     */
    public Player(String name, int pilot, int fighter, int trader,
            int engineer, int investor) {
        this.name = name;
        this.pilotSkillLevel = pilot;
        this.fighterSkillLevel = fighter;
        this.traderSkillLevel = trader;
        this.engineerSkillLevel = engineer;
        this.investorSkillLevel = investor;

        ship = Ship.ships.get("flea");
        fuel = ship.fuel;
        money = 10000;
        cargo = new HashMap<String, Integer>();
        cargo.put("Water", 0);
        cargo.put("Fur", 0);
        cargo.put("Food", 0);
        cargo.put("Ore", 0);
        cargo.put("Games", 0);
        cargo.put("Firearms", 0);
        cargo.put("Medicine", 0);
        cargo.put("Machines", 0);
        cargo.put("Narcotics", 0);
        cargo.put("Robots", 0);
    }
<<<<<<< HEAD
    
    /**
     * Constructs a new player
     * @param name the player's name
     * @param pilot the player's pilot points
     * @param fighter the player's fighter points
     * @param trader the player's trader points
     * @param engineer the player's engineer points
     * @param investor the player's investor points
     * @param fuel the player's fuel initialized with a full tank
     * @param money the player's money
     * @param cargo the player's cargo initialized with an empty cargo bay 
     */
    public Player(String name, int pilot, int fighter, int trader, int engineer, int investor, int fuel, int money, HashMap<String,Integer> cargo) {
    	this.name = name;
=======

    /**
     * Constructs a new player
     * 
     * @param name
     *            the player's name
     * @param pilot
     *            the player's pilot points
     * @param fighter
     *            the player's fighter points
     * @param trader
     *            the player's trader points
     * @param engineer
     *            the player's engineer points
     * @param investor
     *            the player's investor points
     * @param fuel
     *            the player's fuel initialized with a full tank
     * @param money
     *            the player's money
     * @param cargo
     *            the player's cargo initialized with an empty cargo bay
     */
    public Player(String name, int pilot, int fighter, int trader,
            int engineer, int investor, int fuel, int money,
            HashMap<String, Integer> cargo) {
        this.name = name;
>>>>>>> a6dd8ed23bf473ebe66d10204bc2583aa9f18a79
        this.pilotSkillLevel = pilot;
        this.fighterSkillLevel = fighter;
        this.traderSkillLevel = trader;
        this.engineerSkillLevel = engineer;
        this.investorSkillLevel = investor;
        ship = Ship.ships.get("flea");
        this.fuel = fuel;
        this.money = money;
        this.cargo = cargo;

    }
<<<<<<< HEAD
    
    /**
     * Sets the player's money
=======

    /**
     * Sets the player's money
     * 
>>>>>>> a6dd8ed23bf473ebe66d10204bc2583aa9f18a79
     * @param money
     */
    public void setMoney(int money) {
        this.money = money;
    }
<<<<<<< HEAD
     /**
      * Sets the player's fuel
      * @param fuel
      */
=======

    /**
     * Sets the player's fuel
     * 
     * @param fuel
     */
>>>>>>> a6dd8ed23bf473ebe66d10204bc2583aa9f18a79
    public void setFuel(int fuel) {
        this.fuel = fuel;
    }
<<<<<<< HEAD
    
    /**
     * Removes fuel from the player's tank
     * @param fuel amount to remove
=======

    /**
     * Removes fuel from the player's tank
     * 
     * @param fuel
     *            amount to remove
>>>>>>> a6dd8ed23bf473ebe66d10204bc2583aa9f18a79
     */
    public void removeFuel(int fuel) {
        this.fuel -= fuel;
    }
<<<<<<< HEAD
    
    /**
     * Adds fuel to the player's tank
     * @param fuel amount to add
=======

    /**
     * Adds fuel to the player's tank
     * 
     * @param fuel
     *            amount to add
>>>>>>> a6dd8ed23bf473ebe66d10204bc2583aa9f18a79
     */
    public void addFuel(int fuel) {
        this.fuel += fuel;
    }
<<<<<<< HEAD
    
    /**
     * Gets the player's name
=======

    /**
     * Gets the player's name
     * 
>>>>>>> a6dd8ed23bf473ebe66d10204bc2583aa9f18a79
     * @return name
     */
    public String getName() {
        return name;
    }
<<<<<<< HEAD
    
    /**
     * Gets the player's pilot level
=======

    /**
     * Gets the player's pilot level
     * 
>>>>>>> a6dd8ed23bf473ebe66d10204bc2583aa9f18a79
     * @return pilot points
     */
    public int getPilot() {
        return pilotSkillLevel;
    }
<<<<<<< HEAD
    
    /**
     * Gets the player's fighter level
=======

    /**
     * Gets the player's fighter level
     * 
>>>>>>> a6dd8ed23bf473ebe66d10204bc2583aa9f18a79
     * @return fighter level
     */
    public int getFighter() {
        return fighterSkillLevel;
    }
<<<<<<< HEAD
    
    /**
     * Gets the player's trader level
=======

    /**
     * Gets the player's trader level
     * 
>>>>>>> a6dd8ed23bf473ebe66d10204bc2583aa9f18a79
     * @return trader level
     */
    public int getTrader() {
        return traderSkillLevel;
    }
<<<<<<< HEAD
    
    /**
     * Gets the player's engineer level
=======

    /**
     * Gets the player's engineer level
     * 
>>>>>>> a6dd8ed23bf473ebe66d10204bc2583aa9f18a79
     * @return engineer level
     */
    public int getEngineer() {
        return engineerSkillLevel;
    }
<<<<<<< HEAD
    
    /**
     * Gets the player's investor level
=======

    /**
     * Gets the player's investor level
     * 
>>>>>>> a6dd8ed23bf473ebe66d10204bc2583aa9f18a79
     * @return investor level
     */
    public int getInvestor() {
        return investorSkillLevel;
    }
<<<<<<< HEAD
    
    /**
     * Gets the player's fuel in the fuel tank
=======

    /**
     * Gets the player's fuel in the fuel tank
     * 
>>>>>>> a6dd8ed23bf473ebe66d10204bc2583aa9f18a79
     * @return fuel
     */
    public int getFuel() {
        return fuel;
    }
<<<<<<< HEAD
    
    /**
     * Gets the player's money
=======

    /**
     * Gets the player's money
     * 
>>>>>>> a6dd8ed23bf473ebe66d10204bc2583aa9f18a79
     * @return amount of money the player has
     */
    public int getMoney() {
        return money;
    }
<<<<<<< HEAD
    
    /**
     * Gets the player's current cargo bay
=======

    /**
     * Gets the player's current cargo bay
     * 
>>>>>>> a6dd8ed23bf473ebe66d10204bc2583aa9f18a79
     * @return HashMap of cargo
     */
    public HashMap<String, Integer> getCargo() {
        return cargo;
    }

    /**
     * Gets the ship
     * 
     * @return ship
     */
    public Ship getShip() {
        return ship;
    }

    /**
     * Sets the player ship
     * 
     * @param ship
     *            is the ship to set the player's ship to
     */
    public void setShip(Ship ship) {
        this.ship = ship;
    }
}
