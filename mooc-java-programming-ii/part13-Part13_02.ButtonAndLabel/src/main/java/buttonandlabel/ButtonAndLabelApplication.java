package buttonandlabel;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;

public class ButtonAndLabelApplication extends Application {

    @Override
    public void start(Stage window) {
        window.setTitle("Janela de teste");
        
        Label text = new Label("Here's some text.");
        Button button = new Button("Ok!");
        
        FlowPane components = new FlowPane();
        components.getChildren().add(text);
        components.getChildren().add(button);
        
        Scene view = new Scene(components);
        
        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
        launch(ButtonAndLabelApplication.class);
    }

}
