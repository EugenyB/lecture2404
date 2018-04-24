package logic;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Double.min;

public class GameField {
    public static final int SIZE = 20;
    public static final int BOX_COUNT = 5;

    List<GameBox> boxes;

    public GameField() {
        boxes = new ArrayList<>();
        for (int i = 0; i < BOX_COUNT; i++) {
            GameBox box;
            do {
                box = new GameBox();
            } while (boxes.contains(box));
            boxes.add(box);
        }
    }

    public void draw(Canvas canvas) {
        double cellSize = getCellSize(canvas);
        GraphicsContext g = canvas.getGraphicsContext2D();
        g.setFill(Color.WHITESMOKE);
        g.fillRect(0,0, canvas.getWidth(), canvas.getHeight());
        double x0 = (canvas.getWidth() - SIZE*cellSize)/2;
        double y0 = (canvas.getHeight() - SIZE*cellSize)/2;
        g.translate(x0,y0);
        for (int i = 0; i <= SIZE; i++) {
            g.strokeLine(0, i*cellSize, SIZE*cellSize, i*cellSize);
        }
        for (int i = 0; i <= SIZE; i++) {
            g.strokeLine(i*cellSize, 0, i*cellSize, SIZE*cellSize);
        }
        boxes.forEach(b->b.draw(canvas, g));

        g.translate(-x0,-y0);
    }

    private double getCellSize(Canvas canvas) {
        double cellX = canvas.getWidth()/SIZE;
        double cellY = canvas.getHeight()/SIZE;
        return min(cellX, cellY);
    }
}
