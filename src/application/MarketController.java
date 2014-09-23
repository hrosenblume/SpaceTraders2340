package application;

import java.util.Random;

/**
 * Manages trading algorithms and control.
 * @author Stephen
 */
public class MarketController {
	private Planet currentPlanet;
	
	/**
	 * Sets the current planet to trade on.
	 * @param p the planet to trade on.
	 */
	public void setPlanet(Planet p) {
		currentPlanet = p;
	}
	
	/**
	 * Displays all of the buyable resources on this planet
	 */
	public void displayBuyPrices() {
		System.out.println("Buying Prices:");
		for (int i = 0; i < Universe.resources.length; i++) {
			// replace print statement with some buttons of some sort
			System.out.println(displayBuyPrice(Universe.resources[i]));
		}
	}
	
	/**
	 * Displays all of the sellable resources on this planet
	 */
	public void displaySellPrices() {
		System.out.println("Selling Prices:");
		for (int i = 0; i < Universe.resources.length; i++) {
			// replace print statement with some buttons of some sort
			System.out.println(displaySellPrice(Universe.resources[i]));
		}
	}
	
	/**
	 * Returns the buying price in the form of a String
	 * @param r the resource to be bought
	 * @return the price of the resource, or "Not Buyable" if it cannot be bought
	 */
	private String displayBuyPrice(Resource r) {
		if (!isBuyable(r)) {
			return r.name + ": Not Buyable";
		}
		return r.name + ": " + computeBuyPrice(r);
	}
	
	/**
	 * Returns the selling price in the form of a String
	 * @param r the resource to be sold
	 * @return the price of the resource, or "Not Sellable" if it cannot be bought
	 */
	private String displaySellPrice(Resource r) {
		if (!isSellable(r)) {
			return r.name + ": Not Sellable";
		}
		return r.name + ": " + computeSellPrice(r);
	}
	
	private int computeBuyPrice(Resource r) {
		int price = r.basePrice;
		price += ((currentPlanet.planetTechInteger - r.minTechProduceLevel)
				* r.techLevelRampUp);
		Random rand = new Random();
		price += rand.nextInt(r.variance);
		// events like war, drought, boredom, lack of workers not implemented yet
		// if (currentPlanet.event.equals(r.highDemandEvent)) price *= 1.5;
		if (currentPlanet.planetResource.equals(r.highProduceResource)) {
			price *= 0.5; // this resource is cheap
		}
		if (currentPlanet.planetResource.equals(r.highDemandResource)) {
			price *= 1.5; // this resource is expensive
		}
		return price;
	}
	
	private int computeSellPrice(Resource r) {
		int price = r.basePrice;
		price += ((currentPlanet.planetTechInteger - r.minTechUseLevel)
				* r.techLevelRampUp);
		Random rand = new Random();
		price += rand.nextInt(r.variance);
		// events like war, drought, boredom, lack of workers not implemented yet
		// if (currentPlanet.event.equals(r.highDemandEvent)) price *= 1.5;
		if (currentPlanet.planetResource.equals(r.highProduceResource)) {
			price *= 0.5; // this resource is cheap
		}
		if (currentPlanet.planetResource.equals(r.highDemandResource)) {
			price *= 1.5; // this resource is expensive
		}
		return price;
	}
	
	/**
	 * Determines whether you can buy a particular resource on a planet.
	 * @param r the resource to potentially buy.
	 * @return true if the resource can be bought, false otherwise.
	 */
	public boolean isBuyable(Resource r) {
		return r.minTechProduceLevel <= currentPlanet.planetTechInteger;
	}
	
	/**
	 * Determines whether you can sell a particular resource on a planet.
	 * @param r the resource to potentially sell.
	 * @return true if the resource can be sold, false otherwise.
	 */
	public boolean isSellable(Resource r) {
		return r.minTechUseLevel <= currentPlanet.planetTechInteger;
	}
	
}
