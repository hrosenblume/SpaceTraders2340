package application;

import java.util.HashMap;

/**
 * Represents the in-game Universe that contains every visitable planet.
 * @author Hunter Rosenblume, Naman Shah, Stephen Song, Bhavesh Suhagia, Pranil Vora
 *
 */
public class Universe {
	static Planet[] universe = new Planet[50];
	static HashMap<String, Resource> resources = generateResources();
	
	/**
	 * Constructs and populates the Universe.
	 */
	public Universe() {
		for (int x = 0; x < universe.length; x++) {
			Planet p = new Planet();
			universe[x] = p;
		}
	}
	
	/**
	 * Generates all the possible resources in this universe.
	 */
	private static HashMap<String, Resource> generateResources() {
		HashMap<String, Resource> internalResources = new HashMap<String, Resource>();;
		internalResources.put("Water", new Resource("Water", 0, 0, 2, 30, 3, 4,
				"DROUGHT", "LOTSOFWATER", "DESERT", 30, 50));
		internalResources.put("Fur", new Resource("Furs", 0, 0, 0, 250, 10, 10,
				"COLD", "RICHFAUNA", "LIFELESS", 230, 280));
		internalResources.put("Food", new Resource("Food", 1, 0, 1, 100, 5, 5,
				"CROPFAIL", "RICHSOIL", "POORSOIL", 90, 160));
		internalResources.put("Ore", new Resource("Ore", 2, 2, 3, 350, 20, 10,
				"WAR", "MINERALRICH", "MINERALPOOR", 350, 420));
		internalResources.put("Games", new Resource("Games", 3, 1, 6, 250, -10, 5,
				"BOREDOM", "ARTISTIC", "", 160, 270));
		internalResources.put("Firearms", new Resource("Firearms", 3, 1, 5, 1250, -75, 100,
				"WAR", "WARLIKE", "", 600, 1100));
		internalResources.put("Medicine", new Resource("Medicine", 4, 1, 6, 650, -20, 10,
				"PLAGUE", "LOTSOFHERBS", "", 400, 700));
		internalResources.put("Machines", new Resource("Machines", 4, 3, 5, 900, -30, 5,
				"LACKOFWORKERS", "", "", 600, 800));
		internalResources.put("Narcotics", new Resource("Narcotics", 5, 0, 5, 3500, -125, 150,
				"BOREDOM", "WEIRDMUSHROOMS", "", 2000, 3000));
		internalResources.put("Robots", new Resource("Robots", 6, 4, 7, 5000, -150, 100,
				"LACKOFWORKERS", "", "", 3500, 5000));
		return resources;
	}
	
	/**
	 * Prints out every planet that the Universe contains.
	 */
	public String toString() {
		String s = "";
		for (int x = 0; x < universe.length; x++) {
			s += universe[x];
		}
		return s;
	}
}
