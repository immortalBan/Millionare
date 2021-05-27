package sample.controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import sample.Main;
import sample.model.Game;

import java.io.IOException;

public class GamesStatViewController {

    private Main mainApp;
    private AnchorPane rootLayout;

    public void setRootLayout(AnchorPane rootLayout) {
        this.rootLayout = rootLayout;
    }

    @FXML
    private TableView<Game> gamesTableView;
    @FXML
    private TableColumn<Game, String> gameColumn;
    @FXML
    private Label gameLabel;
    @FXML
    private Label pointsLabel;

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
        mainApp.setGames();
        gamesTableView.setItems(mainApp.getGames());
    }

    @FXML
    private void initialize() {
        gameColumn.setCellValueFactory(
                c -> new SimpleStringProperty(
                        c.getValue().getName()
                )
        );

        showGameDetails(null);
        gamesTableView.getSelectionModel().selectedItemProperty().addListener(
                ((observableValue, oldValue, newValue) -> showGameDetails(newValue))

        );
    }

    private void showGameDetails(Game game) {
        if (game != null) {
            gameLabel.setText(game.getName());
            pointsLabel.setText(game.getPoints());

        }
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
