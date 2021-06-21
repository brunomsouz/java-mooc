package notifier;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class NotifierApplication extends Application {

    public void start(Stage window) {
        Button button = new Button("Update");
        TextField field = new TextField();
        Label text = new Label();
        
        button.setOnAction((event) -> {
            text.setText(field.getText());
        });
        
        VBox box = new VBox();
        box.getChildren().addAll(field, button, text);
        
        Scene view = new Scene(box);
        
        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
        launch(NotifierApplication.class);
    }

}
