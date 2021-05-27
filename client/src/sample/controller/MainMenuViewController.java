package sample.controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import sample.Main;
import sample.model.Game;

import java.io.IOException;
import java.util.List;

public class MainMenuViewController {

    private Main mainApp;
    private AnchorPane rootLayout;

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }

    public void setRootLayout(AnchorPane rootLayout) {
        this.rootLayout = rootLayout;
    }


    @FXML
    public void handleAboutMe() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        System.out.println(Main.class.getResource("view/AboutMeView.fxml"));
        loader.setLocation(Main.class.getResource("view/AboutMeView.fxml"));

        AnchorPane aboutMe = loader.load();

        Scene scene = new Scene(aboutMe);
        mainApp.getPrimaryStage().setScene(scene);
        mainApp.getPrimaryStage().show();

        AboutMeViewController aboutMeViewController = loader.getController();
        aboutMeViewController.setRootLayout(aboutMe);
        aboutMeViewController.setMainApp(mainApp);
    }

    @FXML
    public void handleGamesStats() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        System.out.println(Main.class.getResource("view/GamesStatView.fxml"));
        loader.setLocation(Main.class.getResource("view/GamesStatView.fxml"));

        AnchorPane gamesStats = loader.load();

        Scene scene = new Scene(gamesStats);
        mainApp.getPrimaryStage().setScene(scene);
        mainApp.getPrimaryStage().show();

        GamesStatViewController gamesStatViewController = loader.getController();
        gamesStatViewController.setRootLayout(gamesStats);
        gamesStatViewController.setMainApp(mainApp);
    }

    @FXML
    public void handleStartGame() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        System.out.println(Main.class.getResource("view/QuestionView.fxml"));
        loader.setLocation(Main.class.getResource("view/QuestionView.fxml"));

        AnchorPane newGame = loader.load();

        Scene scene = new Scene(newGame);
        mainApp.getPrimaryStage().setScene(scene);
        mainApp.getPrimaryStage().show();

        QuestionViewController questionViewController = loader.getController();
        questionViewController.setRootLayout(newGame);
        questionViewController.setMainApp(mainApp);
    }

}
