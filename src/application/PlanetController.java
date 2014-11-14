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
 * 
 * @author Hunter Rosenblume, Naman Shah, Stephen Song, Bhavesh Suhagia, Pranil
 *         Vora
 */
public class PlanetController implements Initializable {
    static Planet currentPlanet;
    @FXML
    private Text planetName, planetInfo;
    @FXML
    private Button mpButton, travelButton, shipButton;
    
    /**
     * Sets the current Planet
     * @param p the current Planet
     */
    public static void setPlanet(Planet p) {
        currentPlanet = p;
    }

    /**
     * Retrieves all information about the current planet
     * 
     * @return a String representation of all the info
     */
    private String getInfo() {
        String str = "";
        str +=
                "Location: (" + (int) currentPlanet.planetLocation.getX()
                        + ", " + (int) currentPlanet.planetLocation.getY()
                        + ")\n";
        str += "Tech Level: " + currentPlanet.planetTechLevel + "\n";
        str += "Resource: " + currentPlanet.planetResource + "\n";
        str += "Special Condition: " + "not implemented yet" + "\n";
        str +=
                "Police Intesity: "
                        + this.infoHelper(currentPlanet.policeIntensity) + "\n";
        str +=
                "Piracy Level: " + this.infoHelper(currentPlanet.piracyLevel)
                        + "\n";
        return str;
    }

    /**
     * Helper method that puts a qualitative name on an integer level
     * 
     * @param level
     *            an quantitative representation of police/pirate presence
     * @return a String describing the level
     */
    private String infoHelper(int level) {
        if (level < 2) {
            return "Scarce";
        } else if (level > 3) {
            return "Abundant";
        } else {
            return "Moderate";
        }
    }

    /**
     * Opens a MarketPlace window for the current planet
     * 
     * @param event
     *            mpButton click
     * @throws IOException
     */
    @FXML
    private void onPressMarketPlace(ActionEvent event) throws IOException {
        NewMarketController.setPlanet(currentPlanet);
        Parent root =
                FXMLLoader.load(getClass().getResource(
                        "../view/MarketDisplay.fxml"));
        Stage newStage = new Stage();
        newStage.setScene(new Scene(root, 700, 700));
        newStage.show();
    }

    /**
     * Opens a NearbyPlanet window for the current planet
     * 
     * @param event
     *            travelButton click
     * @throws IOException
     */
    @FXML
    private void onPressTravel(ActionEvent event) throws IOException {
        Parent root =
                FXMLLoader.load(getClass().getResource(
                        "../view/NearbyPlanetScreen.fxml"));
        Stage newStage = new Stage();
        newStage.setScene(new Scene(root, 700, 700));
        newStage.show();
    }

    /**
     * Opens a Shipyard window for the current planet
     * 
     * @param event
     *            shipButton
     * @throws IOException
     */
    @FXML
    private void onPressShipyard(ActionEvent event) throws IOException {
        ShipyardController.setPlanet(currentPlanet);
        Parent root =
                FXMLLoader.load(getClass().getResource(
                        "../view/ShipyardDisplay.fxml"));
        Stage newStage = new Stage();
        newStage.setScene(new Scene(root, 600, 400));
        newStage.show();
    }

    // find method that happens when all fxml elements are loaded
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        planetName.setText(currentPlanet.name);
        planetInfo.setText(this.getInfo());
        if (currentPlanet != null) {
            shipButton.setDisable(currentPlanet.getTechLevel() < 4);
        }
    }
}
