package main.chesspiece;

import javafx.scene.image.Image;

public abstract class ChessPiece {
    protected int row;
    protected int column;
    protected Image img;
    
    public void setPos(int row, int column, ChessPiece[][] pieces) {
        
    }
    
    public abstract boolean[][] calcMoves();
    
    protected boolean isPastBoundary(int row, int column) {
        return row < 0 || row > 7 || column < 0 || column > 7;
    }
    
    protected boolean isOccupied(ChessPiece[][] pieces, int row, int column) {
        return pieces[row][column] != null;
    }
}
