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
	private Button buyFlea, buyGnat, buyFirefly, buyMosquito, buyBumblebee, exitButton;
	@FXML
	private Text currShip;
	
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
	private void buyShip(ActionEvent event) throws IOException {
		Button clickedBtn = (Button) event.getSource(); // btn clicked
		String nameShip = clickedBtn.getId().substring(3).toLowerCase();
		Ship purchasedShip = Ship.ships.get(nameShip);
		player.setShip(purchasedShip);
		player.setMoney(player.getMoney() - purchasedShip.price);
		Stage stage = (Stage) clickedBtn.getScene().getWindow();
	    stage.close();
	}
	
	@FXML
	private void onPressExit(ActionEvent event) throws IOException {
	    Stage stage = (Stage) exitButton.getScene().getWindow();
	    stage.close();
	}
}
