package application;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
<<<<<<< HEAD
import javafx.event.EventHandler;
=======
>>>>>>> 8a314752798d3d77294b5d1abbf4bbfb2b86ce04
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
<<<<<<< HEAD
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class TitleController implements Initializable {
    private BorderPane rootLayout;	
	@FXML
	private Button newGame;

	@FXML
	private void startNewGame(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../view/NewGame.fxml"));
		Stage stage = new Stage();
		stage.setScene(new Scene(root, 500, 500));
		stage.show();	
	}

=======
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
	
>>>>>>> 8a314752798d3d77294b5d1abbf4bbfb2b86ce04
	public TitleController() {
		
	}
	
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
}