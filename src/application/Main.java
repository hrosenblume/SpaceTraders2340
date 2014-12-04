package application;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Runs the game.
 * 
 * @author Hunter Rosenblume, Naman Shah, Stephen Song, Bhavesh Suhagia, Pranil
 *         Vora
 */
public class Main extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("SpaceTraders");
        Media media = new Media(Paths.get("SpaceTraders.mp3").toUri().toString());
        MediaPlayer backgroundMusicPlayer = new MediaPlayer(media);
        backgroundMusicPlayer.setAutoPlay(true);
        backgroundMusicPlayer.setVolume(1.0);
        backgroundMusicPlayer.setCycleCount(50);
        backgroundMusicPlayer.play();
        initRootLayout();
        showTitleScreen();
    }

    /**
     * Creates the root layout for other windows to be displayed in.
     */
    private void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class
                    .getResource("../view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Display the title screen.
     */
    public void showTitleScreen() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class
                    .getResource("../view/TitleScreen.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();
            rootLayout.setCenter(personOverview);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Runs the program.
     * 
     * @param args command line arguments (unused)
     */
    public static void main(String[] args) {
        launch(args);
    }
}