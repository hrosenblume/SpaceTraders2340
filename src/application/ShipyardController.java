package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Controls the shipyard.
 * 
 * @author Stephen
 *
 */
public class ShipyardController implements Initializable {

    private Player player = Universe.player;
    private static Planet currentPlanet;
    private boolean adjusted = false;

    @FXML
    private Button buyFlea, buyGnat, buyFirefly, buyMosquito, buyBumblebee,
            buyPulse, buyBeam, buyMilitary, buyEnergy, buyReflective, buyCargo,
            buyNav, buyRepair, buyTarget, buyCloak, exitButton;
    @FXML
    private Text currShip;

    /**
     * Standard initialize method that sets the players buy abilities
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        currShip.setText("Current Ship: " + player.getShip().name);
        if (!adjusted) {
        	adjustPrices();
        }
        setLabels();
        enforcePrices();
        enforceTechLevel(currentPlanet.getTechLevel());
        enforceSlots();
    }

    /**
     * Set the prices of each ship based on the player's pilot level
     */
    private void adjustPrices() {
    	for (Ship s: Ship.ships.values()) {
    		s.price *= (1 - (Universe.player.getPilot() / 100.0));
    		Ship.ships.put(s.name, s);
    	}
    	adjusted = true;
    }
    
    /**
     * Sets up appropriate labels for the prices
     */
    private void setLabels() {
    	buyFlea.setText("Purchase: " + Ship.ships.get("flea").price);
    	buyGnat.setText("Purchase: " + Ship.ships.get("gnat").price);
    	buyFirefly.setText("Purchase: " + Ship.ships.get("firefly").price);
    	buyMosquito.setText("Purchase: " + Ship.ships.get("mosquito").price);
    	buyBumblebee.setText("Purchase: " + Ship.ships.get("bumblebee").price);
    	buyPulse.setText("Purchase: " + Item.items.get("pulse").getPrice());
    	buyBeam.setText("Purchase: " + Item.items.get("beam").getPrice());
    	buyMilitary.setText("Purchase: " + Item.items.get("military").getPrice());
    	buyEnergy.setText("Purchase: " + Item.items.get("energy").getPrice());
    	buyReflective.setText("Purchase: " + Item.items.get("reflective").getPrice());
    	buyCargo.setText("Purchase: " + Item.items.get("cargo").getPrice());
    	buyNav.setText("Purchase: " + Item.items.get("nav").getPrice());
    	buyRepair.setText("Purchase: " + Item.items.get("repair").getPrice());
    	buyTarget.setText("Purchase: " + Item.items.get("target").getPrice());
    	buyCloak.setText("Purchase: " + Item.items.get("cloak").getPrice());
    }
    
	/**
	 * Enables and disables buttons according to prices.
	 */
	private void enforcePrices() {
		if (player.getMoney() < 2000 * (1 - (Universe.player.getPilot() / 100.0))) {
			buyFlea.setDisable(true);
		}
		if (player.getMoney() < 10000 * (1 - (Universe.player.getPilot() / 100.0))) {
			buyGnat.setDisable(true);
		}
		if (player.getMoney() < 25000 * (1 - (Universe.player.getPilot() / 100.0))) {
			buyFirefly.setDisable(true);
		}
		if (player.getMoney() < 30000 * (1 - (Universe.player.getPilot() / 100.0))) {
			buyMosquito.setDisable(true);
		}
		if (player.getMoney() < 60000 * (1 - (Universe.player.getPilot() / 100.0))) {
			buyBumblebee.setDisable(true);
		}
		if (player.getMoney() < 5000 * (1 - (Universe.player.getFighter() / 100.0))) {
			buyPulse.setDisable(true);
		}
		if (player.getMoney() < 10000 * (1 - (Universe.player.getFighter() / 100.0))) {
			buyBeam.setDisable(true);
		}
		if (player.getMoney() < 25000 * (1 - (Universe.player.getFighter() / 100.0))) {
			buyMilitary.setDisable(true);
		}
		if (player.getMoney() < 10000 * (1 - (Universe.player.getFighter() / 100.0))) {
			buyEnergy.setDisable(true);
		}
		if (player.getMoney() < 20000 * (1 - (Universe.player.getFighter() / 100.0))) {
			buyReflective.setDisable(true);
		}
		if (player.getMoney() < 5000 * (1 - (Universe.player.getEngineer() / 100.0))) {
			buyCargo.setDisable(true);
		}
		if (player.getMoney() < 15000 * (1 - (Universe.player.getEngineer() / 100.0))) {
			buyNav.setDisable(true);
		}
		if (player.getMoney() < 15000 * (1 - (Universe.player.getEngineer() / 100.0))) {
			buyRepair.setDisable(true);
		}
		if (player.getMoney() < 15000 * (1 - (Universe.player.getEngineer() / 100.0))) {
			buyTarget.setDisable(true);
		}
		if (player.getMoney() < 30000 * (1 - (Universe.player.getEngineer() / 100.0))) {
			buyCloak.setDisable(true);
		}
	}
	
