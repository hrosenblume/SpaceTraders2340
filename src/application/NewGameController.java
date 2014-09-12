package application;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class NewGameController implements Initializable {
    private BorderPane rootLayout;	
	private Stage primaryStage;
	@FXML
	private Button pilotUp, pilotDown, fighterUp, fighterDown, traderUp, traderDown, engineerUp, engineerDown, investorUp, investorDown;
	@FXML
	private Text totalPoints, pilotSkillLabel, fighterSkillLabel, traderSkillLabel, engineerSkillLabel, investorSkillLabel;
	private int counter = 30;

	@FXML
	private void increasePilot(ActionEvent event) throws IOException {
		changeSkill(pilotSkillLabel, true);
	}
	@FXML
	private void decreasePilot(ActionEvent event) throws IOException {
		changeSkill(pilotSkillLabel, false);
	}
	@FXML
	private void increaseFighter(ActionEvent event) throws IOException {
		changeSkill(fighterSkillLabel, true);
	}
	@FXML
	private void decreaseFighter(ActionEvent event) throws IOException {
		changeSkill(fighterSkillLabel, false);
	}
	@FXML
	private void increaseTrader(ActionEvent event) throws IOException {
		changeSkill(traderSkillLabel, true);
	}
	@FXML
	private void decreaseTrader(ActionEvent event) throws IOException {
		changeSkill(traderSkillLabel, false);
	}
	@FXML
	private void increaseEngineer(ActionEvent event) throws IOException {
		changeSkill(engineerSkillLabel, true);
	}
	@FXML
	private void decreaseEngineer(ActionEvent event) throws IOException {
		changeSkill(engineerSkillLabel, false);
	}
	@FXML
	private void increaseInvestor(ActionEvent event) throws IOException {
		changeSkill(investorSkillLabel, true);
	}
	@FXML
	private void decreaseInvestor(ActionEvent event) throws IOException {
		changeSkill(investorSkillLabel, false);
	}

	private void changeSkill(Text thisLabel, boolean isIncrement) {
		if(!((counter <= 0 && isIncrement) || (counter >= 30 && !isIncrement))) {
			String currentSkill = thisLabel.getText();
			int currentSkillNum = Integer.parseInt(currentSkill);
			int newSkillNum = 0;
			if (isIncrement) {
				newSkillNum = currentSkillNum + 1;
				counter--;
			} else {
				if (currentSkillNum > 0) {
					newSkillNum = currentSkillNum - 1;
					counter++;					
				}
			}
			String newSkill = "" + newSkillNum;
			thisLabel.setText(newSkill);
			totalPoints.setText("" + counter);
		}
	}
	public NewGameController() {
		
	}
	
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
}
	

