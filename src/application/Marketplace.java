package application;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;

/**
 * Contains the names of resources and how much they cost in the planet.
 * 
 * @author Stephen
 */
public class Marketplace {

	private final transient Planet planet;
	private final transient Random myGen = new Random();
	
	private final transient Map<String, Integer> sellableResources = new HashMap<>();
	private final transient Map<String, Integer> buyableResources = new HashMap<>();
	
	/**
	 * Constructs a Marketplace.
	 * @param techLevel the tech level of the planet
	 * @param resource the special resource on the planet
	 */
	public Marketplace(Planet planet) {
		this.planet = planet;
		fillMaps();
	}
	
	/**
	 * Populates the resource HashMaps with their prices.
	 */
	void fillMaps() {
		for(final Entry<String, Resource> entry : Resource.resources.entrySet()) {
			final String name = entry.getKey();
			Resource res = entry.getValue();
			if (isSellable(res)) {
				int price = res.basePrice;
				price += (planet.planetTechInteger - res.minTechProduceLevel)
						* res.techLevelRampUp;
				price += myGen.nextInt(res.variance);
				if (res.name.equals(res.highProduceResource)) {
					price *= 0.5; // this resource is cheap
				}
				if (res.name.equals(res.highDemandResource)) {
					price *= 1.5; // this resource is expensive
				}
				if (res.name.equals("Water") || res.name.equals("Fur")
						|| res.name.equals("Food") || res.name.equals("Ore")) {
					price *= 1 + (Universe.player.getTrader() / 100.0);
				}
				if (res.name.equals("Firearms")) {
					price *= 1 + (Universe.player.getFighter() / 100.0);
				}
				if (res.name.equals("Robots") || res.name.equals("Machine")
						|| res.name.equals("Games")
						|| res.name.equals("Medicine")
						|| res.name.equals("Narcotics")) {
					price *= 1 + (Universe.player.getInvestor() / 100.0);
				}
				sellableResources.put(name, price);
			} else {
				sellableResources.put(name, -1);
			}
			if (isBuyable(res)) {
				int price = res.basePrice;
				price += (planet.planetTechInteger - res.minTechProduceLevel)
						* res.techLevelRampUp;
				price += myGen.nextInt(res.variance);
				if (res.name.equals(res.highProduceResource)) {
					res.currentBuyPrice *= 0.5; // this resource is cheap
				}
				if (res.name.equals(res.highDemandResource)) {
					res.currentBuyPrice *= 1.5; // this resource is expensive
				}
				if (res.name.equals("Water") || res.name.equals("Fur")
						|| res.name.equals("Food") || res.name.equals("Ore")) {
					price *= 1 - (Universe.player.getTrader() / 100.0);
				}
				if (res.name.equals("Firearms")) {
					price *= 1 - (Universe.player.getFighter() / 100.0);
				}
				if (res.name.equals("Robots") || res.name.equals("Machine")
						|| res.name.equals("Games")
						|| res.name.equals("Medicine")
						|| res.name.equals("Narcotics")) {
					price *= 1 - (Universe.player.getInvestor() / 100.0);
				}
				buyableResources.put(name, price);
			} else {
				buyableResources.put(name, -1);
			}
			
			
		}
	}
	
	/**
	 * Returns the selling price of a resource in this marketplace.
	 * @param r the resource to get the price for
	 * @return the price if it can be sold on this planet, -1 if it cannot
	 */
	public int getSellPrice(final String res) {
		return sellableResources.get(res);
	}
	
	/**
	 * Returns the buying price of a resource in this marketplace.
	 * @param r the resource to get the price for
	 * @return the price if it can be bought on this planet, -1 if it cannot
	 */
	public int getBuyPrice(final String res) {
		return buyableResources.get(res);
	}
	
	/**
	 * Determines whether you can buy a particular resource on a planet.
	 * @param r the resource to potentially buy.
	 * @return true if the resource can be bought, false otherwise.
	 */
	private boolean isBuyable(final Resource res) {
		return res.minTechProduceLevel <= planet.planetTechInteger;
	}
	
	/**
	 * Determines whether you can sell a particular resource on a planet.
	 * @param r the resource to potentially sell.
	 * @return true if the resource can be sold, false otherwise.
	 */
	private boolean isSellable(final Resource res) {
		return res.minTechUseLevel <= planet.planetTechInteger;
	}
	
	public Planet getPlanet() {
		return planet;
	}
}
