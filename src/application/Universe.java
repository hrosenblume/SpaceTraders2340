package application;

import java.util.HashMap;

/**
 * Represents the in-game Universe that contains every visitable planet.
 * 
 * @author Hunter Rosenblume, Naman Shah, Stephen Song, Bhavesh Suhagia, Pranil
 *         Vora
 *
 */
public class Universe {
	static Planet[] universe = new Planet[50];
	static Player player;

	/**
	 * Constructs and populates the Universe.
	 */
	public Universe() {
		for (int x = 0; x < universe.length; x++) {
			Planet p = new Planet();
			universe[x] = p;
		}
	}

	public void setPlayer(Player p) {
		this.player = p;
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

	public Planet[] getNearbyPlanets(Planet p) {
		return bubbleSort(universe, p);
	}
	
	private Planet[] bubbleSort(Planet ar[], Planet p) {
		for (int i = (ar.length - 1); i >= 0; i--) {
			for (int j = 1; j <= i; j++) {
				if (ar[j-1].calculateDistance(p) > ar[j].calculateDistance(p)) {
					Planet temp = ar[j-1];
					ar[j-1] = ar[j];
					ar[j] = temp;
				} 
			}
		}
		return ar;
	}
}
