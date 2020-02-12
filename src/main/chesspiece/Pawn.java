package main.chesspiece;

import main.ChessPiece;
import main.Board;

public class Pawn extends ChessPiece {
    private boolean firstMove = true;
    
    public Pawn(int row, int column, int playerNum) {
        super(row, column, playerNum);
        this.img = playerNum == 1 ? Board.wPawn : Board.bPawn;
    }

    @Override
    public boolean[][] calcMoves(ChessPiece[][] pieces) {
        // TODO Auto-generated method stub
        boolean[][] validMove = new boolean[8][8];
        
        int num = firstMove ? 1 : 0;
        int newRow = row;
        for(int i = 0; i < 1 + num; i++) {
            newRow += playerNum * -2 + 1;
            if(!isPastBoundary(newRow, column) && !isOccupied(pieces, newRow, column))
                validMove[newRow][column] = true;
            else
                break;
        }
        
        return validMove;
    }
    
    public void setPos(int row, int column, ChessPiece[][] pieces) {
        pieces[this.row][this.column] = null;
        this.row = row;
        this.column = column;
        pieces[row][column] = this;
        firstMove = false;
    }
}
