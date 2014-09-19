package application;

/**
 * Represents the in-game Universe that contains every visitable planet.
 * @author Hunter Rosenblume, Naman Shah, Stephen Song, Bhavesh Suhagia, Pranil Vora
 *
 */
public class Universe {
	Planet[] universe = new Planet[50];
	
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
