package main;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import main.chesspiece.ChessPiece;

public class Board3D {
//    public static final int NUM_BOARDS = 3;
    
    private Board[] boards;
    private ChessPiece[][][] pieces;
    
    public Board3D() {
        boards = new Board[Game.numBoards];
        pieces = new ChessPiece[Game.numBoards][8][8];
        
        for (int i = 0; i < Game.numBoards; i++) {
            boards[i] = new Board(i);
            pieces[i] = boards[i].getPieces();
        }
        
        boards[0].initPieces(Player.WHITE);
        boards[boards.length - 1].initPieces(Player.BLACK);
    }
    
    public HBox getHBox() {
        HBox box = new HBox(8);
        box.setPrefSize(Game.width, Game.HEIGHT);
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
        for (int i = 0; i < Game.numBoards; i++)
            renderBoard(i);
    }
    
    public void renderBoard(int i) {
        boards[i].renderBoard();
    }

}
