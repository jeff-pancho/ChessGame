package main.chesspiece;

import main.ChessPiece;
import main.Board;

public class Bishop extends ChessPiece {
    public Bishop(int row, int column, int playerNum) {
        super(row, column);
        this.img = playerNum == 1 ? Board.wBishop : Board.bBishop;
    }
}
