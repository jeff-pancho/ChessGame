package main;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import main.chesspiece.ChessPiece;

public class Board3D {
    public static final int NUM_BOARDS = 3;
    
    private Board[] boards;
    
    public Board3D() {
        boards = new Board[NUM_BOARDS];
        for (int i = 0; i < NUM_BOARDS; i++) {
            boards[i] = new Board(i);
        }
        
        boards[0].initPieces(Player.WHITE);
        boards[2].initPieces(Player.BLACK);
    }
    
    public HBox getHBox() {
        HBox box = new HBox();
        box.setPrefSize(Game.WIDTH, Game.HEIGHT);
        box.setAlignment(Pos.CENTER);
        
        for (Board b : boards) {
            box.getChildren().add(b.getCanvas());
        }
        
        return box;
    }
    
    public ChessPiece[][] getPieces(int i) {
        return boards[i].getPieces();
    }
    
    public void render() {
        for (int i = 0; i < NUM_BOARDS; i++)
            renderBoard(i);
    }
    
    public void renderBoard(int i) {
        boards[i].renderBoard();
    }

}
