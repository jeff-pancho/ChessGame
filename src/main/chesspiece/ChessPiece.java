package main.chesspiece;

import javafx.scene.image.Image;
import main.Player;

public abstract class ChessPiece {
    protected int z;
    protected int row;
    protected int col;
    protected Image img;
    protected Player player;
    
    public ChessPiece(int z, int row, int col, Player player) {
        this.z = z;
        this.row = row;
        this.col = col;
        this.player = player;
    }
    
    public void setPos(int z, int row, int col, ChessPiece[][][] pieces) {
        pieces[this.z][this.row][this.col] = null;
        this.z = z;
        this.row = row;
        this.col = col;
        pieces[z][row][col] = this;
    }
    
//    public abstract boolean[][] calcMoves();
    public boolean[][][] calcMoves(ChessPiece[][][] pieces) {
        boolean[][][] validMoves = new boolean[3][8][8];
        for (boolean[][] z : validMoves)
            for (boolean[] y : z)
                for (int i = 0; i < 8; i++)
                    y[i] = true;
        return validMoves;
    }
    
    protected boolean isPastBoundary(int z, int row, int col) {
        return row < 0 || row > 7 || col < 0 || col > 7 || z < 0 || z > 2;
    }
    
    protected boolean isOccupied(ChessPiece[][][] pieces, int z, int row, int col) {
        return pieces[z][row][col] != null;
    }
    
    public int getRow() {
        return this.row;
    }
    
    public int getCol() {
        return this.col;
    }
    
    public int getZ() {
        return this.z;
    }
    
    public Image getImg() {
        return this.img;
    }
}
