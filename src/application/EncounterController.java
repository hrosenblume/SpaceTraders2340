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

import java.util.Random;

/**
 * Controls the logic behind random encounters.
 * 
 * @author Stephen
 */
public class EncounterController implements Initializable {
    @FXML
    private Button okayButton;
    @FXML
    private Text planetToPlanet, randomEvent, encounterResult, fuelLeft;
    static Planet lastPlanet, nextPlanet;

    /**
     * Sets the planets the player is traveling between.
     * 
     * @param lp
     *            the planet the player is traveling from.
     * @param np
     *            the planet the player is traveling to.
     */
    public static void setPlanets(Planet lp, Planet np) {
        lastPlanet = lp;
        nextPlanet = np;
    }

    /**
     * Closes the window
     * 
     * @param event
     *            okayButton click
     * @throws IOException
     */
    @FXML
    private void buttonOK(ActionEvent event) throws IOException {
        Stage stage = (Stage) okayButton.getScene().getWindow();
        stage.close();
    }

    /**
     * Updates the travel label.
     */
    private void updateTravelInfo() {
        planetToPlanet.setText(lastPlanet.getName() + " --> "
                + nextPlanet.getName());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        updateTravelInfo();
        updateFuel();
        generateEvent();
    }

    /**
     * Updates the fuel label.
     */
    private void updateFuel() {
        fuelLeft.setText("Fuel left: " + Universe.player.getFuel());

    }

    /**
     * Generates and processes a random event.
     */
    private void generateEvent() {
        String event = pickEvent();
        String eventDescription = "";
        String resultDescription = "";
        Random numGen = new Random();
        switch (event) {
        case "Police":
            eventDescription =
                    "The police have searched your ship and seized contraband!";
            int moneyChange = numGen.nextInt(1000);
            Universe.player.setMoney(Universe.player.getMoney() - moneyChange);
            resultDescription = "Money: -" + moneyChange;
            break;
        case "Pirate":
            eventDescription = "A pirate attacked your ship and robbed you!";
            int moneyChange2 = numGen.nextInt(2000);
            Universe.player.setMoney(Universe.player.getMoney() - moneyChange2);
            resultDescription = "Money: -" + moneyChange2;
            break;
        case "Lottery":
            eventDescription = "You won the galactic lottery!";
            int moneyChange3 = numGen.nextInt(5000);
            Universe.player.setMoney(Universe.player.getMoney() + moneyChange3);
            resultDescription = "Money: +" + moneyChange3;
            break;
        case "Asteroid":
            eventDescription =
                    "Your ship hit an asteroid! Some machine parts were used in the repair.";
            int machineChange = numGen.nextInt(500);
            resultDescription = "Machines: -" + machineChange;
            break;
        case "DiscoverRobots":
            eventDescription = "You found high-value robot parts!";
            int robotsChange = numGen.nextInt(100);
            resultDescription = "Robots: +" + robotsChange;
            break;
        case "DiscoverMoney":
            eventDescription =
                    "You found money randomly floating in space, which literally never happens!";
            int moneyChange4 = numGen.nextInt(3000);
            Universe.player.setMoney(Universe.player.getMoney() + moneyChange4);
            resultDescription = "Money: +" + moneyChange4;
            break;
        }
        randomEvent.setText(eventDescription);
        encounterResult.setText(resultDescription);
    }

    /**
     * Picks a random event to process.
     * 
     * @return the text representation of the event being done.
     */
    private String pickEvent() {
        Random rand = new Random();
        String encounter = "";
        int probability = rand.nextInt(10);
        if (probability <= 5) {
            encounter = "PolicePirate";
        } else {
            encounter = "RandomEvent";
        }

        if (encounter.equals("PolicePirate")) {
            String policeOrPirate = "";
            probability = rand.nextInt(6);
            if (probability < nextPlanet.policeIntensity()) {
                encounter = "Police";
            } else {
                encounter = "Pirate";
            }
        } else if (encounter.equals("RandomEvent")) {
            String arr[] = new String[4];
            arr[0] = "Lottery";
            arr[1] = "Asteroid";
            arr[2] = "DiscoverMoney";
            arr[3] = "DiscoverRobots";
            int prob = rand.nextInt(4);
            encounter = arr[prob];
        }
        return encounter;
    }
}
