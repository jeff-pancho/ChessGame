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
        
        for(int i = 0; i < 4; i++) {
            double dir = Math.PI / 2 * i;
            int newRow = (int) Math.round( row + 2 * Math.sin(dir) + Math.sin(dir + quarter) );
            int newColumn = (int) Math.round( column + 2 * Math.cos(dir) + Math.cos(dir + quarter) );
            if(!isPastBoundary(newRow) && !isPastBoundary(newColumn) && !isOccupied(pieces, newRow, newColumn))
                validMove[newRow][newColumn] = true;
        }
        for(int i = 0; i < 4; i++) {
            double dir = Math.PI / 2 * i;
            int newRow = (int) Math.round( row + 2 * Math.sin(dir) + Math.sin(dir - quarter) );
            int newColumn = (int) Math.round( column + 2 * Math.cos(dir) + Math.cos(dir - quarter) );
            if(!isPastBoundary(newRow) && !isPastBoundary(newColumn) && !isOccupied(pieces, newRow, newColumn))
                validMove[newRow][newColumn] = true;
        }
        
        return validMove;
    }
}
