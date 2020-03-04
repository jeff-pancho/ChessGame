package main.chesspiece;

import main.Board;
import main.Game;
import main.Player;

public class King extends ChessPiece {

    public King(int z, int row, int col, Player player) {
        super(z, row, col, player);
        this.img = player == Player.WHITE ? Board.wKing : Board.bKing;
    }
    
    @Override
    public boolean[][][] calcMoves(ChessPiece[][][] pieces) {
        boolean[][][] validMoves = new boolean[Game.numBoards][8][8];
        
        for (int i = 0; i < 8; i++) {
            for (int zStep = -1 ; zStep <= 1; zStep++) {
                double dir = Math.PI / 4 * i;
                int newRow = (int) Math.round(row + Math.sin(dir));
                int newCol = (int) Math.round(col + Math.cos(dir));
                int newZ = z + zStep;
                
                if (isValid(newZ, newRow, newCol, pieces))
                    validMoves[newZ][newRow][newCol] = true;
            }
        }
        
        return validMoves;
    }

}
