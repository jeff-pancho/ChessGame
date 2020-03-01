package main.chesspiece;

import main.Board;
import main.Player;

public class Queen extends ChessPiece {

    public Queen(int row, int col, int z, Player player) {
        super(row, col, z, player);
        this.img = player == Player.WHITE ? Board.wQueen : Board.bQueen;
    }

    @Override
    public boolean[][] calcMoves() {
        // TODO Auto-generated method stub
        return null;
    }

}
