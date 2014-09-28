package application;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class NewMarketController implements Initializable {
	private static Planet currentPlanet;
	
	private HashMap<String, Integer> buyMap = new HashMap<String, Integer>();
	private HashMap<String, Integer> sellMap = new HashMap<String, Integer>();
	private HashMap<String, Resource> resources = Resource.resources;
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
	private Text totalCargo, maxCargo, totalCost, totalGain, netGainLoss, playerMoney;
	
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
	
	private void setAmt() {
		buyWaterAmt.setText("" + buyMap.get("Water"));
		buyFurAmt.setText("" + buyMap.get("Fur"));
		buyFoodAmt.setText("" + buyMap.get("Food"));
		buyOreAmt.setText("" + buyMap.get("Ore"));
		buyGamesAmt.setText("" + buyMap.get("Games"));
		buyFirearmsAmt.setText("" + buyMap.get("Firearms"));
		buyMedicineAmt.setText("" + buyMap.get("Medicine"));
		buyMachinesAmt.setText("" + buyMap.get("Machines"));
		buyNarcoticsAmt.setText("" + buyMap.get("Narcotics"));
		buyRobotsAmt.setText("" + buyMap.get("Robots"));
		
		sellWaterAmt.setText("" + sellMap.get("Water"));
		sellFurAmt.setText("" + sellMap.get("Fur"));
		sellFoodAmt.setText("" + sellMap.get("Food"));
		sellOreAmt.setText("" + sellMap.get("Ore"));
		sellGamesAmt.setText("" + sellMap.get("Games"));
		sellFirearmsAmt.setText("" + sellMap.get("Firearms"));
		sellMedicineAmt.setText("" + sellMap.get("Medicine"));
		sellMachinesAmt.setText("" + sellMap.get("Machines"));
		sellNarcoticsAmt.setText("" + sellMap.get("Narcotics"));
		sellRobotsAmt.setText("" + sellMap.get("Robots"));
	}
	
	private void setCosts() {
		waterTotalCost.setText("" + resources.get("Water").getCurrentBuyPrice(currentPlanet)*buyMap.get("Water"));
		furTotalCost.setText("" + resources.get("Fur").getCurrentBuyPrice(currentPlanet)*buyMap.get("Fur"));
		foodTotalCost.setText("" + resources.get("Food").getCurrentBuyPrice(currentPlanet)*buyMap.get("Food"));
		oreTotalCost.setText("" + resources.get("Ore").getCurrentBuyPrice(currentPlanet)*buyMap.get("Ore"));
		gamesTotalCost.setText("" + resources.get("Games").getCurrentBuyPrice(currentPlanet)*buyMap.get("Games"));
		firearmsTotalCost.setText("" + resources.get("Firearms").getCurrentBuyPrice(currentPlanet)*buyMap.get("Firearms"));
		medicineTotalCost.setText("" + resources.get("Medicine").getCurrentBuyPrice(currentPlanet)*buyMap.get("Medicine"));
		machinesTotalCost.setText("" + resources.get("Machines").getCurrentBuyPrice(currentPlanet)*buyMap.get("Machines"));
		narcoticsTotalCost.setText("" + resources.get("Narcotics").getCurrentBuyPrice(currentPlanet)*buyMap.get("Narcotics"));
		robotsTotalCost.setText("" + resources.get("Robots").getCurrentBuyPrice(currentPlanet)*buyMap.get("Robots"));
	}
	
	private void setGains() {
		waterTotalGain.setText("" + resources.get("Water").getCurrentSellPrice(currentPlanet)*sellMap.get("Water"));
		System.out.println("Test1: " + resources.get("Water").getCurrentSellPrice(currentPlanet));
		System.out.println("Test2: 0" + sellMap.get("Water"));
		furTotalGain.setText("" + resources.get("Fur").getCurrentSellPrice(currentPlanet)*sellMap.get("Fur"));
		foodTotalGain.setText("" + resources.get("Food").getCurrentSellPrice(currentPlanet)*sellMap.get("Food"));
		oreTotalGain.setText("" + resources.get("Ore").getCurrentSellPrice(currentPlanet)*sellMap.get("Ore"));
		gamesTotalGain.setText("" + resources.get("Games").getCurrentSellPrice(currentPlanet)*sellMap.get("Games"));
		firearmsTotalGain.setText("" + resources.get("Firearms").getCurrentSellPrice(currentPlanet)*sellMap.get("Firearms"));
		medicineTotalGain.setText("" + resources.get("Medicine").getCurrentSellPrice(currentPlanet)*sellMap.get("Medicine"));
		machinesTotalGain.setText("" + resources.get("Machines").getCurrentSellPrice(currentPlanet)*sellMap.get("Machines"));
		narcoticsTotalGain.setText("" + resources.get("Narcotics").getCurrentSellPrice(currentPlanet)*sellMap.get("Narcotics"));
		robotsTotalGain.setText("" + resources.get("Robots").getCurrentSellPrice(currentPlanet)*sellMap.get("Robots"));
	}
	
	private void setTotalCostGain() {
		int waterCost = Integer.parseInt(waterTotalCost.getText());
		int furCost = Integer.parseInt(furTotalCost.getText());
		int foodCost = Integer.parseInt(foodTotalCost.getText());
		int oreCost = Integer.parseInt(oreTotalCost.getText());
		int gamesCost = Integer.parseInt(gamesTotalCost.getText());
		int firearmsCost = Integer.parseInt(firearmsTotalCost.getText());
		int medicineCost = Integer.parseInt(medicineTotalCost.getText());
		int machinesCost = Integer.parseInt(machinesTotalCost.getText());
		int narcoticsCost = Integer.parseInt(narcoticsTotalCost.getText());
		int robotsCost = Integer.parseInt(robotsTotalCost.getText());
		int totalcost = waterCost + furCost + foodCost + oreCost + gamesCost
				+ firearmsCost + medicineCost + machinesCost + narcoticsCost + robotsCost;
		totalCost.setText("" + totalcost);
		
		int waterGain = Integer.parseInt(waterTotalGain.getText());
		int furGain = Integer.parseInt(furTotalGain.getText());
		int foodGain = Integer.parseInt(foodTotalGain.getText());
		int oreGain = Integer.parseInt(oreTotalGain.getText());
		int gamesGain = Integer.parseInt(gamesTotalGain.getText());
		int firearmsGain = Integer.parseInt(firearmsTotalGain.getText());
		int medicineGain = Integer.parseInt(medicineTotalGain.getText());
		int machinesGain = Integer.parseInt(machinesTotalGain.getText());
		int narcoticsGain = Integer.parseInt(narcoticsTotalGain.getText());
		int robotsGain = Integer.parseInt(robotsTotalGain.getText());
		int totalgain = waterGain + furGain + foodGain + oreGain + gamesGain
				+ firearmsGain + medicineGain + machinesGain + narcoticsGain + robotsGain;
		totalGain.setText("" + totalgain);
		
		netGainLoss.setText("" + (totalgain - totalcost));
	}
	
	private void update() {
		setAmt();
		setCosts();
		setGains();
		setTotalCostGain();
	}
	
	private void setScreen() {
		mpTitle.setText(currentPlanet.name + " MarketPlace");
		setLabels();
		setPrices();
		update();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		fillMaps();
		setScreen();
	}
	@FXML
	private void onPressCancel(ActionEvent event) throws IOException {
	    Stage stage = (Stage) cancelButton.getScene().getWindow();
	    stage.close();
	}
	
	@FXML
	private void onPressCheckout(ActionEvent event) throws IOException {
		//add inetGainLoss to Player's money variable
		//set cargoArr to Cargo's individual amt variables with a for-loop
		Stage stage = (Stage) checkoutButton.getScene().getWindow();
	    stage.close();
	}
}


