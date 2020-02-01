package main.chesspiece;

import main.ChessPiece;
import main.Board;

public class Knight extends ChessPiece {
    public Knight(int row, int column, int playerNum) {
        super(row, column);
        this.img = playerNum == 1 ? Board.wKnight : Board.bKnight;
    }
}
