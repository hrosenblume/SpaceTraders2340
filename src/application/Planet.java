package application;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class Planet {
	static int planetCount = 0;
	static ArrayList<Point> usedPlanetLocations = new ArrayList<Point>();
	String[] planetNames = {
			"Adipose 3", "Arcadia", "Balhoon", "Brus", "Boeshane", "Calufrax Minor", "Chronos", "Demon's Run", "Daemos", "Earth", "Eye of Orion", "Felspoon", "Flane", "Gallifrey", "Griophos", "House", "Jahoo", "Jalian 17", "Karn", "Krop Tor", "Logopolis", "Limus 4", "Mondas", "Midnight", "Messaline", "Medusa Cascade", "New Alexandria", "Othrys", "Overod", "Pyrovilia", "Pandorica", "Poosh", "Quinnis", "Ribos", "Rex Vox Jax", "Saturnyne", "Shan Shen", "Skaro", "Sontar", "Sycorax", "Trenzalore", "Telos", "Terminus", "Utopia", "UX-4732", "Voga", "Vulcan", "Void", "Xenon", "Xeros"
	};
	private Random myGen = new Random();
	final String[] techLevels = {
			"PREAGRICULTURE", "AGRICULTURE", "MEDIEVAL", "RENNAISSANCE", "EARLYINDUSTRIAL", "INDUSTRIAL", "POSTINDUSTRIAL", "HITECH"			
	};
	final String[] resources = {
			"NOSPECIALRESOURCES", "NOSPECIALRESOURCES", "NOSPECIALRESOURCES", "NOSPECIALRESOURCES", "NOSPECIALRESOURCES", "MINERALRICH", "MINERALRICH", "MINERALPOOR", "MINERALPOOR", "DESERT", "LOTSOFWATER", "RICHSOIL", "POORSOIL", "RICHFAUNA", "LIFELESS", "WEIRDMUSHROOMS", "LOTSOFHERBS", "ARTISTIC", "WARLIKE"
	};	
	
	String name;
	Point planetLocation;
	String planetTechLevel;
	String planetResource;
	int policeIntensity, piracyLevel;
	
	public Planet() {
		this.name = planetNames[planetCount];
		planetTechLevel = techLevels[myGen.nextInt(8)];
		planetResource = resources[myGen.nextInt(19)];
		policeIntensity = myGen.nextInt(6);
		piracyLevel = 5-policeIntensity;
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
	
	public String toString() {
		return ("The name of the planet is " + name + ". It is located at " + planetLocation + ". The tech level is " + planetTechLevel + ". The resource is " + planetResource + ". The police intensity is " + policeIntensity + ". The piracy level is " + piracyLevel + ".\n");
		
	}
}
