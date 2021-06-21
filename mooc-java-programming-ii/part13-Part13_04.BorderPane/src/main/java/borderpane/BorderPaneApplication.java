package borderpane;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class BorderPaneApplication extends Application {

    @Override
    public void start(Stage window) {
        BorderPane components = new BorderPane();
        
        components.setTop(new Label("NORTH"));
        components.setLeft(new Label("WEST"));
        components.setRight(new Label("EAST"));
        components.setBottom(new Label("SOUTH"));
        
        Scene view = new Scene(components);
        
        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
        launch(BorderPaneApplication.class);
    }

}
