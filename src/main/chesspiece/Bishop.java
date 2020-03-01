package main.chesspiece;

import main.Board;
import main.Player;

public class Bishop extends ChessPiece {

    public Bishop(int row, int col, int z, Player player) {
        super(row, col, z, player);
        this.img = player == Player.WHITE ? Board.wBishop : Board.bBishop;
    }

    @Override
    public boolean[][] calcMoves() {
        // TODO Auto-generated method stub
        return null;
    }

}
