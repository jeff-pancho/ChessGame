package main.chesspiece;

import main.Board;
import main.Player;

public class King extends ChessPiece {

    public King(int row, int col, Player player) {
        super(row, col, player);
        this.img = player == Player.WHITE ? Board.wKing : Board.bKing;
    }

    @Override
    public boolean[][] calcMoves() {
        // TODO Auto-generated method stub
        return null;
    }

}
