package application;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Manages the character creation dialog.
 * @author Hunter Rosenblume, Naman Shah, Stephen Song, Bhavesh Suhagia, Pranil Vora
 */
public class PlanetController implements Initializable {
    static Planet currentPlanet;
    @FXML
    private Text planetName, planetInfo;
    @FXML
    private Button mpButton;
    
    public static void setPlanet(Planet p) {
    	currentPlanet = p;
    }
    
    private String getInfo() {
		String str = "";
		str += "Location: (" + (int)currentPlanet.planetLocation.getX() + ", "
			+ (int)currentPlanet.planetLocation.getY() + ")\n";
		str += "Tech Level: " + currentPlanet.planetTechLevel + "\n";
		str += "Resource: " + currentPlanet.planetResource + "\n";
		str += "Special Condition: " + "not implemented yet" + "\n";
		str += "Police Intesity: "
				+ this.infoHelper(currentPlanet.policeIntensity) + "\n";
		str += "Piracy Level: " 
				+ this.infoHelper(currentPlanet.piracyLevel) + "\n";
		return str;
	}
	
	private String infoHelper(int level) {
		if (level < 2) {
			return "Scarce";
		} else if (level > 3) {
			return "Abundant";
		} else {
			return "Moderate";
		}
	}
	
	@FXML
	private void onPressMarketPlace(ActionEvent event) throws IOException {
		MarketController.setPlanet(currentPlanet);
		Parent root = FXMLLoader.load(getClass().getResource("../view/MarketDisplay.fxml"));
		Stage newStage = new Stage();
		newStage.setScene(new Scene(root, 700, 700));
		newStage.show();
	}
	
	//find method that happens when all fxml elements are loaded
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    	planetName.setText(currentPlanet.name);
    	planetInfo.setText(this.getInfo());
    }  
}
    

