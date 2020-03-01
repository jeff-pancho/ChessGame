package main.chesspiece;

import main.Board;
import main.Player;

public class Queen extends ChessPiece {

    public Queen(int z, int row, int col, Player player) {
        super(z, row, col, player);
        this.img = player == Player.WHITE ? Board.wQueen : Board.bQueen;
    }
    
    @Override
    public boolean[][][] calcMoves(ChessPiece[][][] pieces) {
        boolean[][][] validMoves = new boolean[3][8][8];
        
        for (int i = 0; i < 8; i++) {
            for (int zStep = -1 ; zStep <= 1; zStep++) {
                int newZ = z;
                
                for (int step = 1; step < 8; step++) {
                    double dir = Math.PI / 4 * i;
                    int newRow = (int) Math.round(row + step * Math.sin(dir));
                    int newCol = (int) Math.round(col + step * Math.cos(dir));
                    newZ += zStep;
                    
                    if (isValid(newZ, newRow, newCol, pieces))
                        validMoves[newZ][newRow][newCol] = true;
                    else
                        break;
                }
            }
        }
        
        return validMoves;
    }

}
