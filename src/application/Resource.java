package application;

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
