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

<<<<<<< HEAD
	/**
	 * Sets the player
	 * @param p Player
	 */
	public void setPlayer(Player p) {
		this.player = p;
	}
=======
    /**
     * Sets the player
     * 
     * @param p
     *            Player
     */
    public void setPlayer(Player p) {
        this.player = p;
    }
>>>>>>> a6dd8ed23bf473ebe66d10204bc2583aa9f18a79

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

<<<<<<< HEAD
	/**
	 * Sorts the universe based on distance from planet p
	 * @param p current planet
	 * @return sorted universe array
	 */
	public static Planet[] getNearbyPlanets(Planet p) {
		return bubbleSort(universe, p);
	}
	
	/**
	 * Sorts array of planets based on distance from current planet
	 * @param ar array of Planets
	 * @param p current planet
	 * @return sorted array
	 */
	private static Planet[] bubbleSort(Planet ar[], Planet p) {
		for (int i = (ar.length - 1); i >= 0; i--) {
			for (int j = 1; j <= i; j++) {
				if (ar[j-1].calculateDistance(p) > ar[j].calculateDistance(p)) {
					Planet temp = ar[j-1];
					ar[j-1] = ar[j];
					ar[j] = temp;
				} 
			}
		}
/*		System.out.println("Bubble-Sorted Planets:");
		for (Planet pl: ar) {
			int dist = (int)pl.calculateDistance(p);
			System.out.println("Dist: " + dist);
			System.out.println(pl);
		}*/
		return ar;
	}
=======
    /**
     * Sorts the universe based on distance from planet p
     * 
     * @param p
     *            current planet
     * @return sorted universe array
     */
    public static Planet[] getNearbyPlanets(Planet p) {
        return bubbleSort(universe, p);
    }

    /**
     * Sorts array of planets based on distance from current planet
     * 
     * @param ar
     *            array of Planets
     * @param p
     *            current planet
     * @return sorted array
     */
    private static Planet[] bubbleSort(Planet ar[], Planet p) {
        for (int i = (ar.length - 1); i >= 0; i--) {
            for (int j = 1; j <= i; j++) {
                if (ar[j - 1].calculateDistance(p) > ar[j].calculateDistance(p)) {
                    Planet temp = ar[j - 1];
                    ar[j - 1] = ar[j];
                    ar[j] = temp;
                }
            }
        }
        /*
         * System.out.println("Bubble-Sorted Planets:"); for (Planet pl: ar) {
         * int dist = (int)pl.calculateDistance(p); System.out.println("Dist: "
         * + dist); System.out.println(pl); }
         */
        return ar;
    }
>>>>>>> a6dd8ed23bf473ebe66d10204bc2583aa9f18a79
}
