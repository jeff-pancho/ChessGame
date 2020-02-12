package main.chesspiece;

import main.ChessPiece;
import main.Board;

public class Rook extends ChessPiece {
    public Rook(int row, int column, int playerNum) {
        super(row, column, playerNum);
        this.img = playerNum == 1 ? Board.wRook : Board.bRook;
    }

    @Override
    public boolean[][] calcMoves(ChessPiece[][] pieces) {
        // TODO Auto-generated method stub
        boolean[][] validMove = new boolean[8][8];
        boolean[] occupied = new boolean[4];
        
        for(int i = 1; i < 8; i++) {
            for(int j = 0; j < occupied.length; j++) {
                double dir = Math.PI / 2 * j;
                int newRow = (int) Math.round(row + i * Math.sin(dir));
                int newColumn = (int) Math.round(column + i * Math.cos(dir));
                if(!isPastBoundary(newRow, newColumn) && !occupied[j])
                    if(!isOccupied(pieces, newRow, newColumn))
                        validMove[newRow][newColumn] = true;
                else
                    occupied[j] = true;
            }
        }
        
        validMove[row][column] = false;
        return validMove;
    }
}
