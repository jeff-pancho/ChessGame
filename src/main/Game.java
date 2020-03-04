package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import main.chesspiece.ChessPiece;

public class Game extends Application {
    public static final int PADDING = 8;
    public static final int WIDTH = Board.RECT_SIZE * 24 + PADDING * 4;
    public static final int HEIGHT = Board.RECT_SIZE * 8 + PADDING * 2;
    
    private Board3D board3d;
    
    private ChessPiece curPiece;
    private boolean[][][] validMoves;
    
    private Player curPlayer;

    @Override
    public void start(Stage stage) throws Exception {
        board3d = new Board3D();
        validMoves = new boolean[3][8][8];
        Scene scene = new Scene(board3d.getHBox(), WIDTH, HEIGHT, Board.BORDER);
        curPlayer = Player.WHITE;
        
        
        initStage(stage, scene);
        
        for (Board board : board3d.getBoards()) {
            board.setOnMouseClicked(this::onClick);
            board.setOnMouseMoved(this::renderMouseLocation);
            board.setOnMouseExited(this::renderExitBoard);
        }
        
        board3d.render();
    }
    
    /*
     * WARNING: EVERYTHING BELOW THIS POINT IS A BIOLOGICAL HAZARD
     * PLEASE DON'T LOOK AT MY CODE. I'M SO SORRY MOTHER, FATHER,
     * EVERYONE. I'LL BE OFF NOW.
     */
    
    private void onClick(MouseEvent e) {
        Board srcBoard = (Board) e.getSource();
        int z = srcBoard.getZ();
        int row = (int) e.getY() / Board.RECT_SIZE;
        int col = (int) e.getX() / Board.RECT_SIZE;
        
        if (curPiece == null) {
            if((curPiece = srcBoard.getPiece(row, col)) != null && curPlayer == curPiece.getPlayer()) {
                validMoves = curPiece.calcMoves(board3d.getPieces());
                renderValidMoves();
                srcBoard.renderSelect(row, col);
                srcBoard.renderPiece(row, col);
            } else 
                curPiece = null;
        } else {
            if (validMoves[z][row][col]) {
                curPiece.setPos(z, row, col, board3d.getPieces());
                curPlayer = curPlayer == Player.WHITE ? Player.BLACK : Player.WHITE;
            }
            curPiece = null;
            validMoves = new boolean[3][8][8];
            board3d.render();
            srcBoard.renderMouseLocation(row, col);
            srcBoard.renderPieces();
        }
    }
    
    private void renderValidMoves() {
        Board[] boards = board3d.getBoards();
        for (int i = 0; i < Board3D.NUM_BOARDS; i++) {
            boards[i].renderValidMoves(validMoves[i]);
            boards[i].renderPieces();
        }
    }
    
    private void renderMouseLocation(MouseEvent e) {
        Board srcBoard = (Board) e.getSource();
        int row = (int) e.getY() / Board.RECT_SIZE;
        int col = (int) e.getX() / Board.RECT_SIZE;
        
        srcBoard.renderTiles();
        srcBoard.renderMouseLocation(row, col);
        srcBoard.renderValidMoves(validMoves[srcBoard.getZ()]);
        
        if (curPiece != null) {
            Board curBoard = board3d.getBoard(curPiece.getZ());
            curBoard.renderSelect(curPiece.getRow(), curPiece.getCol());
            if (curBoard != srcBoard)
                curBoard.renderPiece(curPiece.getRow(), curPiece.getCol());
        }
        
        srcBoard.renderPieces();
    }
    
    private void renderExitBoard(MouseEvent e) {
        Board srcBoard = (Board) e.getSource();
        
        srcBoard.renderTiles();
        srcBoard.renderValidMoves(validMoves[srcBoard.getZ()]);
        
        if (curPiece != null) {
            Board curBoard = board3d.getBoard(curPiece.getZ());
            curBoard.renderSelect(curPiece.getRow(), curPiece.getCol());
            if (curBoard != srcBoard)
                curBoard.renderPiece(curPiece.getRow(), curPiece.getCol());
        }
        
        srcBoard.renderPieces();
    }
    
    private void initStage(Stage stage, Scene scene) {
        stage.setScene(scene);
        stage.setTitle("ChessGame");
        stage.setResizable(false);
//        stage.setMaxWidth(WIDTH);
//        stage.setMaxWidth(WIDTH);
//        stage.setMaxHeight(HEIGHT);
//        stage.setMinHeight(HEIGHT);
        stage.show();
    }
    
    public void run() {
        launch();
    }

}
