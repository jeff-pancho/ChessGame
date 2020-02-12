package main.chesspiece;

import main.ChessPiece;
import main.Board;

public class Knight extends ChessPiece {
    public Knight(int row, int column, int playerNum) {
        super(row, column, playerNum);
        this.img = playerNum == 1 ? Board.wKnight : Board.bKnight;
    }

    @Override
    public boolean[][] calcMoves(ChessPiece[][] pieces) {
        // TODO Auto-generated method stub
        boolean[][] validMove = new boolean[8][8];
        final double quarter = Math.PI / 2;
        
        for(int i = 0; i < 8; i++) {
            double dir1 = Math.PI / 2 * i;
            double dir2 = dir1 + quarter * (i > 3 ? -1 : 1);
            int newRow = (int) Math.round( row + 2 * Math.sin(dir1) + Math.sin(dir2) );
            int newColumn = (int) Math.round( column + 2 * Math.cos(dir1) + Math.cos(dir2) );
            if(!isPastBoundary(newRow, newColumn) && !isOccupied(pieces, newRow, newColumn))
                validMove[newRow][newColumn] = true;
        }
        
        return validMove;
    }
}
