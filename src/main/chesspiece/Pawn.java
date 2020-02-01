package main.chesspiece;

import main.ChessPiece;
import main.Board;

public class Pawn extends ChessPiece {
    public Pawn(int row, int column, int playerNum) {
        super(row, column);
        this.img = playerNum == 1 ? Board.wPawn : Board.bPawn;
    }
}
