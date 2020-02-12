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
//    private ArrayList<ChessPiece> pieces;
    private ChessPiece[][] pieces;
    private ChessPiece curPiece;
    private boolean[][] validMoves;
    private Canvas canvas;
    private GraphicsContext gc;
    
    public static Image bKing, bQueen, bRook, bBishop, bKnight, bPawn
                        , wKing, wQueen, wRook, wBishop, wKnight, wPawn;
    
    Board(Canvas canvas) throws FileNotFoundException {
        this.canvas = new Canvas();
        this.gc = canvas.getGraphicsContext2D();
//        this.pieces = new ArrayList<ChessPiece>();
        this.pieces = new ChessPiece[8][8];
        
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
        for(ChessPiece[] pieceRow : pieces)
            for(ChessPiece piece : pieceRow)
                if(piece != null)
                    gc.drawImage(piece.getImg(), piece.getColumn() * 100, piece.getRow() * 100);
    }
    
    private void handle(MouseEvent e) {
        int row = (int) e.getSceneY() / 100;
        int column = (int) e.getSceneX() / 100;
        
        if(curPiece == null) {
            if((curPiece = pieces[row][column]) != null) {
                validMoves = curPiece.calcMoves(pieces);
                drawMarkers(row, column);
                System.out.println(curPiece.getClass().getName());
            }
        } else if(validMoves[row][column]) {
            curPiece.setPos(row, column, pieces);
            curPiece = null;
            renderBoard();
        } else {
            curPiece = null;
            renderBoard();
        }
    }
    
    private void drawMarkers(int row, int column) {
        gc.setStroke(Color.DARKORCHID);
        gc.setLineWidth(4.0);
        for(int y = 0; y < validMoves.length; y++) {
            for(int x = 0; x < validMoves[y].length; x++)
                if(validMoves[y][x])
                    gc.strokeRect(100 * x, 100 * y, 100, 100);
        }
        gc.setStroke(Color.BLUE);
        gc.strokeRect(100 * column, 100 * row, 100, 100);
    }
    
    public void initPieces() {
        for(int i = 0; i < 2; i++) {
            for(int x = 0; x < 8; x++)
                pieces[1 + 5 * i][x] = new Pawn(1 + 5 * i, x, i);
            for(int j = 0; j < 2; j++)
                pieces[7 * i][7 * j] = new Rook(7 * i, 7 * j, i);
            for(int j = 0; j < 2; j++)
                pieces[7 * i][1 + 5 * j] = new Knight(7 * i, 1 + 5 * j, i);
            for(int j = 0; j < 2; j++)
                pieces[7 * i][2 + 3 * j] = new Bishop(7 * i, 2 + 3 * j, i);
            pieces[7 * i][3] = new Queen(7 * i, 3, i);
            pieces[7 * i][4] = new King(7 * i, 4, i);
        }
    }
    
    private void initImages() throws FileNotFoundException {
        bKing = new Image("file:./img/bKing.png");
        bQueen = new Image("file:./img/bQueen.png");
        bRook = new Image("file:./img/bRook.png");
        bBishop = new Image("file:./img/bBishop.png");
        bKnight = new Image("file:./img/bKnight.png");
        bPawn = new Image("file:./img/bPawn.png");
        
        wKing = new Image("file:./img/wKing.png");
        wQueen = new Image("file:./img/wQueen.png");
        wRook = new Image("file:./img/wRook.png");
        wBishop = new Image("file:./img/wBishop.png");
        wKnight = new Image("file:./img/wKnight.png");
        wPawn = new Image("file:./img/wPawn.png");
    }
}
