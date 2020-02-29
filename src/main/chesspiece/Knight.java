package main.chesspiece;

import main.Board;
import main.Player;

public class Knight extends ChessPiece {

    public Knight(int row, int col, Player player) {
        super(row, col, player);
        this.img = player == Player.WHITE ? Board.wKnight : Board.bKnight;
    }

    @Override
    public boolean[][] calcMoves() {
        // TODO Auto-generated method stub
        return null;
    }

}
