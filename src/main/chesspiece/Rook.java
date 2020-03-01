package main.chesspiece;

import main.Board;
import main.Player;

public class Rook extends ChessPiece {

    public Rook(int row, int col, int z, Player player) {
        super(row, col, z, player);
        this.img = player == Player.WHITE ? Board.wRook : Board.bRook;
    }

    @Override
    public boolean[][] calcMoves() {
        // TODO Auto-generated method stub
        return null;
    }

}
