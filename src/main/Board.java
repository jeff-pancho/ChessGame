package main;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import main.chesspiece.Bishop;
import main.chesspiece.ChessPiece;
import main.chesspiece.King;
import main.chesspiece.Knight;
import main.chesspiece.Pawn;
import main.chesspiece.Queen;
import main.chesspiece.Rook;

public class Board extends Canvas {
    public static final int RECT_SIZE = 75;
    public static final int LENGTH = RECT_SIZE * 8;
    public static final int BORDER_SIZE = 8;
    
    public static final Color DARK = Color.rgb(90, 100, 110);
    public static final Color LIGHT = Color.rgb(255, 255, 255);
    public static final Color BORDER = Color.rgb(0, 0, 0);
    public static final Color MOUSE = Color.rgb(60, 60, 90);
    public static final Color SELECT = Color.rgb(180, 50, 50);
    
    public static Image bKing, bQueen, bRook, bBishop, bKnight, bPawn
        , wKing, wQueen, wRook, wBishop, wKnight, wPawn;
    
    static {
        initImages();
    }
    
    private GraphicsContext gc;
    
    ChessPiece[][] pieces;
    
    /** z-level of the Board */
    private int z;
    
    public Board(int z) {
        super(LENGTH, LENGTH);
//        this.canvas = new Canvas(LENGTH, LENGTH);
        this.gc = getGraphicsContext2D();
        this.z = z;
        this.pieces = new ChessPiece[8][8];
        
    }
    
    public void renderMouseLocation(int row, int col) {
        renderTiles();
        
        gc.setFill(MOUSE);
        gc.fillRect(RECT_SIZE * col, RECT_SIZE * row, RECT_SIZE, RECT_SIZE);
        
        renderBorder();
        renderPieces();
    }
    
    public void renderSelect(int row, int col) {
        gc.setFill(SELECT);
//        gc.setLineWidth(BORDER_SIZE);
        gc.fillRect(RECT_SIZE * col, RECT_SIZE * row, RECT_SIZE, RECT_SIZE);
        renderBorder();
//        renderPieces();
        renderPiece(z, row, col);
    }
    
    public void renderBoard() {
        renderTiles();
        renderBorder();
        renderPieces();
    }
    
    public void renderTiles() {
        for (int row = 0; row < 8; row++)
            for (int col = 0; col < 8; col++) {
                gc.setFill((row + col) % 2 == 0 ? LIGHT : DARK);
                gc.fillRect(RECT_SIZE * col, (RECT_SIZE * row), RECT_SIZE, RECT_SIZE);
            }
    }
    
    public void renderPieces() {
        for (ChessPiece[] pieceRow : pieces)
            for (ChessPiece piece : pieceRow)
                if (piece != null)
                    renderPiece(piece.getZ(), piece.getRow(), piece.getCol());
    }
    
    public void renderPiece(int z, int row, int col) {
        ChessPiece piece = pieces[row][col];
        if (pieces != null)
            gc.drawImage(piece.getImg(), col * RECT_SIZE, row * RECT_SIZE);
    }
    
    public void renderBorder() {
        gc.setStroke(BORDER);
        gc.setLineWidth(BORDER_SIZE);
        gc.strokeRect(0, 0, LENGTH, LENGTH);
    }
    
    public void initPieces(Player player) {
        int i = player.ordinal();
        for(int x = 0; x < 8; x++)
            pieces[1 + 5 * i][x] = new Pawn(z, 1 + 5 * i, x, player);
        for(int j = 0; j < 2; j++)
            pieces[7 * i][7 * j] = new Rook(z, 7 * i, 7 * j, player);
        for(int j = 0; j < 2; j++)
            pieces[7 * i][1 + 5 * j] = new Knight(z, 7 * i, 1 + 5 * j, player);
        for(int j = 0; j < 2; j++)
            pieces[7 * i][2 + 3 * j] = new Bishop(z, 7 * i, 2 + 3 * j, player);
        pieces[7 * i][3] = new Queen(z, 7 * i, 3, player);
        pieces[7 * i][4] = new King(z, 7 * i, 4, player);
    }
    
    public int getZ() {
        return this.z;
    }
    
    public ChessPiece[][] getPieces() {
        return this.pieces;
    }
    
    public ChessPiece getPiece(int row, int col) {
        return this.pieces[row][col];
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
