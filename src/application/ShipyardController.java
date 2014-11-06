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
    }
	
	@FXML
	private void buyWeapon(ActionEvent event) throws IOException {
		Button clickedBtn = (Button) event.getSource(); // btn clicked
		String nameWeapon = clickedBtn.getId().substring(3).toLowerCase();
		player.getShip().addWeapon(nameWeapon);
	}
	
	@FXML
	private void buyShield(ActionEvent event) throws IOException {
		Button clickedBtn = (Button) event.getSource(); // btn clicked
		String nameShield = clickedBtn.getId().substring(3).toLowerCase();
		player.getShip().addShield(nameShield);
	}
	
	@FXML
	private void buyGadget(ActionEvent event) throws IOException {
		Button clickedBtn = (Button) event.getSource(); // btn clicked
		String nameGadget = clickedBtn.getId().substring(3).toLowerCase();
		player.getShip().addGadget(nameGadget);
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
}
