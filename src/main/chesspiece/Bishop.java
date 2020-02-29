package main.chesspiece;

import main.Board;
import main.Player;

public class Bishop extends ChessPiece {

    public Bishop(int row, int col, Player player) {
        super(row, col, player);
        this.img = player == Player.WHITE ? Board.wBishop : Board.bBishop;
    }

    @Override
    public boolean[][] calcMoves() {
        // TODO Auto-generated method stub
        return null;
    }

}
