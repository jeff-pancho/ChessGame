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
        boolean isLeftOccupied = false;
        boolean isRightOccupied = false;
        boolean isUpOccupied = false;
        boolean isDownOccupied = false;
        
        for(int i = 1; i < 8; i++) {
            if(!isPastBoundary(column - i) && !isLeftOccupied)
                if(!isOccupied(pieces, row, column - i))
                    validMove[row][column - i] = true;
                else
                    isLeftOccupied = true;
            if(!isPastBoundary(column + i) && !isRightOccupied)
                if(!isOccupied(pieces, row, column + i))
                    validMove[row][column + i] = true;
                else
                    isRightOccupied = true;
            if(!isPastBoundary(row - i) && !isUpOccupied)
                if(!isOccupied(pieces, row - i, column))
                    validMove[row - i][column] = true;
                else
                    isUpOccupied = true;
            if(!isPastBoundary(row + i) && !isDownOccupied)
                if(!isOccupied(pieces, row + i, column))
                    validMove[row + i][column] = true;
                else
                    isDownOccupied = true;
            
        }
        validMove[row][column] = false;
        return validMove;
    }
}
