package sample.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.List;

public class Question {

    private StringProperty id;
    private StringProperty level;
    private StringProperty text;
    private StringProperty firstAnswer;
    private StringProperty secondAnswer;
    private StringProperty thirdAnswer;
    private StringProperty fourthAnswer;
    private StringProperty correctAnswer;

    public Question(String id, String level, String text, String firstAnswer, String secondAnswer, String thirdAnswer, String fourthAnswer, String correctAnswer) {
        this.id = new SimpleStringProperty(id);
        this.level = new SimpleStringProperty(level);
        this.text = new SimpleStringProperty(text);
        this.firstAnswer = new SimpleStringProperty(firstAnswer);
        this.secondAnswer = new SimpleStringProperty(secondAnswer);
        this.thirdAnswer = new SimpleStringProperty(thirdAnswer);
        this.fourthAnswer = new SimpleStringProperty(fourthAnswer);
        this.correctAnswer = new SimpleStringProperty(correctAnswer);
    }

    public String getId() {
        return id.get();
    }

    public StringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getLevel() {
        return level.get();
    }

    public StringProperty levelProperty() {
        return level;
    }

    public void setLevel(String level) {
        this.level.set(level);
    }

    public String getText() {
        return text.get();
    }

    public StringProperty textProperty() {
        return text;
    }

    public void setText(String text) {
        this.text.set(text);
    }

    public String getFirstAnswer() {
        return firstAnswer.get();
    }

    public StringProperty firstAnswerProperty() {
        return firstAnswer;
    }

    public void setFirstAnswer(String firstAnswer) {
        this.firstAnswer.set(firstAnswer);
    }

    public String getSecondAnswer() {
        return secondAnswer.get();
    }

    public StringProperty secondAnswerProperty() {
        return secondAnswer;
    }

    public void setSecondAnswer(String secondAnswer) {
        this.secondAnswer.set(secondAnswer);
    }

    public String getThirdAnswer() {
        return thirdAnswer.get();
    }

    public StringProperty thirdAnswerProperty() {
        return thirdAnswer;
    }

    public void setThirdAnswer(String thirdAnswer) {
        this.thirdAnswer.set(thirdAnswer);
    }

    public String getFourthAnswer() {
        return fourthAnswer.get();
    }

    public StringProperty fourthAnswerProperty() {
        return fourthAnswer;
    }

    public void setFourthAnswer(String fourthAnswer) {
        this.fourthAnswer.set(fourthAnswer);
    }

    public String getCorrectAnswer() {
        return correctAnswer.get();
    }

    public StringProperty correctAnswerProperty() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer.set(correctAnswer);
    }
}
