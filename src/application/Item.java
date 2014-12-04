package application;

import java.util.HashMap;

/**
 * Represents all purchasable weapons, shields, and gadgets for a ship.
 * 
 * @author Stephen
 *
 */
public class Item {
    private int price;
    private int minTechLevel;
    private String name;
    private String type;
    static HashMap<String, Item> items = generateAllItems();

    /**
     * Constructs an item.
     * 
     * @param name the name of the item.
     * @param type the type (weapon/shield/gadget) it is
     * @param price the cost in the market
     * @param minTechLevel the minimum tech level to purchase this item at
     */
    public Item(String name, String type, int price, int minTechLevel) {
        this.name = name;
        this.type = type;
        this.price = price;
        if (type.equals("weapon") || type.equals("shield")) {
        	this.price *= 1 - (Universe.player.getFighter() / 100.0);
        } else if (type.equals("gadget")) {
        	this.price *= 1 - (Universe.player.getEngineer() / 100.0);
        }

        this.minTechLevel = minTechLevel;
    }

    /**
     * Populates the class's items.
     * 
     * @return a hashmap containing all the items.
     */
    static HashMap<String, Item> generateAllItems() {
        HashMap<String, Item> items = new HashMap<>();
        items.put("pulse", new Item("pulse", "weapon", 5000, 5));
        items.put("beam", new Item("beam", "weapon", 10000, 6));
        items.put("military", new Item("military", "weapon", 25000, 7));
        items.put("energy", new Item("energy", "shield", 10000, 4));
        items.put("reflective", new Item("reflective", "shield", 10000, 7));
        items.put("cargo", new Item("cargo", "gadget", 5000, 4));
        items.put("nav", new Item("nav", "gadget", 15000, 4));
        items.put("repair", new Item("repair", "gadget", 15000, 5));
        items.put("target", new Item("target", "gadget", 15000, 6));
        items.put("cloak", new Item("cloak", "gadget", 30000, 7));
        return items;
    }

    /**
     * Gets the name of the item.
     * 
     * @return the name of the item.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the type of the item.
     * 
     * @return the type of the item.
     */
    public String getType() {
        return type;
    }

    /**
     * Gets the price of the item.
     * 
     * @return the price of the item.
     */
    public int getPrice() {
        return price;
    }

    /**
     * Gets the minimum tech level of the item.
     * 
     * @return the minimum tech level of the item.
     */
    public int getMinTechLevel() {
        return minTechLevel;
    }
}
