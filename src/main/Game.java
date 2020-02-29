package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Game extends Application {
    public static final int WIDTH = Board.RECT_SIZE * 24;
    public static final int HEIGHT = Board.RECT_SIZE * 8;

    @Override
    public void start(Stage stage) throws Exception {
        Board3D board = new Board3D();
        Scene scene = new Scene(board.getHBox(), WIDTH, HEIGHT);
        
        stage.setScene(scene);
        stage.setTitle("ChessGame");
        stage.show();
        
        board.render();
    }
    
    public void run() {
        launch();
    }

}
