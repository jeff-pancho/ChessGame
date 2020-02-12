package main.chesspiece;

import main.ChessPiece;
import main.Board;

public class King extends ChessPiece {
    public King(int row, int column, int playerNum) {
        super(row, column, playerNum);
        this.img = playerNum == 1 ? Board.wKing : Board.bKing;
    }

    @Override
    public boolean[][] calcMoves(ChessPiece[][] pieces) {
        // TODO Auto-generated method stub
        boolean[][] validMove = new boolean[8][8];
        
        for(int i = 0; i < 8; i++) {
            double dir = Math.PI / 4 * i;
            int newRow = (int) Math.round(row + Math.sin(dir));
            int newColumn = (int) Math.round(column + Math.cos(dir));
            if(!isPastBoundary(newRow, newColumn) && !isOccupied(pieces, newRow, newColumn))
                validMove[newRow][newColumn] = true;
        }
        
        return validMove;
    }
}
