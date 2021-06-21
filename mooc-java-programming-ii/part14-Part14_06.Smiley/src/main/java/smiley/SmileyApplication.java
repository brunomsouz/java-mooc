package smiley;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.layout.BorderPane;

public class SmileyApplication extends Application {

    @Override
    public void start(Stage window) {
        Canvas paintingCanvas = new Canvas(640, 640);
        GraphicsContext painter = paintingCanvas.getGraphicsContext2D();
        
        painter.setFill(Color.BLACK);
        painter.fillRect(160, 80, 80, 80);
        painter.fillRect(400, 80, 80, 80);
        painter.fillRect(80, 320, 80, 80);
        painter.fillRect(480, 320, 80, 80);
        painter.fillRect(160, 400, 320, 80);
        
        BorderPane layout = new BorderPane();                
        layout.setCenter(paintingCanvas);
        
        Scene view = new Scene(layout);
        
        window.setScene(view);
        window.show();
    }
    
    public static void main(String[] args) {
        launch(SmileyApplication.class);
    }

}
