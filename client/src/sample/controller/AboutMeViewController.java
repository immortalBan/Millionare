package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import sample.Main;

import java.io.IOException;

public class AboutMeViewController {
    private Main mainApp;
    private AnchorPane rootLayout;

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }

    public void setRootLayout(AnchorPane rootLayout) {
        this.rootLayout = rootLayout;
    }

    @FXML
    public void closeScene() throws IOException {
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
