package main;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;

public class Game extends Application {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 800;
    
    
    @Override
    public void start(Stage stage) throws Exception {
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        Board board = new Board(canvas.getGraphicsContext2D());
        Player[] players = {new Player(), new Player()};
        
        Group root = new Group(canvas);
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        stage.setScene(scene);
        stage.setTitle("ChessGame");
        stage.show();
        
        board.initPieces();
        board.renderBoard();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