	/**
	 * Disables buttons based on tech level requirements.
	 * @param techLevel the tech level of the planet.
	 */
	private void enforceTechLevel(int techLevel) {
		if (techLevel < 7) {
			buyBumblebee.setDisable(true);
			buyMilitary.setDisable(true);
			buyReflective.setDisable(true);
			buyCloak.setDisable(true);
		}
		if (techLevel < 6) {
			buyFirefly.setDisable(true);
			buyMosquito.setDisable(true);
			buyBeam.setDisable(true);
			buyTarget.setDisable(true);
		}
		if (techLevel < 5) {
			buyGnat.setDisable(true);
			buyPulse.setDisable(true);
			buyRepair.setDisable(true);
		}
	}
	
	/**
	 * Disables buttons based on the ship's available slots.
	 */
	private void enforceSlots() {
		int numWeapons = 0;
		for (String name: player.getShip().getWeapons().keySet()) {
			numWeapons += player.getShip().getWeapons().get(name);
		}
		if (player.getShip().weaponSlots <= numWeapons) {
			buyPulse.setDisable(true);
			buyBeam.setDisable(true);
			buyMilitary.setDisable(true);
		}
		
		int numShields = 0;
		for (String name: player.getShip().getShields().keySet()) {
			numShields += player.getShip().getShields().get(name);
		}
		if (player.getShip().shieldSlots <= numShields) {
			buyEnergy.setDisable(true);
			buyReflective.setDisable(true);
		}
		
		int numGadgets = 0;
		for (String name: player.getShip().getGadgets().keySet()) {
			numGadgets += player.getShip().getGadgets().get(name);
		}
		if (player.getShip().gadgetSlots <= numGadgets) {
			buyNav.setDisable(true);
			buyRepair.setDisable(true);
			buyTarget.setDisable(true);
			buyCloak.setDisable(true);
		}
	}
	
	/**
	 * Adds appropriate weapon to player's ship
	 * @param event weapon button click
	 * @throws IOException
	 */
	@FXML
	private void buyWeapon(ActionEvent event) throws IOException {
		Button clickedBtn = (Button) event.getSource(); // btn clicked
		String nameWeapon = clickedBtn.getId().substring(3).toLowerCase();
		player.getShip().addWeapon(nameWeapon);
		player.setMoney(player.getMoney() - Item.items.get(nameWeapon).getPrice());
		enforceSlots();
		enforcePrices();
	}
	
	/**
	 * Adds appropriate shield to player's ship
	 * @param event shield button click
	 * @throws IOException
	 */
	@FXML
	private void buyShield(ActionEvent event) throws IOException {
		Button clickedBtn = (Button) event.getSource(); // btn clicked
		String nameShield = clickedBtn.getId().substring(3).toLowerCase();
		player.getShip().addShield(nameShield);
		player.setMoney(player.getMoney() - Item.items.get(nameShield).getPrice());
		enforceSlots();
		enforcePrices();
	}
	
	/**
	 * Adds appropriate gadget to player's ship
	 * @param event gadget button click
	 * @throws IOException
	 */
	@FXML
	private void buyGadget(ActionEvent event) throws IOException {
		Button clickedBtn = (Button) event.getSource(); // btn clicked
		String nameGadget = clickedBtn.getId().substring(3).toLowerCase();
		player.getShip().addGadget(nameGadget);
		player.setMoney(player.getMoney() - Item.items.get(nameGadget).getPrice());
		enforceSlots();
		enforcePrices();
	}
	
	/**
	 * Button click listener that buys ship
	 * @param event button click
	 * @throws IOException issues
	 */
	@FXML
	private void buyShip(ActionEvent event) throws IOException {
		Button clickedBtn = (Button) event.getSource(); // btn clicked
		String nameShip = clickedBtn.getId().substring(3).toLowerCase();
		Ship purchasedShip = Ship.ships.get(nameShip);
		player.setShip(purchasedShip);
		player.setMoney(player.getMoney() - purchasedShip.price);
		Stage stage = (Stage) clickedBtn.getScene().getWindow();
	    stage.close();
	}
	
	/**
	 * Button click listener for exit
	 * @param event button click
	 * @throws IOException issues
	 */
	@FXML
	private void onPressExit(ActionEvent event) throws IOException {
	    Stage stage = (Stage) exitButton.getScene().getWindow();
	    stage.close();
	}
	
	/**
	 * Sets the planet.
	 * @param p the planet to set.
	 */
	public static void setPlanet(Planet p) {
		currentPlanet = p;
	}
}
