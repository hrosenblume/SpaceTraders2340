package application;

import java.util.HashMap;
import java.util.Random;

/**
 * Represents a resource and its properties.
 * @author Stephen
 */
public class Resource {
	String name;
	int basePrice;
	int minTechProduceLevel;
	int minTechUseLevel;
	int mostCommonTechProduceLevel;
	int techLevelRampUp;
	int variance; // percent out of 100
	String highDemandEvent;
	String highProduceResource;
	String highDemandResource;
	int minRandomTraderPrice;
	int maxRandomTraderPrice;
	int currentBuyPrice;
	int currentSellPrice;
	boolean isBuyable;
	boolean isSellable;
	static HashMap<String, Resource> resources = generateResources();

	/**
	 * Constructs a resource.
	 * @param name the name of the resource
	 * @param MTLP the minimum tech level to produce this resource
	 * @param MTLU the minimum tech level to use/sell this resource to
	 * @param TTP the tech level which produces the most of this resource
	 * @param base the base cost of this resource
	 * @param IPL the ramping cost of this resource
	 * @param var the random variance of this resource
	 * @param IE the planetary event which increases the price of this resource
	 * @param CR the planetary resource which makes this cheap
	 * @param ER the planetary resource which makes this expensive
	 * @param MTL the lowest price a random trader will buy this resource for
	 * @param MTH the highest price a random trader will buy this resource for
	 */
	public Resource(String name, int MTLP, int MTLU, int TTP, int base, int IPL,
			int var, String IE, String CR, String ER, int MTL, int MTH) {
		this.name = name;
		minTechProduceLevel = MTLP;
		minTechUseLevel = MTLU;
		mostCommonTechProduceLevel = TTP;
		basePrice = base;
		techLevelRampUp = IPL;
		variance = var;
		highDemandEvent = IE;
		highProduceResource = CR;
		highDemandResource = ER;
		minRandomTraderPrice = MTL;
		maxRandomTraderPrice = MTH;
		currentBuyPrice = base;
		currentSellPrice = base;
		isBuyable = false;
		isSellable = false;
	}
	
	/**
	 * Returns the String representation of this resource.
	 * @return the information about the given resource.
	 */
	public String toString() {
		return name + ": \n"
		+ "minTechUseLevel: " + minTechUseLevel + "\n"
		+ "mostCommonTechProduceLevel: " + mostCommonTechProduceLevel + "\n"
		+ "basePrice: " + basePrice + "\n"
		+ "techLevelRampUp: " + techLevelRampUp + "\n"
		+ "variance: " + variance + "\n"
		+ "highDemandEvent: " + highDemandEvent + "\n"
		+ "highProduceResource: " + highProduceResource + "\n"
		+ "highDemandResource: " + highDemandResource + "\n"
		+ "minRandomTraderPrice: " + minRandomTraderPrice + "\n"
		+ "maxRandomTraderPrice: " +  maxRandomTraderPrice + "\n";
	}
	
	/**
	 * Generates all the possible resources in this universe.
	 */
	private static HashMap<String, Resource> generateResources() {
		HashMap<String, Resource> internalResources = new HashMap<String, Resource>();
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
		return internalResources;
	}
	
	public int getCurrentBuyPrice(Planet planet) {
		currentBuyPrice = computeBuyPrice(planet);
		return currentBuyPrice;
	}
	
	public int getCurrentSellPrice(Planet planet) {
		currentSellPrice = computeSellPrice(planet);
		return currentSellPrice;
	}
	
	public boolean isBuyable(Planet planet) {
		isBuyable = this.minTechProduceLevel <= planet.planetTechInteger;
		return isBuyable;
	}
	
	public boolean isSellable(Planet planet) {
		isSellable = this.minTechUseLevel <= planet.planetTechInteger;
		return isSellable;
	}
	
	private int computeBuyPrice(Planet planet) {
		int price = this.basePrice;
		price += ((planet.planetTechInteger - this.minTechProduceLevel)
				* this.techLevelRampUp);
		Random rand = new Random();
		price += rand.nextInt(this.variance);
		// events like war, drought, boredom, lack of workers not implemented yet
		// if (currentPlanet.event.equals(r.highDemandEvent)) price *= 1.5;
		if (planet.planetResource.equals(this.highProduceResource)) {
			price *= 0.5; // this resource is cheap
		}
		if (planet.planetResource.equals(this.highDemandResource)) {
			price *= 1.5; // this resource is expensive
		}
		return price;
	}
	
	private int computeSellPrice(Planet planet) {
		int price = this.basePrice;
		price += ((planet.planetTechInteger - this.minTechUseLevel)
				* this.techLevelRampUp);
		Random rand = new Random();
		price += rand.nextInt(this.variance);
		// events like war, drought, boredom, lack of workers not implemented yet
		// if (currentPlanet.event.equals(r.highDemandEvent)) price *= 1.5;
		if (planet.planetResource.equals(this.highProduceResource)) {
			price *= 0.5; // this resource is cheap
		}
		if (planet.planetResource.equals(this.highDemandResource)) {
			price *= 1.5; // this resource is expensive
		}
		return price;
	}

}
