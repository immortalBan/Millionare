package sample.model;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class GameQuestion {
    private StringProperty id;
    private StringProperty game_id;
    private StringProperty question_id;

    public GameQuestion(String id, String game_id, String question_id) {
        this.id = new SimpleStringProperty(id);
        this.game_id = new SimpleStringProperty(game_id);
        this.question_id = new SimpleStringProperty(question_id);
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

    public String getGame_id() {
        return game_id.get();
    }

    public StringProperty game_idProperty() {
        return game_id;
    }

    public void setGame_id(String game_id) {
        this.game_id.set(game_id);
    }

    public String getQuestion_id() {
        return question_id.get();
    }

    public StringProperty question_idProperty() {
        return question_id;
    }

    public void setQuestion_id(String question_id) {
        this.question_id.set(question_id);
    }
}
