package ticTacToe;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;


public class TicTacToeApplication extends Application {
    
    @Override
    public void start(Stage window) {
        BoardView view = new BoardView();
        
        Scene scene = new Scene(view.getView(), 200, 200);
        
        window.setScene(scene);
        window.show();
    }        

    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
    }

}
