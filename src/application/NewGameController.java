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
public class NewGameController implements Initializable {
    @FXML
    private Button pilotUp, pilotDown, fighterUp, fighterDown, traderUp,
            traderDown, engineerUp, engineerDown, investorUp, investorDown,
            cancelButton, playButton;
    @FXML
    private Text totalPoints, pilotSkillLabel, fighterSkillLabel,
            traderSkillLabel, engineerSkillLabel, investorSkillLabel;
    @FXML
    private TextField nameTextField;
    private int counter = 30;

    private static Player player;

    /**
     * Increases pilotSkillLabel
<<<<<<< HEAD
     * @param event pilotUp click
=======
     * 
     * @param event
     *            pilotUp click
>>>>>>> a6dd8ed23bf473ebe66d10204bc2583aa9f18a79
     * @throws IOException
     */
    @FXML
    private void increasePilot(ActionEvent event) throws IOException {
        incrementSkill(pilotSkillLabel);
    }
<<<<<<< HEAD
    
    /**
     * Decreases pilotSkillLabel
     * @param event pilotDown click
=======

    /**
     * Decreases pilotSkillLabel
     * 
     * @param event
     *            pilotDown click
>>>>>>> a6dd8ed23bf473ebe66d10204bc2583aa9f18a79
     * @throws IOException
     */
    @FXML
    private void decreasePilot(ActionEvent event) throws IOException {
        decrementSkill(pilotSkillLabel);
    }
<<<<<<< HEAD
    
    /**
     * Increases fighterSkillLabel
     * @param event fighterUp click
=======

    /**
     * Increases fighterSkillLabel
     * 
     * @param event
     *            fighterUp click
>>>>>>> a6dd8ed23bf473ebe66d10204bc2583aa9f18a79
     * @throws IOException
     */
    @FXML
    private void increaseFighter(ActionEvent event) throws IOException {
        incrementSkill(fighterSkillLabel);
    }
<<<<<<< HEAD
    
    /**
     * Decreases fighterSkillLabel
     * @param event fighterDown click
=======

    /**
     * Decreases fighterSkillLabel
     * 
     * @param event
     *            fighterDown click
>>>>>>> a6dd8ed23bf473ebe66d10204bc2583aa9f18a79
     * @throws IOException
     */
    @FXML
    private void decreaseFighter(ActionEvent event) throws IOException {
        decrementSkill(fighterSkillLabel);
    }
<<<<<<< HEAD
    
    /**
     * Increases traderSkillLabel
     * @param event traderUp click
=======

    /**
     * Increases traderSkillLabel
     * 
     * @param event
     *            traderUp click
>>>>>>> a6dd8ed23bf473ebe66d10204bc2583aa9f18a79
     * @throws IOException
     */
    @FXML
    private void increaseTrader(ActionEvent event) throws IOException {
        incrementSkill(traderSkillLabel);
    }
<<<<<<< HEAD
    
    /**
     * Decreases traderSkillLabel
     * @param event traderDown click
=======

    /**
     * Decreases traderSkillLabel
     * 
     * @param event
     *            traderDown click
>>>>>>> a6dd8ed23bf473ebe66d10204bc2583aa9f18a79
     * @throws IOException
     */
    @FXML
    private void decreaseTrader(ActionEvent event) throws IOException {
        decrementSkill(traderSkillLabel);
    }
<<<<<<< HEAD
    
    /**
     * Increases engineerSkillLabel
     * @param event engineerUp click
=======

    /**
     * Increases engineerSkillLabel
     * 
     * @param event
     *            engineerUp click
>>>>>>> a6dd8ed23bf473ebe66d10204bc2583aa9f18a79
     * @throws IOException
     */
    @FXML
    private void increaseEngineer(ActionEvent event) throws IOException {
        incrementSkill(engineerSkillLabel);
    }
<<<<<<< HEAD
    
    /**
     * Decreases engineerSkillLabel
     * @param event engineerDown click
=======

    /**
     * Decreases engineerSkillLabel
     * 
     * @param event
     *            engineerDown click
>>>>>>> a6dd8ed23bf473ebe66d10204bc2583aa9f18a79
     * @throws IOException
     */
    @FXML
    private void decreaseEngineer(ActionEvent event) throws IOException {
        decrementSkill(engineerSkillLabel);
    }
<<<<<<< HEAD
    
    /**
     * Increases investorSkillLabel
     * @param event investorUp click
=======

    /**
     * Increases investorSkillLabel
     * 
     * @param event
     *            investorUp click
>>>>>>> a6dd8ed23bf473ebe66d10204bc2583aa9f18a79
     * @throws IOException
     */
    @FXML
    private void increaseInvestor(ActionEvent event) throws IOException {
        incrementSkill(investorSkillLabel);
    }
<<<<<<< HEAD
    
    /**
     * Decreases investorSkillLabel
     * @param event investorDown click
=======

    /**
     * Decreases investorSkillLabel
     * 
     * @param event
     *            investorDown click
>>>>>>> a6dd8ed23bf473ebe66d10204bc2583aa9f18a79
     * @throws IOException
     */
    @FXML
    private void decreaseInvestor(ActionEvent event) throws IOException {
        decrementSkill(investorSkillLabel);
    }

    /**
     * Increases a skill (if possible).
     * 
     * @param thisLabel
     *            the skill to be incremented.
     */
    private void incrementSkill(Text thisLabel) {
        if (counter > 0) {
            String currentSkill = thisLabel.getText();
            int currentSkillNum = Integer.parseInt(currentSkill);
            int newSkillNum = currentSkillNum + 1;
            counter--;
            String newSkill = "" + newSkillNum;
            thisLabel.setText(newSkill);
            totalPoints.setText("" + counter);
        }
    }

