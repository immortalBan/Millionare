package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import sample.Main;

import java.io.IOException;

public class ResultViewController {
    private Main mainApp;
    private AnchorPane rootLayout;
    @FXML
    private Label pointsLabel;

    @FXML
    private Label resultLabel;

    public void setMainApp(Main mainApp, boolean win, Integer points) {
        this.mainApp = mainApp;
        this.pointsLabel.setText("Вы заработали: " + points.toString());
        if (win) {
            this.resultLabel.setText("Вы выиграли!");
        } else {
            this.resultLabel.setText("Вы проиграли!");
        }
    }

    public void setRootLayout(AnchorPane rootLayout) {
        this.rootLayout = rootLayout;
    }

    @FXML
    public void handleOk() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        System.out.println(Main.class.getResource("view/MainMenuView.fxml"));
        loader.setLocation(Main.class.getResource("view/MainMenuView.fxml"));

        AnchorPane mainMenu = loader.load();

        Scene scene = new Scene(mainMenu);
        mainApp.getPrimaryStage().setScene(scene);
        mainApp.getPrimaryStage().show();

        MainMenuViewController mainMenuViewController = loader.getController();
        mainMenuViewController.setRootLayout(mainMenu);
        mainMenuViewController.setMainApp(mainApp);
    }
}
