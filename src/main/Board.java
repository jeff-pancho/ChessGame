package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import main.chesspiece.Bishop;
import main.chesspiece.King;
import main.chesspiece.Knight;
import main.chesspiece.Pawn;
import main.chesspiece.Queen;
import main.chesspiece.Rook;

public class Board {
    private ArrayList<ChessPiece> pieces;
    private ChessPiece curPiece;
    private Canvas canvas;
    private GraphicsContext gc;
    
    public static Image bKing, bQueen, bRook, bBishop, bKnight, bPawn
                        , wKing, wQueen, wRook, wBishop, wKnight, wPawn;
    
    Board(Canvas canvas) throws FileNotFoundException {
        this.canvas = new Canvas();
        this.gc = canvas.getGraphicsContext2D();
        this.pieces = new ArrayList<ChessPiece>();
        
        canvas.setOnMouseClicked(this::handle);
        
        initImages();
    }
    
    public void renderBoard() {
        gc.clearRect(0, 0, Game.WIDTH, Game.HEIGHT);
        Color dark = Color.rgb(93, 100, 110);
        for(int y = 0; y < 8; y++) {
            for(int x = 0; x < 8; x++) {
                gc.setFill((x + y) % 2 == 0 ? Color.WHITE : dark);
                gc.fillRect(100 * x, 100 * y, 100, 100);
            }
        }
        for(ChessPiece c : pieces)
            gc.drawImage(c.getImg(), c.getColumn() * 100, c.getRow() * 100);
    }
    
    private void handle(MouseEvent e) {
        int row = (int) e.getSceneY() / 100;
        int column = (int) e.getSceneX() / 100;
        
        if(curPiece == null)
            curPiece = getPiece(row, column);
        else {
            curPiece.setPos(row, column);
            curPiece = null;
            renderBoard();
        }
    }
    
    private ChessPiece getPiece(int row, int column) {
        for(ChessPiece c : pieces)
            if(c.getRow() == row && c.getColumn() == column) {
                System.out.println("FOUND");
                return c;
            }
        return null;
    }
    
    public void initPieces() {
        for(int i = 0; i < 2; i++) {
            for(int x = 0; x < 8; x++)
                pieces.add(new Pawn(1 + 5 * i, x, i));
            for(int j = 0; j < 2; j++)
                pieces.add(new Rook(7 * i, 7 * j, i));
            for(int j = 0; j < 2; j++)
                pieces.add(new Knight(7 * i, 1 + 5 * j, i));
            for(int j = 0; j < 2; j++)
                pieces.add(new Bishop(7 * i, 2 + 3 * j, i));
            pieces.add(new Queen(7 * i, 3, i));
            pieces.add(new King(7 * i, 4, i));
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
