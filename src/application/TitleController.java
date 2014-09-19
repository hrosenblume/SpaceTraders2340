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
import javafx.stage.Stage;

/**
 * Manages the controls for the title screen.
 * @author Hunter Rosenblume, Naman Shah, Stephen Song, Bhavesh Suhagia, Pranil Vora
 */
public class TitleController implements Initializable {
	
	@FXML
	private Button quitButton;

	@FXML
	private void startNewGame(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../view/NewGame.fxml"));
		Stage stage = new Stage();
		stage.setScene(new Scene(root, 800, 600));
		stage.show();	
	}
	
	@FXML
	private void onPressQuit(ActionEvent event) throws IOException {
		Stage stage = (Stage) quitButton.getScene().getWindow();
        stage.close();
	}
	
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
}