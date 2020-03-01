package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import main.chesspiece.ChessPiece;

public class Game extends Application {
    public static final int WIDTH = Board.RECT_SIZE * 24;
    public static final int HEIGHT = Board.RECT_SIZE * 8;
    
    private Board3D board3d;
    
    private ChessPiece curPiece;

    @Override
    public void start(Stage stage) throws Exception {
        board3d = new Board3D();
        Scene scene = new Scene(board3d.getHBox(), WIDTH, HEIGHT);
        
        initStage(stage, scene);
        
        for (Board board : board3d.getBoards()) {
            board.setOnMouseClicked(this::onClick);
            board.setOnMouseMoved(this::renderMouseLocation);
            board.setOnMouseExited(this::renderExitBoard);
        }
        
        board3d.render();
    }
    
    private void onClick(MouseEvent e) {
        Board srcBoard = (Board) e.getSource();
        int z = srcBoard.getZ();
        int row = (int) e.getY() / Board.RECT_SIZE;
        int col = (int) e.getX() / Board.RECT_SIZE;
        
        
        if (curPiece == null) {
            curPiece = srcBoard.getPiece(row, col);
            srcBoard.renderSelect(row, col);
        } else {
            Board oldBoard = board3d.getBoard(curPiece.getZ());
            curPiece.setPos(z, row, col, board3d.getPieces());
            oldBoard.renderBoard();
            srcBoard.renderMouseLocation(row, col);
            curPiece = null;
        }
    }
    
    private void renderMouseLocation(MouseEvent e) {
        Board srcBoard = (Board) e.getSource();
        int row = (int) e.getY() / Board.RECT_SIZE;
        int col = (int) e.getX() / Board.RECT_SIZE;
        
        srcBoard.renderMouseLocation(row, col);
        
        // Lord forgive me, for I have sinned.
        if (curPiece != null) {
            Board curBoard = board3d.getBoard(curPiece.getZ());
            curBoard.renderSelect(curPiece.getRow(), curPiece.getCol());
        }
    }
    
    private void renderExitBoard(MouseEvent e) {
        Board srcBoard = (Board) e.getSource();
        srcBoard.renderTiles();
        srcBoard.renderBorder();
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
