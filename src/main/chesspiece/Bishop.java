package main.chesspiece;

import main.ChessPiece;
import main.Board;

public class Bishop extends ChessPiece {
    public Bishop(int row, int column, int playerNum) {
        super(row, column, playerNum);
        this.img = playerNum == 1 ? Board.wBishop : Board.bBishop;
    }

    @Override
    public boolean[][] calcMoves(ChessPiece[][] pieces) {
        // TODO Auto-generated method stub
        boolean[][] validMove = new boolean[8][8];
        
        
        return validMove;
    }
}
