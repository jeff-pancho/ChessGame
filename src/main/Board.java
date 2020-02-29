package main;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Board {
    public static final int RECT_SIZE = 75;
    public static final int BOARD_LENGTH = RECT_SIZE * 8;
    /** Board colors. */
    public static final Color DARK = Color.rgb(93, 100, 110);
    public static final Color LIGHT = Color.rgb(255, 255, 255);
    public static final Color BORDER = Color.rgb(0, 0, 0);
    
    private Canvas canvas;
    private GraphicsContext gc;
    
    
    /** z-level of the Board */
    private int z;
    
    public Board(int z) {
        this.canvas = new Canvas(BOARD_LENGTH, BOARD_LENGTH);
        this.gc = canvas.getGraphicsContext2D();
        this.z = z;
    }
    
    public void renderBoard() {
        gc.clearRect(0, 0, BOARD_LENGTH, BOARD_LENGTH);
        
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                gc.setFill((row + col) % 2 == 0 ? LIGHT : DARK);
                gc.fillRect(RECT_SIZE * col, (RECT_SIZE * row), RECT_SIZE, RECT_SIZE);
            }
        }
        
        renderBorder();
    }
    
    private void renderBorder() {
        gc.setStroke(BORDER);
        gc.setLineWidth(8);
        gc.strokeRect(0, 0, BOARD_LENGTH, BOARD_LENGTH);
    }
    
    public Canvas getCanvas() {
        return this.canvas;
    }
    
}
