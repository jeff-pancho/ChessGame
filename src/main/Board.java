package main;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import main.chesspiece.Bishop;
import main.chesspiece.ChessPiece;
import main.chesspiece.King;
import main.chesspiece.Knight;
import main.chesspiece.Pawn;
import main.chesspiece.Queen;
import main.chesspiece.Rook;

public class Board {
    public static final int RECT_SIZE = 75;
    public static final int BOARD_LENGTH = RECT_SIZE * 8;
    
    public static final Color DARK = Color.rgb(93, 100, 110);
    public static final Color LIGHT = Color.rgb(255, 255, 255);
    public static final Color BORDER = Color.rgb(0, 0, 0);
    public static final Color SELECT = Color.rgb(60, 60, 90);
    
    public static Image bKing, bQueen, bRook, bBishop, bKnight, bPawn
        , wKing, wQueen, wRook, wBishop, wKnight, wPawn;
    
    static {
        initImages();
    }
    
    private Canvas canvas;
    private GraphicsContext gc;
    
    ChessPiece[][] pieces;
    
    /** z-level of the Board */
    private int z;
    
    public Board(int z) {
        this.canvas = new Canvas(BOARD_LENGTH, BOARD_LENGTH);
        this.gc = canvas.getGraphicsContext2D();
        this.z = z;
        this.pieces = new ChessPiece[8][8];
        
        canvas.setOnMouseMoved(this::handleMove);
        canvas.setOnMouseExited(this::renderBoard);
    }
    
    private void handleMove(MouseEvent e) {
        int row = (int) e.getY() / RECT_SIZE;
        int col = (int) e.getX() / RECT_SIZE;
        
        renderTiles();
        
        gc.setFill(SELECT);
        gc.fillRect(RECT_SIZE * col, RECT_SIZE * row, RECT_SIZE, RECT_SIZE);
        
        renderBorder();
        renderPieces();
    }
    
    // I'm sorry.
    public void renderBoard(MouseEvent e) {
        renderBoard();
    }
    
    public void renderBoard() {
        renderTiles();
        renderBorder();
        renderPieces();
    }
    
    private void renderTiles() {
        for (int row = 0; row < 8; row++)
            for (int col = 0; col < 8; col++) {
                gc.setFill((row + col) % 2 == 0 ? LIGHT : DARK);
                gc.fillRect(RECT_SIZE * col, (RECT_SIZE * row), RECT_SIZE, RECT_SIZE);
            }
    }
    
    private void renderPieces() {
        for (ChessPiece[] pieceRow : pieces)
            for (ChessPiece piece : pieceRow)
                if (piece != null)
                    gc.drawImage(piece.getImg(), piece.getCol() * RECT_SIZE, piece.getRow() * RECT_SIZE);
    }
    
    private void renderBorder() {
        gc.setStroke(BORDER);
        gc.setLineWidth(8);
        gc.strokeRect(0, 0, BOARD_LENGTH, BOARD_LENGTH);
    }
    
    public void initPieces(Player player) {
        int i = player.ordinal();
        for(int x = 0; x < 8; x++)
            pieces[1 + 5 * i][x] = new Pawn(1 + 5 * i, x, player);
        for(int j = 0; j < 2; j++)
            pieces[7 * i][7 * j] = new Rook(7 * i, 7 * j, player);
        for(int j = 0; j < 2; j++)
            pieces[7 * i][1 + 5 * j] = new Knight(7 * i, 1 + 5 * j, player);
        for(int j = 0; j < 2; j++)
            pieces[7 * i][2 + 3 * j] = new Bishop(7 * i, 2 + 3 * j, player);
        pieces[7 * i][3] = new Queen(7 * i, 3, player);
        pieces[7 * i][4] = new King(7 * i, 4, player);
    }
    
    public ChessPiece[][] getPieces() {
        return this.pieces;
    }
    
    public Canvas getCanvas() {
        return this.canvas;
    }
    
    private static void initImages() {
        bKing   = new Image("file:./img/bKing.png", RECT_SIZE, 0, true, false);
        bQueen  = new Image("file:./img/bQueen.png", RECT_SIZE, 0, true, false);
        bRook   = new Image("file:./img/bRook.png", RECT_SIZE, 0, true, false);
        bBishop = new Image("file:./img/bBishop.png", RECT_SIZE, 0, true, false);
        bKnight = new Image("file:./img/bKnight.png", RECT_SIZE, 0, true, false);
        bPawn   = new Image("file:./img/bPawn.png", RECT_SIZE, 0, true, false);
        
        wKing   = new Image("file:./img/wKing.png", RECT_SIZE, 0, true, false);
        wQueen  = new Image("file:./img/wQueen.png", RECT_SIZE, 0, true, false);
        wRook   = new Image("file:./img/wRook.png", RECT_SIZE, 0, true, false);
        wBishop = new Image("file:./img/wBishop.png", RECT_SIZE, 0, true, false);
        wKnight = new Image("file:./img/wKnight.png", RECT_SIZE, 0, true, false);
        wPawn   = new Image("file:./img/wPawn.png", RECT_SIZE, 0, true, false);
    }
    
}
