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
public class NewGameController implements Initializable {
    @FXML
    private Button pilotUp, pilotDown, fighterUp, fighterDown, traderUp, traderDown,
    	engineerUp, engineerDown, investorUp, investorDown, cancelButton, playButton;
    @FXML
    private Text totalPoints, pilotSkillLabel, fighterSkillLabel, traderSkillLabel,
    	engineerSkillLabel, investorSkillLabel;
    @FXML
    private TextField nameTextField;
    private int counter = 30;

    @FXML
    private void increasePilot(ActionEvent event) throws IOException {
        incrementSkill(pilotSkillLabel);
    }
    @FXML
    private void decreasePilot(ActionEvent event) throws IOException {
        decrementSkill(pilotSkillLabel);
    }
    @FXML
    private void increaseFighter(ActionEvent event) throws IOException {
        incrementSkill(fighterSkillLabel);
    }
    @FXML
    private void decreaseFighter(ActionEvent event) throws IOException {
        decrementSkill(fighterSkillLabel);
    }
    @FXML
    private void increaseTrader(ActionEvent event) throws IOException {
        incrementSkill(traderSkillLabel);
    }
    @FXML
    private void decreaseTrader(ActionEvent event) throws IOException {
        decrementSkill(traderSkillLabel);
    }
    @FXML
    private void increaseEngineer(ActionEvent event) throws IOException {
        incrementSkill(engineerSkillLabel);
    }
    @FXML
    private void decreaseEngineer(ActionEvent event) throws IOException {
        decrementSkill(engineerSkillLabel);
    }
    @FXML
    private void increaseInvestor(ActionEvent event) throws IOException {
        incrementSkill(investorSkillLabel);
    }
    @FXML
    private void decreaseInvestor(ActionEvent event) throws IOException {
        decrementSkill(investorSkillLabel);
    }

    /**
     * Increases a skill (if possible).
     * @param thisLabel the skill to be incremented.
     */
    private void incrementSkill(Text thisLabel) {
        if(counter > 0) {
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
     * @param thisLabel the skill to be decremented.
     */
    private void decrementSkill(Text thisLabel) {
        if(counter < 30) {
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

    @FXML
    private void onPressCancel(ActionEvent event) throws IOException {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    private void onPressPlay(ActionEvent event) throws IOException {
        Player player = createPlayer(); // creates player in model
        Universe universe = createUniverse();
        
        Parent root = FXMLLoader.load(getClass().getResource("../view/UniverseDisplay.fxml"));
		Stage newStage = new Stage();
		newStage.setScene(new Scene(root, 750, 500));
		newStage.show();
		
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
        Player player = new Player(name, pilot, fighter, trader, engineer, investor);
        
        // for testing
        System.out.println("name: " + name);
        System.out.println("pilot skill: " + pilot);
        System.out.println("fighter skill: " + fighter);
        System.out.println("trader skill: " + trader);
        System.out.println("engineer skill: " + engineer);
        System.out.println("investor skill: " + investor);

        return player;
    }
    
    private Universe createUniverse() {
    	Universe universe = new Universe();
    	
    	// for testing
    	System.out.println(universe);
    	
    	return universe;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
}
    

