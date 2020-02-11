package main.chesspiece;

import main.ChessPiece;
import main.Board;

public class Rook extends ChessPiece {
    public Rook(int row, int column, int playerNum) {
        super(row, column, playerNum);
        this.img = playerNum == 1 ? Board.wRook : Board.bRook;
    }

    @Override
    public boolean[][] calcMoves(ChessPiece[][] pieces) {
        // TODO Auto-generated method stub
        boolean[][] validMove = new boolean[8][8];
        
        return validMove;
    }
}
