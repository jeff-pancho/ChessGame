package main.chesspiece;

import main.Board;
import main.Game;
import main.Player;

public class Knight extends ChessPiece {

    public Knight(int z, int row, int col, Player player) {
        super(z, row, col, player);
        this.img = player == Player.WHITE ? Board.wKnight : Board.bKnight;
    }
    
    @Override
    public boolean[][][] calcMoves(ChessPiece[][][] pieces) {
        boolean[][][] validMoves = new boolean[Game.numBoards][8][8];
        final double quarter = Math.PI / 2;
        
            
        for (int i = 0; i < 8; i++) {
            for (int zStep = -1; zStep <= 1; zStep++) {
                double dir1 = Math.PI / 2 * i;
                double dir2 = dir1 + quarter * (i > 3 ? -1 : 1);
                int newRow = (int) Math.round(row + 2 * Math.sin(dir1) + Math.sin(dir2));
                int newCol = (int) Math.round(col + 2 * Math.cos(dir1) + Math.cos(dir2));
                int newZ = z + zStep;
                
                if (isValid(newZ, newRow, newCol, pieces))
                    validMoves[newZ][newRow][newCol] = true;
            }
        }
        
        return validMoves;
    }

}
