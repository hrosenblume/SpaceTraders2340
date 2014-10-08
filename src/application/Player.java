package application;

import java.util.HashMap;

/**
 * Represents the in-game character.
 * @author Hunter Rosenblume, Naman Shah, Stephen Song, Bhavesh Suhagia, Pranil Vora
 */
public class Player {
    private int pilotSkillLevel, fighterSkillLevel, traderSkillLevel,
        engineerSkillLevel, investorSkillLevel, money;
    private String name;
    private HashMap<String, Integer> cargo = new HashMap<String, Integer>();

    /**
     * Constructs a new player.
     * 
     * @param name the player's name
     * @param pilot the number of pilot points the player has.
     * @param fighter the number of fighter points the player has.
     * @param trader the number of trader points the player has.
     * @param engineer the number of engineer points the player has.
     * @param investor the number of investor points the player has.
     */
    public Player(String name, int pilot, int fighter, int trader, int engineer, int investor) {
        this.name = name;
        this.pilotSkillLevel = pilot;
        this.fighterSkillLevel = fighter;
        this.traderSkillLevel = trader;
        this.engineerSkillLevel = engineer;
        this.investorSkillLevel = investor;

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
    
    public void setMoney(int money) {
    	this.money= money;
    }
    
    public int getMoney() {
    	return money;
    }
    
    public HashMap<String, Integer> getCargo() {
    	return cargo;
    }
}
