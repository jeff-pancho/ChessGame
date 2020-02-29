package main.chesspiece;

import javafx.scene.image.Image;
import main.Player;

public abstract class ChessPiece {
    protected int row;
    protected int col;
    protected Image img;
    protected Player player;
    
    public ChessPiece(int row, int col, Player player) {
        this.row = row;
        this.col = col;
        this.player = player;
    }
    
    public void setPos(int row, int col, ChessPiece[][] pieces) {
        pieces[this.row][this.col] = null;
        this.row = row;
        this.col = col;
        pieces[row][col] = this;
    }
    
    public abstract boolean[][] calcMoves();
    
    protected boolean isPastBoundary(int row, int col) {
        return row < 0 || row > 7 || col < 0 || col > 7;
    }
    
    protected boolean isOccupied(ChessPiece[][] pieces, int row, int col) {
        return pieces[row][col] != null;
    }
    
    public int getRow() {
        return this.row;
    }
    
    public int getCol() {
        return this.col;
    }
    
    public Image getImg() {
        return this.img;
    }
}
