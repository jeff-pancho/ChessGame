package main.chesspiece;

import main.ChessPiece;
import main.Board;

public class Rook extends ChessPiece {
    public Rook(int row, int column, int playerNum) {
        super(row, column);
        this.img = playerNum == 1 ? Board.wRook : Board.bRook;
    }
}
