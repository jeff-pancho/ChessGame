package main.chesspiece;

import main.ChessPiece;
import main.Board;

public class Knight extends ChessPiece {
    public Knight(int row, int column, int playerNum) {
        super(row, column, playerNum);
        this.img = playerNum == 1 ? Board.wKnight : Board.bKnight;
    }

    @Override
    public boolean[][] calcMoves(ChessPiece[][] pieces) {
        // TODO Auto-generated method stub
        boolean[][] validMove = new boolean[8][8];
        
        return validMove;
    }
}
