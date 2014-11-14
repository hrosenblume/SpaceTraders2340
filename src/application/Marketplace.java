package application;

import java.util.HashMap;
import java.util.Random;
import java.util.Map.Entry;

/**
 * Contains the names of resources and how much they cost in the planet.
 * 
 * @author Stephen
 */
public class Marketplace {

<<<<<<< HEAD
    Planet planet;
    private Random myGen = new Random();

    HashMap<String, Integer> sellableResources = new HashMap<>();
    HashMap<String, Integer> buyableResources = new HashMap<>();

    /**
     * Constructs a Marketplace.
     * 
     * @param techLevel
     *            the tech level of the planet
     * @param resource
     *            the special resource on the planet
     */
    public Marketplace(Planet planet) {
        this.planet = planet;
        fillMaps();
    }

    /**
     * Populates the resource HashMaps with their prices.
     */
    void fillMaps() {
        for (Entry<String, Resource> entry : Resource.resources.entrySet()) {
            String name = entry.getKey();
            Resource r = entry.getValue();
            if (isSellable(r)) {
                int price = r.basePrice;
                price +=
                        ((planet.planetTechInteger - r.minTechProduceLevel) * r.techLevelRampUp);
                price += myGen.nextInt(r.variance);
                if (r.equals(r.highProduceResource)) {
                    price *= 0.5; // this resource is cheap
                }
                if (r.equals(r.highDemandResource)) {
                    price *= 1.5; // this resource is expensive
                }
                sellableResources.put(name, price);
            } else {
                sellableResources.put(name, -1);
            }
            if (isBuyable(r)) {
                int price = r.basePrice;
                price +=
                        ((planet.planetTechInteger - r.minTechProduceLevel) * r.techLevelRampUp);
                price += myGen.nextInt(r.variance);
                if (r.equals(r.highProduceResource)) {
                    r.currentBuyPrice *= 0.5; // this resource is cheap
                }
                if (r.equals(r.highDemandResource)) {
                    r.currentBuyPrice *= 1.5; // this resource is expensive
                }
                buyableResources.put(name, price);
            } else {
                buyableResources.put(name, -1);
            }

        }
    }

    /**
     * Returns the selling price of a resource in this marketplace.
     * 
     * @param r
     *            the resource to get the price for
     * @return the price if it can be sold on this planet, -1 if it cannot
     */
    public int getSellPrice(String r) {
        return sellableResources.get(r);
    }

    /**
     * Returns the buying price of a resource in this marketplace.
     * 
     * @param r
     *            the resource to get the price for
     * @return the price if it can be bought on this planet, -1 if it cannot
     */
    public int getBuyPrice(String r) {
        return buyableResources.get(r);
    }

    /**
     * Determines whether you can buy a particular resource on a planet.
     * 
     * @param r
     *            the resource to potentially buy.
     * @return true if the resource can be bought, false otherwise.
     */
    private boolean isBuyable(Resource r) {
        return r.minTechProduceLevel <= planet.planetTechInteger;
    }

    /**
     * Determines whether you can sell a particular resource on a planet.
     * 
     * @param r
     *            the resource to potentially sell.
     * @return true if the resource can be sold, false otherwise.
     */
    private boolean isSellable(Resource r) {
        return r.minTechUseLevel <= planet.planetTechInteger;
    }

    public Planet getPlanet() {
        return planet;
    }

=======
	Planet planet;
	private Random myGen = new Random();
	
	HashMap<String, Integer> sellableResources = new HashMap<>();
	HashMap<String, Integer> buyableResources = new HashMap<>();
	
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
		for(Entry<String, Resource> entry : Resource.resources.entrySet()) {
			String name = entry.getKey();
			Resource r = entry.getValue();
			if (isSellable(r)) {
				int price = r.basePrice;
				price += ((planet.planetTechInteger - r.minTechProduceLevel)
						* r.techLevelRampUp);
				price += myGen.nextInt(r.variance);
				if (r.name.equals(r.highProduceResource)) {
					price *= 0.5; // this resource is cheap
				}
				if (r.name.equals(r.highDemandResource)) {
					price *= 1.5; // this resource is expensive
				}
				sellableResources.put(name, price);
			} else {
				sellableResources.put(name, -1);
			}
			if (isBuyable(r)) {
				int price = r.basePrice;
				price += ((planet.planetTechInteger - r.minTechProduceLevel)
						* r.techLevelRampUp);
				price += myGen.nextInt(r.variance);
				if (r.name.equals(r.highProduceResource)) {
					r.currentBuyPrice *= 0.5; // this resource is cheap
				}
				if (r.name.equals(r.highDemandResource)) {
					r.currentBuyPrice *= 1.5; // this resource is expensive
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
	public int getSellPrice(String r) {
		return sellableResources.get(r);
	}
	
	/**
	 * Returns the buying price of a resource in this marketplace.
	 * @param r the resource to get the price for
	 * @return the price if it can be bought on this planet, -1 if it cannot
	 */
	public int getBuyPrice(String r) {
		return buyableResources.get(r);
	}
	
	/**
	 * Determines whether you can buy a particular resource on a planet.
	 * @param r the resource to potentially buy.
	 * @return true if the resource can be bought, false otherwise.
	 */
	private boolean isBuyable(Resource r) {
		return r.minTechProduceLevel <= planet.planetTechInteger;
	}
	
	/**
	 * Determines whether you can sell a particular resource on a planet.
	 * @param r the resource to potentially sell.
	 * @return true if the resource can be sold, false otherwise.
	 */
	private boolean isSellable(Resource r) {
		return r.minTechUseLevel <= planet.planetTechInteger;
	}
	
	public Planet getPlanet() {
		return planet;
	}
	
>>>>>>> b89c8ee1468cfa51dcb4be26ae8c3b84404678dc
}
