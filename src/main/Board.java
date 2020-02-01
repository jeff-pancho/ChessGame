package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import main.chesspiece.Bishop;
import main.chesspiece.King;
import main.chesspiece.Knight;
import main.chesspiece.Pawn;
import main.chesspiece.Queen;
import main.chesspiece.Rook;

public class Board {
    private ArrayList<ChessPiece> pieces;
    private GraphicsContext gc;
    
    public static Image bKing, bQueen, bRook, bBishop, bKnight, bPawn
                        , wKing, wQueen, wRook, wBishop, wKnight, wPawn;
    
    Board(GraphicsContext gc) throws FileNotFoundException {
        this.gc = gc;
        this.pieces = new ArrayList<ChessPiece>();
        initImages();
    }
    
    public void renderBoard() {
        Color dark = Color.rgb(93, 100, 110);
        for(int y = 0; y < 8; y++) {
            for(int x = 0; x < 8; x++) {
                gc.setFill((x + y) % 2 == 0 ? Color.WHITE : dark);
                gc.fillRect(100 * x, 100 * y, 100, 100);
            }
        }
        for(ChessPiece c : pieces)
            gc.drawImage(c.getImg(), c.getRow() * 100, c.getColumn() * 100);
    }
    
    public void initPieces() {
        for(int i = 0; i < 2; i++) {
            for(int x = 0; x < 8; x++)
                pieces.add(new Pawn(x, 1 + 5 * i, i));
            for(int j = 0; j < 2; j++)
                pieces.add(new Rook(7 * j, 7 * i, i));
            for(int j = 0; j < 2; j++)
                pieces.add(new Knight(1 + 5 * j, 7 * i, i));
            for(int j = 0; j < 2; j++)
                pieces.add(new Bishop(2 + 3 * j, 7 * i, i));
            pieces.add(new Queen(3, 7 * i, i));
            pieces.add(new King(4, 7 * i, i));
        }
    }
    
    private void initImages() throws FileNotFoundException {
        bKing = new Image(new FileInputStream("./img/bKing.png"));
        bQueen = new Image(new FileInputStream("./img/bQueen.png"));
        bRook = new Image(new FileInputStream("./img/bRook.png"));
        bBishop = new Image(new FileInputStream("./img/bBishop.png"));
        bKnight = new Image(new FileInputStream("./img/bKnight.png"));
        bPawn = new Image(new FileInputStream("./img/bPawn.png"));
        
        wKing = new Image(new FileInputStream("./img/wKing.png"));
        wQueen = new Image(new FileInputStream("./img/wQueen.png"));
        wRook = new Image(new FileInputStream("./img/wRook.png"));
        wBishop = new Image(new FileInputStream("./img/wBishop.png"));
        wKnight = new Image(new FileInputStream("./img/wKnight.png"));
        wPawn = new Image(new FileInputStream("./img/wPawn.png"));
    }
}
