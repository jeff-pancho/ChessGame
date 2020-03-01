package main.chesspiece;

import main.Board;
import main.Player;

public class Bishop extends ChessPiece {

    public Bishop(int z, int row, int col, Player player) {
        super(z, row, col, player);
        this.img = player == Player.WHITE ? Board.wBishop : Board.bBishop;
    }

}
