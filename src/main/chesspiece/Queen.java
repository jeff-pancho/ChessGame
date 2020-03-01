package main.chesspiece;

import main.Board;
import main.Player;

public class Queen extends ChessPiece {

    public Queen(int z, int row, int col, Player player) {
        super(z, row, col, player);
        this.img = player == Player.WHITE ? Board.wQueen : Board.bQueen;
    }

}
