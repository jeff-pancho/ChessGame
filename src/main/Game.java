package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Game extends Application {
    public static final int WIDTH = Board.RECT_SIZE * 24;
    public static final int HEIGHT = Board.RECT_SIZE * 8;
    
    private Board3D boards;

    @Override
    public void start(Stage stage) throws Exception {
        boards = new Board3D();
        Scene scene = new Scene(boards.getHBox(), WIDTH, HEIGHT);
        
        initStage(stage, scene);
        
        scene.setOnMouseMoved(this::handleMove);
        for (int i = 0; i < Board3D.NUM_BOARDS; i++)
            boards.getBoard(i).setOnMouseExited(this::handleExit);
        
        boards.render();
    }
    
    private void handleMove(MouseEvent e) {
        int z = (int) e.getX() / Board.LENGTH;
        int row = (int) e.getY() / Board.RECT_SIZE;
        int col = (int) (e.getX() - (z * Board.LENGTH)) / Board.RECT_SIZE;
        
        Board srcBoard = boards.getBoard(z);
        srcBoard.renderSelect(row, col);
    }
    
    private void handleExit(MouseEvent e) {
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
