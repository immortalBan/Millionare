package sample.controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import sample.Main;
import sample.api.MyApi;
import sample.model.Game;
import sample.model.Question;

import java.io.IOException;
import java.util.ArrayList;

public class QuestionViewController {
    private Main mainApp;
    private AnchorPane rootLayout;
    private Integer level;
    private Integer points;
    private ObservableList<Question> questions;
    private MyApi api = new MyApi();
    private String currentCorrect;

    @FXML
    private Label pointsLabel;

    @FXML
    private Label questionLabel;

    @FXML
    private Button buttonA;
    @FXML
    private Button buttonB;
    @FXML
    private Button buttonC;
    @FXML
    private Button buttonD;


    public void setRootLayout(AnchorPane rootLayout) {
        this.rootLayout = rootLayout;
    }

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
        this.questions = mainApp.getQuestions();
        System.out.println(questions.get(0).getLevel());
        this.pointsLabel.setText("Баллы: " + this.points.toString());
        nextQuestion();
    }

    @FXML
    public void initialize(){
        this.level = 1;
        this.points = 0;
    }

    public Question getQuestion(){
        ArrayList<Question> levelQuestions = new ArrayList<>();
        for (Question question : questions){
            if (question.getLevel().equals(this.level.toString())) {
                levelQuestions.add(question);
            }
        }
        int a = (int) (Math.random() * (levelQuestions.size()) );
        return levelQuestions.get(a);
    }

    public void nextQuestion(){
        Question currentQuestion = getQuestion();
        questionLabel.setText(currentQuestion.getText());
        buttonA.setText("A:" + currentQuestion.getFirstAnswer());
        buttonB.setText("B:" + currentQuestion.getSecondAnswer());
        buttonC.setText("C:" + currentQuestion.getThirdAnswer());
        buttonD.setText("D:" + currentQuestion.getFourthAnswer());
        this.currentCorrect = currentQuestion.getCorrectAnswer();

    }

    public void resultScreen(boolean win, Integer points) throws IOException {
        this.api.createGame(this.points.toString());
        FXMLLoader loader = new FXMLLoader();
        System.out.println(Main.class.getResource("view/ResultView.fxml"));
        loader.setLocation(Main.class.getResource("view/ResultView.fxml"));

        AnchorPane result = loader.load();

        Scene scene = new Scene(result);
        mainApp.getPrimaryStage().setScene(scene);
        mainApp.getPrimaryStage().show();

        ResultViewController resultViewController = loader.getController();
        resultViewController.setRootLayout(result);
        resultViewController.setMainApp(mainApp, win, this.points);
    }

    @FXML
    public void checkFirstAnswer() throws IOException {
        if (this.currentCorrect.equals("1")){
            this.points += this.level;
            this.level += 1;
            this.pointsLabel.setText("Баллы: " + this.points.toString());
            if (level <= 10) {
                nextQuestion();
            } else {
                resultScreen(true, this.points);
            }
        } else {
            resultScreen(false, this.points);
        }
    }

    @FXML
    public void checkSecondAnswer() throws IOException {
        if (this.currentCorrect.equals("2")){
            this.points += this.level;
            this.level += 1;
            this.pointsLabel.setText("Баллы: " + this.points.toString());
            if (level <= 10) {
                nextQuestion();
            } else {
                resultScreen(true, this.points);
            }
        } else {
            resultScreen(false, this.points);
        }
    }

    @FXML
    public void checkThirdAnswer() throws IOException {
        if (this.currentCorrect.equals("3")){
            this.points += this.level;
            this.level += 1;
            this.pointsLabel.setText("Баллы: " + this.points.toString());
            if (level <= 10) {
                nextQuestion();
            } else {
                resultScreen(true, this.points);
            }
        } else {
            resultScreen(false, this.points);
        }
    }

    @FXML
    public void checkFourthAnswer() throws IOException {
        if (this.currentCorrect.equals("4")){
            this.points += this.level;
            this.level += 1;
            this.pointsLabel.setText("Баллы: " + this.points.toString());
            if (level <= 10) {
                nextQuestion();
            } else {
                resultScreen(true, this.points);
            }
        } else {
            resultScreen(false, this.points);
        }
    }

}
