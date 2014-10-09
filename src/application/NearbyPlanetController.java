package application;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class NearbyPlanetController implements Initializable{
	@FXML
	private Text pName1, pName2, pName3, pName4, pName5, pName6, pName7, pName8, pName9,pName10, pName11, pName12, pName13,pName14, pName15, pName16, pName17,pName18, pName19, pName20, pName21,pName22, pName23, pName24, pName25,pName26, pName27, pName28, pName29, pName30, pName31, pName32, pName33, pName34,pName35, pName36, pName37, pName38,pName39, pName40, pName41, pName42,pName43, pName44, pName45, pName46,pName47, pName48, pName49, pName50;
	@FXML
	private Button go1, go2, go3, go4, go5, go6, go7, go8, go9,go10, go11, go12, go13,go14, go15, go16, go17,go18, go19, go20, go21,go22, go23, go24, go25,go26, go27, go28, go29, go30, go31, go32, go33, go34,go35, go36, go37, go38,go39, go40, go41, go42,go43, go44, go45, go46,go47, go48, go49, go50;
	@FXML
	private Text fuel1, fuel2, fuel3, fuel4, fuel5, fuel6, fuel7, fuel8, fuel9,fuel10, fuel11, fuel12, fuel13,fuel14, fuel15, fuel16, fuel17,fuel18, fuel19, fuel20, fuel21,fuel22, fuel23, fuel24, fuel25,fuel26, fuel27, fuel28, fuel29, fuel30, fuel31, fuel32, fuel33, fuel34,fuel35, fuel36, fuel37, fuel38,fuel39, fuel40, fuel41, fuel42,fuel43, fuel44, fuel45, fuel46,fuel47, fuel48, fuel49, fuel50;	
	@FXML
	private Text fuelLeft;
	@FXML
	private GridPane planetGrid;
	
	Planet[] plans = Universe.getNearbyPlanets(PlanetController.currentPlanet);
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		fuelLeft.setText("Fuel left: " + Universe.player.getFuel());
		
		// The XML's planetGrid's entries are not sorted correctly
		
		System.out.println(plans);
		
		for (int i = 0; i < planetGrid.getChildren().size(); i++){
			Node node = planetGrid.getChildren().get(i);
	      ObservableList<Node> innerNode = ((GridPane) node).getChildren();
	    	  ((Text) innerNode.get(0)).setText(plans[i].name);
	    	  int fuel = (int)plans[i].calculateDistance(PlanetController.currentPlanet);
	    	  ((Text) innerNode.get(2)).setText("Fuel Required: " + fuel);
		}
	}
	
	
	
	 @FXML
    private void go(ActionEvent event) throws IOException {
		 Button clickedBtn = (Button) event.getSource(); // btn clicked
		 Planet p = plans[Integer.parseInt(clickedBtn.getId().substring(2)) - 1];
		 int distance = (int)p.calculateDistance(PlanetController.currentPlanet);
		 if (distance > Universe.player.getFuel()) {
			 System.out.println("NO");
		 } else {
			 System.out.println(Universe.player.getFuel() - distance);
		 }
    }

}
