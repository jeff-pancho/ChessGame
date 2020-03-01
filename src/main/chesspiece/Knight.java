package main.chesspiece;

import main.Board;
import main.Player;

public class Knight extends ChessPiece {

    public Knight(int row, int col, int z, Player player) {
        super(row, col, z, player);
        this.img = player == Player.WHITE ? Board.wKnight : Board.bKnight;
    }

    @Override
    public boolean[][] calcMoves() {
        // TODO Auto-generated method stub
        return null;
    }

}
