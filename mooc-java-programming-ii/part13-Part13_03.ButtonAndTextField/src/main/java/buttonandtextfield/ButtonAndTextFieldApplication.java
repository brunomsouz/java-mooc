package buttonandtextfield;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;

public class ButtonAndTextFieldApplication extends Application {

    @Override
    public void start(Stage window) {
        window.setTitle("Exercise 13-03");
        
        TextField field = new TextField();
        Button button = new Button("Ok");
        
        FlowPane components = new FlowPane();
        components.getChildren().add(button);
        components.getChildren().add(field);
        
        Scene view = new Scene(components);
        
        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
        launch(ButtonAndTextFieldApplication.class);
    }

}
