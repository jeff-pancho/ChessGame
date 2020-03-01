package main.chesspiece;

import main.Board;
import main.Player;

public class Rook extends ChessPiece {

    public Rook(int z, int row, int col, Player player) {
        super(z, row, col, player);
        this.img = player == Player.WHITE ? Board.wRook : Board.bRook;
    }

    @Override
    public boolean[][] calcMoves() {
        // TODO Auto-generated method stub
        return null;
    }

}
