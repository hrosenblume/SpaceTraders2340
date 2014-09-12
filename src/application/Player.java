package application;

/**
 * Represents the in-game character.
 * @author Hunter Rosenblume, Naman Shah, Stephen Song, Bhavesh Suhagia, Pranil Vora
 */
public class Player {
    private int pilotSkillLevel, fighterSkillLevel, traderSkillLevel,
        engineerSkillLevel, investorSkillLevel;
    private String name;
    
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
    }
}
