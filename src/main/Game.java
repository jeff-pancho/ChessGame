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
    
    private Board curBoard;
    private ChessPiece curPiece;

    @Override
    public void start(Stage stage) throws Exception {
        board3d = new Board3D();
        Scene scene = new Scene(board3d.getHBox(), WIDTH, HEIGHT);
        
        initStage(stage, scene);
        
        for (Board board : board3d.getBoards()) {
            board.setOnMouseClicked(this::onClick);
            board.setOnMouseMoved(this::renderSelect);
            board.setOnMouseExited(this::exitBoard);
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
            System.out.println(curPiece);
        } else {
            Board oldBoard = board3d.getBoard(curPiece.getZ());
            curPiece.setPos(row, col, z, oldBoard.getPieces(), srcBoard.getPieces());
            oldBoard.renderBoard();
            srcBoard.renderSelect(row, col);
            curPiece = null;
        }
    }
    
    private void renderSelect(MouseEvent e) {
        int row = (int) e.getY() / Board.RECT_SIZE;
        int col = (int) e.getX() / Board.RECT_SIZE;
        
        Board srcBoard = (Board) e.getSource();
        srcBoard.renderSelect(row, col);
    }
    
    private void exitBoard(MouseEvent e) {
        Board srcBoard = (Board) e.getSource();
        srcBoard.renderBoard();
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
