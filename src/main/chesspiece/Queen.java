package main.chesspiece;

import main.ChessPiece;
import main.Board;

public class Queen extends ChessPiece {
    public Queen(int row, int column, int playerNum) {
        super(row, column);
        this.img = playerNum == 1 ? Board.wQueen : Board.bQueen;
    }
}
