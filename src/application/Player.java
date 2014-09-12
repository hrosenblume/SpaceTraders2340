package application;

public class Player {
	private int pilotSkillLevel, fighterSkillLevel, traderSkillLevel, engineerSkillLevel, investorSkillLevel;
	private String name;
	
	public Player(String name, int pilot, int fighter, int trader, int engineer, int investor) {
		this.name = name;
		this.pilotSkillLevel = pilot;
		this.fighterSkillLevel = fighter;
		this.traderSkillLevel = trader;
		this.engineerSkillLevel = engineer;
		this.investorSkillLevel = investor;
	}
}
