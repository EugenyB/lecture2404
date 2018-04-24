package sample;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import logic.GameField;

public class Controller {
    @FXML private Pane pane;
    @FXML private Canvas canvas;

    GameField field = new GameField();

    @FXML
    public void initialize() {
        canvas.widthProperty().bind(pane.widthProperty());
        canvas.heightProperty().bind(pane.heightProperty());

        canvas.widthProperty().addListener(e->draw());
        canvas.heightProperty().addListener(e->draw());
    }


    public void draw() {
        field.draw(canvas);
    }
}
