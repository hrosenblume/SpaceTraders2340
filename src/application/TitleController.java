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

public class TitleController implements Initializable {
	@FXML
	private Button newGame;
	@FXML
	private void startNewGame(ActionEvent event) throws IOException {
//		System.exit(0);
		Parent root = FXMLLoader.load(getClass().getResource("NewGame.fxml"));
		Stage stage = new Stage();
		stage.setScene(new Scene(root, 500, 500));
		stage.show();

	}
	
	public TitleController() {
		
	}
	
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
}