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
        cargo.put("water", 0);
        cargo.put("furs", 0);
        cargo.put("food", 0);
        cargo.put("ore", 0);
        cargo.put("games", 0);
        cargo.put("firearms", 0);
        cargo.put("medicine", 0);
        cargo.put("machines", 0);
        cargo.put("narcotics", 0);
        cargo.put("robots", 0);
    }
    
    public void setMoney(int money) {
    	this.money= money;
    }
    
    public int getMoney() {
    	return money;
    }
}
