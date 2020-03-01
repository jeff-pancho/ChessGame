package main.chesspiece;

import main.Board;
import main.Player;

public class Knight extends ChessPiece {

    public Knight(int z, int row, int col, Player player) {
        super(z, row, col, player);
        this.img = player == Player.WHITE ? Board.wKnight : Board.bKnight;
    }

}
