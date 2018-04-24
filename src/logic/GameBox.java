package logic;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Objects;
import java.util.Random;

import static java.lang.Double.min;
import static logic.GameField.SIZE;

public class GameBox {
    private int x;
    private int y;

    public GameBox() {
        Random rnd = new Random();
        x = rnd.nextInt(SIZE);
        y = rnd.nextInt(SIZE);
    }

    public void draw(Canvas canvas, GraphicsContext g) {
        double cellSize = getCellSize(canvas);
        g.setFill(Color.RED);
        g.fillOval(x*cellSize, y*cellSize, cellSize, cellSize);
    }

    private double getCellSize(Canvas canvas) {
        double cellX = canvas.getWidth()/SIZE;
        double cellY = canvas.getHeight()/SIZE;
        return min(cellX, cellY);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameBox gameBox = (GameBox) o;
        return x == gameBox.x &&
                y == gameBox.y;
    }

    @Override
    public int hashCode() {

        return Objects.hash(x, y);
    }
}