    /**
     * Decreases a skill (if possible).
     * 
     * @param thisLabel
     *            the skill to be decremented.
     */
    private void decrementSkill(Text thisLabel) {
        if (counter < 30) {
            String currentSkill = thisLabel.getText();
            int currentSkillNum = Integer.parseInt(currentSkill);
            int newSkillNum = currentSkillNum;
            if (currentSkillNum > 0) {
                newSkillNum = currentSkillNum - 1;
                counter++;
            }
            String newSkill = "" + newSkillNum;
            thisLabel.setText(newSkill);
            totalPoints.setText("" + counter);
        }
    }

    /**
     * Closes New Game screen
<<<<<<< HEAD
     * @param event cancelButton click
=======
     * 
     * @param event
     *            cancelButton click
>>>>>>> a6dd8ed23bf473ebe66d10204bc2583aa9f18a79
     * @throws IOException
     */
    @FXML
    private void onPressCancel(ActionEvent event) throws IOException {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
<<<<<<< HEAD
    
    /**
     * Opens window for first Planet display
     * @param event playButton click
=======

    /**
     * Opens window for first Planet display
     * 
     * @param event
     *            playButton click
>>>>>>> a6dd8ed23bf473ebe66d10204bc2583aa9f18a79
     * @throws IOException
     */
    @FXML
    private void onPressPlay(ActionEvent event) throws IOException {
        // if (player != null) {
        // player = createPlayer(); // creates player in model
        // }
        player = createPlayer();
        Universe universe = createUniverse();
        universe.setPlayer(player);

        Parent root =
                FXMLLoader.load(getClass().getResource(
                        "../view/UniverseDisplay.fxml"));
        Stage newStage = new Stage();
        newStage.setScene(new Scene(root, 750, 500));
        newStage.show();

        // for testing purposes, it puts you on a random planet when you start
        // the game
        PlanetController.setPlanet(Universe.universe[(new java.util.Random())
                .nextInt(50)]);
        root =
                FXMLLoader.load(getClass().getResource(
                        "../view/PlanetDisplay.fxml"));
        newStage = new Stage();
        newStage.setScene(new Scene(root, 500, 500));
        newStage.show();
        // end of testing block

        Stage oldStage = (Stage) playButton.getScene().getWindow();
        oldStage.close();
    }

    @FXML
    /**
     * Creates a player based on the selected values.
     * @return a character with the specified name and skills.
     */
    private Player createPlayer() {
        String name = nameTextField.getText();
        int pilot = Integer.parseInt(pilotSkillLabel.getText());
        int fighter = Integer.parseInt(fighterSkillLabel.getText());
        int trader = Integer.parseInt(traderSkillLabel.getText());
        int engineer = Integer.parseInt(engineerSkillLabel.getText());
        int investor = Integer.parseInt(investorSkillLabel.getText());
        Player player =
                new Player(name, pilot, fighter, trader, engineer, investor);

        // for testing
        System.out.println("name: " + name);
        System.out.println("pilot skill: " + pilot);
        System.out.println("fighter skill: " + fighter);
        System.out.println("trader skill: " + trader);
        System.out.println("engineer skill: " + engineer);
        System.out.println("investor skill: " + investor);

        return player;
    }

    /**
     * Generates the playable Universe.
     * 
     * @return the created Universe.
     */
    private Universe createUniverse() {
        Universe universe = new Universe();

        /*
         * // for testing System.out.println(universe);
         * System.out.println("------"); System.out.println("Current uni: " +
         * universe.universe[0]); for (Planet p:
         * universe.getNearbyPlanets(universe.universe[0])) {
         * System.out.println(p); }
         * //System.out.println(universe.getNearbyPlanets
         * (universe.universe[2]));
         */return universe;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        if (player != null) {
            Universe universe = createUniverse();
            universe.setPlayer(player);
            try {
                Parent root =
                        FXMLLoader.load(getClass().getResource(
                                "../view/UniverseDisplay.fxml"));
                Stage newStage = new Stage();
                newStage.setScene(new Scene(root, 750, 500));
                newStage.show();

                // for testing purposes, it puts you on a random planet when you
                // start the game
                PlanetController
                        .setPlanet(Universe.universe[(new java.util.Random())
                                .nextInt(50)]);
                root =
                        FXMLLoader.load(getClass().getResource(
                                "../view/PlanetDisplay.fxml"));
                newStage = new Stage();
                newStage.setScene(new Scene(root, 500, 500));
                newStage.show();

                System.out.println("You are now playing with: "
                        + player.getName());
            } catch (Exception e) {
                System.out.println(e);
            }

<<<<<<< HEAD
    		//end of testing block
    	}
    }  
    
    /**
     * Returns the static player variable
     * @return player 
=======
            // end of testing block
        }
    }

    /**
     * Returns the static player variable
     * 
     * @return player
>>>>>>> a6dd8ed23bf473ebe66d10204bc2583aa9f18a79
     */
    public static Player getPlayer() {
        return player;
    }
<<<<<<< HEAD
    
    /**
     * Sets the player variable in the NewGameController
     * @param aPlayer player variable
=======

    /**
     * Sets the player variable in the NewGameController
     * 
     * @param aPlayer
     *            player variable
>>>>>>> a6dd8ed23bf473ebe66d10204bc2583aa9f18a79
     */
    public static void setPlayer(Player aPlayer) {
        player = aPlayer;
    }
}
