package application;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

/**
 * Represents a visitable planet with various attributes.
 * @author Hunter Rosenblume, Naman Shah, Stephen Song, Bhavesh Suhagia, Pranil Vora
 */
public class Planet {

	String[] planetNames = {"Adipose 3", "Arcadia", "Balhoon", "Brus", "Boeshane",
			"Calufrax Minor", "Chronos", "Demon's Run", "Daemos", "Earth",
			"Eye of Orion", "Felspoon", "Flane", "Gallifrey", "Griophos", "House",
			"Jahoo", "Jalian 17", "Karn", "Krop Tor", "Logopolis", "Limus 4",
			"Mondas", "Midnight", "Messaline", "Medusa Cascade", "New Alexandria",
			"Othrys", "Overod", "Pyrovilia", "Pandorica", "Poosh", "Quinnis",
			"Ribos", "Rex Vox Jax", "Saturnyne", "Shan Shen", "Skaro", "Sontar",
			"Sycorax", "Trenzalore", "Telos", "Terminus", "Utopia", "UX-4732",
			"Voga", "Vulcan", "Void", "Xenon", "Xeros"};

	final String[] techLevels = {"PREAGRICULTURE", "AGRICULTURE", "MEDIEVAL",
			"RENNAISSANCE", "EARLYINDUSTRIAL", "INDUSTRIAL", "POSTINDUSTRIAL",
	"HITECH"};

	final String[] resources = {"NOSPECIALRESOURCES", "NOSPECIALRESOURCES",
			"NOSPECIALRESOURCES", "NOSPECIALRESOURCES", "NOSPECIALRESOURCES",
			"MINERALRICH", "MINERALRICH", "MINERALPOOR", "MINERALPOOR", "DESERT",
			"LOTSOFWATER", "RICHSOIL", "POORSOIL", "RICHFAUNA", "LIFELESS",
			"WEIRDMUSHROOMS", "LOTSOFHERBS", "ARTISTIC", "WARLIKE"};	

	static int planetCount = 0;
	static ArrayList<Point> usedPlanetLocations = new ArrayList<Point>();
	private Random myGen = new Random();

	Marketplace marketplace;

	int policeIntensity, piracyLevel;
	int planetTechInteger;
	Point planetLocation;
	String name, planetResource, planetTechLevel;

	/**
	 * Constructs a Planet.
	 * Tech levels, resources, police presence, and location are randomly picked.
	 */
	public Planet() {
		// initialize base stats
		this.name = planetNames[planetCount];
		planetTechInteger = myGen.nextInt(8);
		planetTechLevel = techLevels[planetTechInteger];
		planetResource = resources[myGen.nextInt(19)];
		policeIntensity = myGen.nextInt(6);
		piracyLevel = 5 - policeIntensity;
		marketplace = new Marketplace(this);
		// generate unique location
		boolean doAgain = false;
		Point planetLoc;
		do {
			int x = myGen.nextInt(150);
			int y = myGen.nextInt(100);
			planetLoc = new Point(x,y);
			for (int i = 0; i < usedPlanetLocations.size(); i++) {
				if (usedPlanetLocations.get(i).equals(planetLoc)) {
					doAgain = true;
				}
			}
		} while(doAgain);
		usedPlanetLocations.add(planetLoc);
		planetLocation = planetLoc;
		planetCount++;
	}

	/**
	 * Returns the String representation of this planet.
	 * @return the information about the given planet.
	 */
	public String toString() {
		return ("The name of the planet is " + name
				+ ". It is located at ("
				+ (int)planetLocation.getX() + ", " + (int)planetLocation.getY()
				+ "). The tech level is " + planetTechLevel
				+ ". The resource is " + planetResource
				+ ". The police intensity is " + policeIntensity
				+ ". The piracy level is " + piracyLevel + ".\n");	
	}

	/**
	 * Gets the name of the planet.
	 * @return the name of the planet.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the police intensity value of the planet.
	 * @return the police intensity value of the planet.
	 */
	public int policeIntensity() {
		return policeIntensity;
	}

	/**
	 * CURRENTLY UNIMPLEMENTED
	 * @return null for the moment
	 */
	public String[] getNearbyPlanets() {
		//Universe.getNearbyPlanets(this);
		return null;
	}
	
	/**
	 * Gets and passes back the tech level
	 * @return the tech level
	 */
	public int getTechLevel() {
		return planetTechInteger;
	}

	/**
	 * Calculates the distance between this planet and another.
	 * @param other the planet to calculate the distance to.
	 * @return the distance between the two planets.
	 */
	public double calculateDistance(Planet other) {
		double y = Math.pow((this.planetLocation.getY()-other.planetLocation.getY()), 2); 
		double x = Math.pow((this.planetLocation.getX()-other.planetLocation.getX()), 2); 
		return Math.sqrt(x+y);
	}

}
