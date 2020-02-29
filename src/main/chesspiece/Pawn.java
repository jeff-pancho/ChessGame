package main.chesspiece;

import main.Board;
import main.Player;

public class Pawn extends ChessPiece {
    private boolean firstMove = true;

    public Pawn(int row, int col, Player player) {
        super(row, col, player);
        this.img = player == Player.WHITE ? Board.wPawn : Board.bPawn;
    }

    @Override
    public boolean[][] calcMoves() {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public void setPos(int row, int col, ChessPiece[][] pieces) {
        pieces[this.row][this.col] = null;
        this.row = row;
        this.col = col;
        pieces[row][col] = this;
        firstMove = false;
    }

}
