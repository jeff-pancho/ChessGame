package main;

import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Board {
    ArrayList<ChessPiece> pieces;
    GraphicsContext gc;
    
    Board(GraphicsContext gc) {
        this.gc = gc;
        this.pieces = new ArrayList<ChessPiece>();
    }
    
    public void initPieces() {
        for(int y = 0; y < 2; y++) {
            for(int x = 0; x < 8; x++) {
                pieces.add(new Rook(x, y, null));
            }
        }
    }
    
    public void renderBoard() {
        for(int y = 0; y < 8; y++) {
            for(int x = 0; x < 8; x++) {
                gc.setFill((x + y) % 2 == 0 ? Color.WHITE : Color.SADDLEBROWN);
                gc.fillRect(100 * x, 100 * y, 100, 100);
            }
        }
    }
}
