package main;

import javafx.scene.image.Image;

public abstract class ChessPiece {
    protected int row;
    protected int column;
    protected Image img;
    protected int playerNum;
    
    public ChessPiece(int row, int column, int playerNum) {
        this.row = row;
        this.column = column;
        this.playerNum = playerNum;
    }
    
//    abstract void setPos(int row, int column);
    public void setPos(int row, int column, ChessPiece[][] pieces) {
        pieces[this.row][this.column] = null;
        this.row = row;
        this.column = column;
        pieces[row][column] = this;
    }
    
    public abstract boolean[][] calcMoves(ChessPiece[][] pieces);
    
    protected boolean isPastBoundary(int row, int column) {
        return row < 0 || row > 7 || column < 0 || column > 7;
    }
    
    protected boolean isOccupied(ChessPiece[][] pieces, int row, int column) {
        return pieces[row][column] != null;
    }
    
    public int getRow() {
        return this.row;
    }
    
    public int getColumn() {
        return this.column;
    }
    
    public Image getImg() {
        return this.img;
    }
}
