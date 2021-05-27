package sample.model;


import javafx.beans.property.*;

import java.util.List;

public class Game {

    private StringProperty id;
    private StringProperty points;

    public Game(String id, String points) {
        this.id = new SimpleStringProperty(id);
        this.points = new SimpleStringProperty(points);
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

    public String getPoints() {
        return points.get();
    }

    public StringProperty pointsProperty() {
        return points;
    }

    public void setPoints(String points) {
        this.points.set(points);
    }

    public String getName() {
        return "Игра №" + getId();
    }
}
