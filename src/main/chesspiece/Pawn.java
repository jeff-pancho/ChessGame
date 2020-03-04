package main.chesspiece;

import main.Board;
import main.Game;
import main.Player;

public class Pawn extends ChessPiece {
    private boolean firstMove = true;

    public Pawn(int z, int row, int col, Player player) {
        super(z, row, col, player);
        this.img = player == Player.WHITE ? Board.wPawn : Board.bPawn;
    }
    
    @Override
    public boolean[][][] calcMoves(ChessPiece[][][] pieces) {
        boolean[][][] validMoves = new boolean[Game.numBoards][8][8];
        
        int numSteps = firstMove ? 2 : 1;
        int direction = player.ordinal() * -2 + 1;
        
        for (int zStep = -1 ; zStep <= 1; zStep++) {
            int newZ = z;
            
            for (int steps = 1; steps <= numSteps; steps++) {
                int newRow = row + direction * steps;
                newZ += zStep;
                
                System.out.println(newRow + " " + newZ);
                if (isValid(newZ, newRow, col, pieces))
                    validMoves[newZ][newRow][col] = true;
                else
                    break;
            }
        }
        
        return validMoves;
    }
    
    @Override
    public void setPos(int z, int row, int col, ChessPiece[][][] pieces) {
        pieces[this.z][this.row][this.col] = null;
        this.z = z;
        this.row = row;
        this.col = col;
        pieces[z][row][col] = this;
        firstMove = false;
    }

}
