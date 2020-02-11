package main;

import javafx.scene.image.Image;

public abstract class ChessPiece {
    protected int row;
    protected int column;
    protected Image img;
    
    public ChessPiece(int row, int column) {
        this.row = row;
        this.column = column;
    }
    
//    abstract void setPos(int row, int column);
    public void setPos(int row, int column, ChessPiece[][] pieces) {
        pieces[row][column] = null;
        this.row = row;
        this.column = column;
        pieces[row][column] = this;
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
