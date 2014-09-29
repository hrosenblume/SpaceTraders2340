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
	
	// a "shopping cart" for the resources to buy
	private HashMap<String, Integer> buyMap = new HashMap<String, Integer>();
	private HashMap<String, Integer> sellMap = new HashMap<String, Integer>();
	
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
	
	/**
	 * Initializes the shopping cart with the resources and their amounts.
	 */
	private void fillMaps() {
		String[] resources = {"Water", "Fur", "Food", "Ore", "Games",
				  "Firearms", "Medicine", "Machines",
				  "Narcotics", "Robots"};
		for (int x = 0; x < resources.length; x++) {
			buyMap.put(resources[x], 0);
			sellMap.put(resources[x], 0);
		}
	}
	
	/**
	 * Sets the labels for each resource.
	 */
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
	
	/**
	 * Sets the displayed buy and sell prices.
	 */
	private void setPrices() {
		buyWaterPrice.setText("" + currentPlanet.marketplace.getBuyPrice("Water"));
		buyFurPrice.setText("" + currentPlanet.marketplace.getBuyPrice("Fur"));
		buyFoodPrice.setText("" + currentPlanet.marketplace.getBuyPrice("Food"));
		buyOrePrice.setText("" + currentPlanet.marketplace.getBuyPrice("Ore"));
		buyGamesPrice.setText("" + currentPlanet.marketplace.getBuyPrice("Games"));
		buyFirearmsPrice.setText("" + currentPlanet.marketplace.getBuyPrice("Firearms"));
		buyMedicinePrice.setText("" + currentPlanet.marketplace.getBuyPrice("Medicine"));
		buyMachinesPrice.setText("" + currentPlanet.marketplace.getBuyPrice("Machines"));
		buyNarcoticsPrice.setText("" + currentPlanet.marketplace.getBuyPrice("Narcotics"));
		buyRobotsPrice.setText("" + currentPlanet.marketplace.getBuyPrice("Robots"));
		
		sellWaterPrice.setText("" + currentPlanet.marketplace.getSellPrice("Water"));
		sellFurPrice.setText("" + currentPlanet.marketplace.getSellPrice("Fur"));
		sellFoodPrice.setText("" + currentPlanet.marketplace.getSellPrice("Food"));
		sellOrePrice.setText("" + currentPlanet.marketplace.getSellPrice("Ore"));
		sellGamesPrice.setText("" + currentPlanet.marketplace.getSellPrice("Games"));
		sellFirearmsPrice.setText("" + currentPlanet.marketplace.getSellPrice("Firearms"));
		sellMedicinePrice.setText("" + currentPlanet.marketplace.getSellPrice("Medicine"));
		sellMachinesPrice.setText("" + currentPlanet.marketplace.getSellPrice("Machines"));
		sellNarcoticsPrice.setText("" + currentPlanet.marketplace.getSellPrice("Narcotics"));
		sellRobotsPrice.setText("" + currentPlanet.marketplace.getSellPrice("Robots"));
	}
	
	/**
	 * Sets the amount of resources in each shopping cart.
	 */
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
	
	/**
	 * Sets the total buy price given the cost per resource.
	 */
	private void setCosts() {
		waterTotalCost.setText("" + currentPlanet.marketplace.getBuyPrice("Water") * buyMap.get("Water"));
		furTotalCost.setText("" + currentPlanet.marketplace.getBuyPrice("Fur") * buyMap.get("Fur"));
		foodTotalCost.setText("" + currentPlanet.marketplace.getBuyPrice("Food") * buyMap.get("Food"));
		oreTotalCost.setText("" + currentPlanet.marketplace.getBuyPrice("Ore") * buyMap.get("Ore"));
		gamesTotalCost.setText("" + currentPlanet.marketplace.getBuyPrice("Games") * buyMap.get("Games"));
		firearmsTotalCost.setText("" + currentPlanet.marketplace.getBuyPrice("Firearms") * buyMap.get("Firearms"));
		medicineTotalCost.setText("" + currentPlanet.marketplace.getBuyPrice("Medicine") * buyMap.get("Medicine"));
		machinesTotalCost.setText("" + currentPlanet.marketplace.getBuyPrice("Machines") * buyMap.get("Machines"));
		narcoticsTotalCost.setText("" + currentPlanet.marketplace.getBuyPrice("Narcotics") * buyMap.get("Narcotics"));
		robotsTotalCost.setText("" + currentPlanet.marketplace.getBuyPrice("Robots") * buyMap.get("Robots"));
	}
	
	/**
	 * Sets the total sale price given the cost per resource.
	 */
	private void setGains() {
		waterTotalGain.setText("" + currentPlanet.marketplace.getSellPrice("Water") * sellMap.get("Water"));
		furTotalGain.setText("" + currentPlanet.marketplace.getSellPrice("Fur") * sellMap.get("Fur"));
		foodTotalGain.setText("" + currentPlanet.marketplace.getSellPrice("Food") * sellMap.get("Food"));
		oreTotalGain.setText("" + currentPlanet.marketplace.getSellPrice("Ore") * sellMap.get("Ore"));
		gamesTotalGain.setText("" + currentPlanet.marketplace.getSellPrice("Games") * sellMap.get("Games"));
		firearmsTotalGain.setText("" + currentPlanet.marketplace.getSellPrice("Firearms") * sellMap.get("Firearms"));
		medicineTotalGain.setText("" + currentPlanet.marketplace.getSellPrice("Medicine") * sellMap.get("Medicine"));
		machinesTotalGain.setText("" + currentPlanet.marketplace.getSellPrice("Machines") * sellMap.get("Machines"));
		narcoticsTotalGain.setText("" + currentPlanet.marketplace.getSellPrice("Narcotics") * sellMap.get("Narcotics"));
		robotsTotalGain.setText("" + currentPlanet.marketplace.getSellPrice("Robots") * sellMap.get("Robots"));
	}
	
	/**
	 * Sets the total costs and gains from the transaction overall.
	 */
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


