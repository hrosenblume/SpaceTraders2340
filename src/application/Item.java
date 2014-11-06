package application;

import java.util.HashMap;

public class Item {
	private int price;
	private int minTechLevel;
	private String name;
	private String type;
	static HashMap<String, Item> items = generateAllItems();
	
	public Item(String name, String type, int price, int minTechLevel) {
		this.name = name;
		this.type = type;
		this.price = price;
		this.minTechLevel = minTechLevel;
	}
	
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
	
	public String getName() {
		return name;
	}
	public String getType() {
		return type;
	}
	public int getPrice() {
		return price;
	}
	public int getMinTechLevel() {
		return minTechLevel;
	}
}
