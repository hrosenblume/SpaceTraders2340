package application;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * Manages the controls for the title screen.
 * @author Hunter Rosenblume, Naman Shah, Stephen Song, Bhavesh Suhagia, Pranil Vora
 */
public class TitleController implements Initializable {
	private Stage stage;
	@FXML
	private Button quitButton;
	
	@FXML
	private Button saveButton;

	@FXML
	private void startNewGame(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../view/NewGame.fxml"));
		stage = new Stage();
		stage.setScene(new Scene(root, 800, 600));
		stage.show();	
	}
	
	@FXML
	private void loadNewGame(Player player) throws IOException {
		NewGameController.setPlayer(player);
		Parent root = FXMLLoader.load(getClass().getResource("../view/NewGame.fxml"));
		stage = new Stage();
		stage.setScene(new Scene(root, 800, 600));
		stage.show();	
	}
	
	@FXML
	private void onPressLoad(ActionEvent event) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Resource File");
		File selectedFile = fileChooser.showOpenDialog(stage);
		if (selectedFile != null) {
			Player tempPlayer = createPlayerFromFile(selectedFile);
			try {
				loadNewGame(tempPlayer);
			} catch (Exception e) {
				System.out.println("error");
			}
        }
	}
	
	private Player createPlayerFromFile(File file) {
		int pilotSkillLevel = 0, fighterSkillLevel=0, traderSkillLevel=0,
        engineerSkillLevel=0, investorSkillLevel=0, money=0, fuel=0;
		String name = "";
		HashMap<String, Integer> cargo = new HashMap<String, Integer>();
		Player newPlayer;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			int counter = 0;
			while ((line = br.readLine()) != null) {
			   // process the line.
				if (counter == 0) {
					name = line;
				} else if (counter == 1) {
					pilotSkillLevel = Integer.parseInt(line);
				} else if (counter == 2) {
					fighterSkillLevel = Integer.parseInt(line);
				} else if (counter == 3) {
					traderSkillLevel = Integer.parseInt(line);
				} else if (counter == 4) {
					engineerSkillLevel = Integer.parseInt(line);
				} else if (counter == 5) {
					investorSkillLevel = Integer.parseInt(line);
				} else if (counter == 6) {
					money = Integer.parseInt(line);
				} else if (counter == 7) {
					fuel = Integer.parseInt(line);
				} else if (counter == 8) {
					cargo = prepareCargoHelper(line);
				}
				counter++;
			}
			br.close();
		} catch (Exception e) {
			
		} finally {
			newPlayer = new Player(name, pilotSkillLevel, fighterSkillLevel, traderSkillLevel,
			        engineerSkillLevel, investorSkillLevel, money, fuel, cargo);
		}
		return newPlayer;
	}
	
	private HashMap<String, Integer> prepareCargoHelper(String line) {
		HashMap<String, Integer> cargo = new HashMap<String, Integer>();
		List<String> items = Arrays.asList(line.split("\\s*,\\s*"));
		
        cargo.put("Water", Integer.parseInt(items.get(0)));
        cargo.put("Fur", Integer.parseInt(items.get(1)));
        cargo.put("Food", Integer.parseInt(items.get(2)));
        cargo.put("Ore", Integer.parseInt(items.get(3)));
        cargo.put("Games", Integer.parseInt(items.get(4)));
        cargo.put("Firearms", Integer.parseInt(items.get(5)));
        cargo.put("Medicine", Integer.parseInt(items.get(6)));
        cargo.put("Machines", Integer.parseInt(items.get(7)));
        cargo.put("Narcotics", Integer.parseInt(items.get(8)));
        cargo.put("Robots", Integer.parseInt(items.get(9)));
		return cargo;
	}
	
	@FXML
	private void onPressQuit(ActionEvent event) throws IOException {
		Stage stage = (Stage) quitButton.getScene().getWindow();
        stage.close();
	}
	
	@FXML
	private void onPressSave(ActionEvent event) throws IOException {
		//toDo
		FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Player");
        System.out.println("saving player");
        File file = fileChooser.showSaveDialog(stage);
        BufferedWriter writer = null;
        if (file != null) {
            try {
            	writer = new BufferedWriter(new FileWriter(file));
                Player toSavePlayer = NewGameController.getPlayer();
                saveHelper(writer, toSavePlayer);
                System.out.println("This is the player: " + NewGameController.getPlayer().getName());
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            } finally {
            	try {
            		writer.close();
            	} catch (Exception e) {
            		System.out.println("yeah");
            	}
            	 
            }
        }
	}
	
	private void saveHelper(BufferedWriter writer, Player toSavePlayer) {
		try {
			writer.write(toSavePlayer.getName());
			writer.newLine();
			writer.write(Integer.toString(toSavePlayer.getPilot()));
			writer.newLine();
			writer.write(Integer.toString(toSavePlayer.getFighter()));
			writer.newLine();
			writer.write(Integer.toString(toSavePlayer.getTrader()));
			writer.newLine();
			writer.write(Integer.toString(toSavePlayer.getEngineer()));
			writer.newLine();
			writer.write(Integer.toString(toSavePlayer.getInvestor()));
			writer.newLine();
			writer.write(Integer.toString(toSavePlayer.getFuel()));
			writer.newLine();
			writer.write(Integer.toString(toSavePlayer.getMoney()));
			writer.newLine();
			HashMap<String, Integer> cargo = toSavePlayer.getCargo();
			String cargoString = Arrays.toString(cargo.values().toArray());
			cargoString = cargoString.substring(1,cargoString.length()-1);
			writer.write(cargoString);
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	
    }  
}