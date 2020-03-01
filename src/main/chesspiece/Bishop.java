package main.chesspiece;

import main.Board;
import main.Player;

public class Bishop extends ChessPiece {

    public Bishop(int z, int row, int col, Player player) {
        super(z, row, col, player);
        this.img = player == Player.WHITE ? Board.wBishop : Board.bBishop;
    }
    
    @Override
    public boolean[][][] calcMoves(ChessPiece[][][] pieces) {
        boolean[][][] validMoves = new boolean[3][8][8];
        
        for (int i = 0; i < 4; i++) {
            for (int zStep = -1 ; zStep <= 1; zStep++) {
                int newZ = z;
                
                for (int step = 1; step < 8; step++) {
                    double dir = Math.PI / 4 + Math.PI / 2 * i;
                    int newRow = (int) Math.round(row + step * Math.sin(dir) * Math.sqrt(2));
                    int newCol = (int) Math.round(col + step * Math.cos(dir) * Math.sqrt(2));
                    newZ += zStep;
                    
                    if (isValid(newZ, newRow, newCol, pieces)) {
                        validMoves[newZ][newRow][newCol] = true;
                    } else 
                        break; 
                }
            }
        }
        
        return validMoves;
    }

}
