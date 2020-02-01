package main;

import javafx.scene.image.Image;

public abstract class ChessPiece {
    protected int row;
    protected int column;
    protected Image img;
    
    ChessPiece(int row, int column, Image img) {
        this.row = row;
        this.column = column;
        this.img = img;
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
