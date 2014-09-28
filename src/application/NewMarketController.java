package application;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class NewMarketController implements Initializable {
	private static Planet currentPlanet;
	
	private HashMap<String, Integer> buyMap = new HashMap<String, Integer>();
	private HashMap<String, Integer> sellMap = new HashMap<String, Integer>();
	private HashMap<String, Resource> resources = Universe.resources;
	//no need for a cargo map because the player will have a map
	//that can be editted and updated
	
	//Setup
	@FXML
	private Text mpTitle;
	@FXML
	private Text water, fur, food, ore, games, firearms, medicine,
	 machines, narcotics, robots;
	@FXML
	private Button cancelButton, checkoutButton;
	
	//Buy
	@FXML
	private Text buyWaterPrice, buyFurPrice, buyFoodPrice, buyOrePrice,
	buyGamesPrice, buyFirearmsPrice, buyMedicinePrice, buyMachinesPrice,
	buyNarcoticsPrice, buyRobotsPrice;
	@FXML
	private Text buyWaterAmt, buyFurAmt, buyFoodAmt, buyOreAmt,
	buyGamesAmt, buyFirearmsAmt, buyMedicineAmt, buyMachinesAmt,
	buyNarcoticsAmt, buyRobotsAmt;
	@FXML
	private Button plusBuyWater, plusBuyFur, plusBuyFood, plusBuyOre,
	plusBuyGames, plusBuyFirearms, plusBuyMedicine, plusBuyMachines,
	plusBuyNarcotics, plusBuyRobots;
	@FXML
	private Button minusBuyWater, minusBuyFur, minusBuyFood, minusBuyOre,
	minusBuyGames, minusBuyFirearms, minusBuyMedicine, minusBuyMachines,
	minusBuyNarcotics, minusBuyRobots;
	@FXML
	private Text waterTotalCost, furTotalCost, foodTotalCost, oreTotalCost, gamesTotalCost,
	firearmsTotalCost, medicineTotalCost, machinesTotalCost, narcoticsTotalCost, robotsTotalCost;
	
	//Sell
	@FXML
	private Text sellWaterPrice, sellFurPrice, sellFoodPrice, sellOrePrice,
	sellGamesPrice, sellFirearmsPrice, sellMedicinePrice, sellMachinesPrice,
	sellNarcoticsPrice, sellRobotsPrice;
	@FXML
	private Text sellWaterAmt, sellFurAmt, sellFoodAmt, sellOreAmt,
	sellGamesAmt, sellFirearmsAmt, sellMedicineAmt, sellMachinesAmt,
	sellNarcoticsAmt, sellRobotsAmt;
	@FXML
	private Button plusSellWater, plusSellFur, plusSellFood, plusSellOre,
	plusSellGames, plusSellFirearms, plusSellMedicine, plusSellMachines,
	plusSellNarcotics, plusSellRobots;
	@FXML
	private Button minusSellWater, minusSellFur, minusSellFood, minusSellOre,
	minusSellGames, minusSellFirearms, minusSellMedicine, minusSellMachines,
	minusSellNarcotics, minusSellRobots;
	@FXML
	private Text waterTotalGain, furTotalGain, foodTotalGain, oreTotalGain, gamesTotalGain,
	firearmsTotalGain, medicineTotalGain, machinesTotalGain, narcoticsTotalGain, robotsTotalGain;
	
	//Cargo
	@FXML
	private Text waterCargo, furCargo, foodCargo, oreCargo, gamesCargo,
	firearmsCargo, medicineCargo, machinesCargo, narcoticsCargo, robotsCargo;
	@FXML
	private Text totalCargo, maxCargo, netGainLoss, playerMoney;
	
	/**
	 * Sets the current planet to trade on.
	 * @param p the planet to trade on.
	 */
	public static void setPlanet(Planet p) {
		currentPlanet = p;
	}
	
	private void fillMaps() {
		String[] resources = {"Water", "Fur", "Food", "Ore", "Games",
				  "Firearms", "Medicine", "Machines",
				  "Narcotics", "Robots"};
		for (int x = 0; x < resources.length; x++) {
			buyMap.put(resources[x], 0);
			sellMap.put(resources[x], 0);
		}
	}
	
	private void setLabels() {
		water.setText("Water");
		fur.setText("Fur");
		food.setText("Food");
		ore.setText("Ore");
		games.setText("Games");
		firearms.setText("Firearms");
		medicine.setText("Medicine");
		machines.setText("Machines");
		narcotics.setText("Narcotics");
		robots.setText("Robots");
	}
	
	private void setPrices() {
		buyWaterPrice.setText("" + resources.get("Water").getCurrentBuyPrice(currentPlanet));
		buyFurPrice.setText("" + resources.get("Fur").getCurrentBuyPrice(currentPlanet));
		buyFoodPrice.setText("" + resources.get("Food").getCurrentBuyPrice(currentPlanet));
		buyOrePrice.setText("" + resources.get("Ore").getCurrentBuyPrice(currentPlanet));
		buyGamesPrice.setText("" + resources.get("Games").getCurrentBuyPrice(currentPlanet));
		buyFirearmsPrice.setText("" + resources.get("Firearms").getCurrentBuyPrice(currentPlanet));
		buyMedicinePrice.setText("" + resources.get("Medicine").getCurrentBuyPrice(currentPlanet));
		buyMachinesPrice.setText("" + resources.get("Machines").getCurrentBuyPrice(currentPlanet));
		buyNarcoticsPrice.setText("" + resources.get("Narcotics").getCurrentBuyPrice(currentPlanet));
		buyRobotsPrice.setText("" + resources.get("Robots").getCurrentBuyPrice(currentPlanet));
		
		sellWaterPrice.setText("" + resources.get("Water").getCurrentSellPrice(currentPlanet));
		sellFurPrice.setText("" + resources.get("Fur").getCurrentSellPrice(currentPlanet));
		sellFoodPrice.setText("" + resources.get("Food").getCurrentSellPrice(currentPlanet));
		sellOrePrice.setText("" + resources.get("Ore").getCurrentSellPrice(currentPlanet));
		sellGamesPrice.setText("" + resources.get("Games").getCurrentSellPrice(currentPlanet));
		sellFirearmsPrice.setText("" + resources.get("Firearms").getCurrentSellPrice(currentPlanet));
		sellMedicinePrice.setText("" + resources.get("Medicine").getCurrentSellPrice(currentPlanet));
		sellMachinesPrice.setText("" + resources.get("Machines").getCurrentSellPrice(currentPlanet));
		sellNarcoticsPrice.setText("" + resources.get("Narcotics").getCurrentSellPrice(currentPlanet));
		sellRobotsPrice.setText("" + resources.get("Robots").getCurrentSellPrice(currentPlanet));
	}
	
	private void setScreen() {
		mpTitle.setText(currentPlanet.name + " MarketPlace");
		setLabels();
		setPrices();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		fillMaps();
		setScreen();
	}
}
