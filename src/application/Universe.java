package application;

/**
 * Represents the in-game Universe that contains every visitable planet.
 * @author Hunter Rosenblume, Naman Shah, Stephen Song, Bhavesh Suhagia, Pranil Vora
 *
 */
public class Universe {
	static Planet[] universe = new Planet[50];
	static Resource[] resources = new Resource[10];
	
	/**
	 * Constructs and populates the Universe.
	 */
	public Universe() {
		for (int x = 0; x < universe.length; x++) {
			Planet p = new Planet();
			universe[x] = p;
		}
		generateResources();
	}
	
	/**
	 * Generates all the possible resources in this universe.
	 */
	private void generateResources() {
		resources[0] = new Resource("Water", 0, 0, 2, 30, 3, 4,
				"DROUGHT", "LOTSOFWATER", "DESERT", 30, 50);
		resources[1] = new Resource("Furs", 0, 0, 0, 250, 10, 10,
				"COLD", "RICHFAUNA", "LIFELESS", 230, 280);
		resources[2] = new Resource("Food", 1, 0, 1, 100, 5, 5,
				"CROPFAIL", "RICHSOIL", "POORSOIL", 90, 160);
		resources[3] = new Resource("Ore", 2, 2, 3, 350, 20, 10,
				"WAR", "MINERALRICH", "MINERALPOOR", 350, 420);
		resources[4] = new Resource("Games", 3, 1, 6, 250, -10, 5,
				"BOREDOM", "ARTISTIC", "", 160, 270);
		resources[5] = new Resource("Firearms", 3, 1, 5, 1250, -75, 100,
				"WAR", "WARLIKE", "", 600, 1100);
		resources[6] = new Resource("Medicine", 4, 1, 6, 650, -20, 10,
				"PLAGUE", "LOTSOFHERBS", "", 400, 700);
		resources[7] = new Resource("Machines", 4, 3, 5, 900, -30, 5,
				"LACKOFWORKERS", "", "", 600, 800);
		resources[8] = new Resource("Narcotics", 5, 0, 5, 3500, -125, 150,
				"BOREDOM", "WEIRDMUSHROOMS", "", 2000, 3000);
		resources[9] = new Resource("Robots", 6, 4, 7, 5000, -150, 100,
				"LACKOFWORKERS", "", "", 3500, 5000);
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
