package main;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import main.chesspiece.ChessPiece;

public class Board3D {
    public static final int NUM_BOARDS = 3;
    
    private Board[] boards;
    private ChessPiece[][][] pieces;
    
    public Board3D() {
        boards = new Board[NUM_BOARDS];
        pieces = new ChessPiece[NUM_BOARDS][8][8];
        
        for (int i = 0; i < NUM_BOARDS; i++) {
            boards[i] = new Board(i);
            pieces[i] = boards[i].getPieces();
        }
        
        boards[0].initPieces(Player.WHITE);
        boards[2].initPieces(Player.BLACK);
    }
    
    public HBox getHBox() {
        HBox box = new HBox();
        box.setPrefSize(Game.WIDTH, Game.HEIGHT);
        box.setAlignment(Pos.CENTER);
        
        for (Board b : boards) {
            box.getChildren().add(b);
        }
        
        return box;
    }
    
    public Board[] getBoards() {
        return boards;
    }
    
    public Board getBoard(int i) {
        return boards[i];
    }
    
    public ChessPiece[][][] getPieces() {
        return pieces;
    }
    
    public ChessPiece[][] getPieces(int i) {
        return pieces[i];
    }
    
    public void render() {
        for (int i = 0; i < NUM_BOARDS; i++)
            renderBoard(i);
    }
    
    public void renderBoard(int i) {
        boards[i].renderBoard();
    }

}
