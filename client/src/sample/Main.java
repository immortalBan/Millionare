package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import sample.api.MyApi;
import sample.controller.MainMenuViewController;
import javafx.scene.layout.AnchorPane;
import sample.model.Game;
import sample.model.GameQuestion;
import sample.model.Question;

import java.util.List;

public class Main extends Application {

    private ObservableList<Game> games = FXCollections.observableArrayList();
    private ObservableList<Question> questions = FXCollections.observableArrayList();
    private ObservableList<GameQuestion> gameQuestions = FXCollections.observableArrayList();
    private MyApi api = new MyApi();

    public ObservableList<Game> getGames() {
        return games;
    }

    public void setGames(ObservableList<Game> games) {
        this.games = games;
    }

    public void setGames() {
        this.games = FXCollections.observableArrayList();
        this.games.addAll(api.getGames());
    }

    public ObservableList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ObservableList<Question> questions) {
        this.questions = questions;
    }

    public ObservableList<GameQuestion> getGameQuestions() {
        return gameQuestions;
    }

    public void setGameQuestions(ObservableList<GameQuestion> gameQuestions) {
        this.gameQuestions = gameQuestions;
    }



    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    private Stage primaryStage;

    public Main(){
        this.games.addAll(api.getGames());
        this.questions.addAll(api.getQuestions());
        this.gameQuestions.addAll(api.getGameQuestions());
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        setPrimaryStage(primaryStage);
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/MainMenuView.fxml"));
        AnchorPane mainMenu = loader.load();

        Scene scene = new Scene(mainMenu);
        primaryStage.setScene(scene);
        primaryStage.show();

        MainMenuViewController mainMenuViewController = loader.getController();
        mainMenuViewController.setMainApp(this);
        mainMenuViewController.setRootLayout(mainMenu);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
