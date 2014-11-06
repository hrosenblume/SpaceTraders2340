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
 * @author Stephen
 *
 */
public class ShipyardController implements Initializable {
	
	private Player player = Universe.player;
	private static Planet currentPlanet;
	
	@FXML
	private Button buyFlea, buyGnat, buyFirefly, buyMosquito, buyBumblebee,
	buyPulse, buyBeam, buyMilitary, buyEnergy, buyReflective, buyCargo, buyNav,
	buyRepair, buyTarget, buyCloak, exitButton;
	@FXML
	private Text currShip;
	
	/**
	 * Standard initialize method
	 * that sets the players buy abilities
	 */
	@Override
    public void initialize(URL url, ResourceBundle rb) {
		currShip.setText("Current Ship: " + player.getShip().name);
		enforcePrices();
		enforceTechLevel(currentPlanet.getTechLevel());
		enforceSlots();
    }
	
	private void enforcePrices() {
		if (player.getMoney() < 2000) {
			buyFlea.setDisable(true);
		}
		if (player.getMoney() < 10000) {
			buyGnat.setDisable(true);
		}
		if (player.getMoney() < 25000) {
			buyFirefly.setDisable(true);
		}
		if (player.getMoney() < 30000) {
			buyMosquito.setDisable(true);
		}
		if (player.getMoney() < 60000) {
			buyBumblebee.setDisable(true);
		}
		if (player.getMoney() < 5000) {
			buyPulse.setDisable(true);
		}
		if (player.getMoney() < 10000) {
			buyBeam.setDisable(true);
		}
		if (player.getMoney() < 25000) {
			buyMilitary.setDisable(true);
		}
		if (player.getMoney() < 10000) {
			buyEnergy.setDisable(true);
		}
		if (player.getMoney() < 20000) {
			buyReflective.setDisable(true);
		}
		if (player.getMoney() < 5000) {
			buyCargo.setDisable(true);
		}
		if (player.getMoney() < 15000) {
			buyNav.setDisable(true);
		}
		if (player.getMoney() < 15000) {
			buyRepair.setDisable(true);
		}
		if (player.getMoney() < 15000) {
			buyTarget.setDisable(true);
		}
		if (player.getMoney() < 30000) {
			buyCloak.setDisable(true);
		}
	}
	
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
	
	@FXML
	private void buyWeapon(ActionEvent event) throws IOException {
		Button clickedBtn = (Button) event.getSource(); // btn clicked
		String nameWeapon = clickedBtn.getId().substring(3).toLowerCase();
		player.getShip().addWeapon(nameWeapon);
		player.setMoney(player.getMoney() - Item.items.get(nameWeapon).getPrice());
		enforceSlots();
		enforcePrices();
	}
	
	@FXML
	private void buyShield(ActionEvent event) throws IOException {
		Button clickedBtn = (Button) event.getSource(); // btn clicked
		String nameShield = clickedBtn.getId().substring(3).toLowerCase();
		player.getShip().addShield(nameShield);
		player.setMoney(player.getMoney() - Item.items.get(nameShield).getPrice());
		enforceSlots();
		enforcePrices();
	}
	
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
	
	public static void setPlanet(Planet p) {
		currentPlanet = p;
	}
}
