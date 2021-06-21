package textstatistics;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class TextStatisticsApplication extends Application {

    @Override
    public void start(Stage window) {
        BorderPane components = new BorderPane();
        
        components.setCenter(new TextArea());
        
        HBox box = new HBox();
        box.setSpacing(10);
        box.getChildren().add(new Label("Letters: 0"));
        box.getChildren().add(new Label("Words: 0"));
        box.getChildren().add(new Label("The longest word is: "));
        
        components.setBottom(box);
        
        Scene view = new Scene(components);
        
        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
    }

}
