package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MultipleViews extends Application {
    @Override
    public void start(Stage window) {
        Label firstViewLabel = new Label("First view!");
        Button firstViewButton = new Button("To the second view!");
        Label secondViewLabel = new Label("Second view!");
        Button secondViewButton = new Button("To the third view!");
        Label thirdViewLabel = new Label("Third view!");
        Button thirdViewButton = new Button("To the first view!");
                
        BorderPane firstViewComponents = new BorderPane();        
        firstViewComponents.setTop(firstViewLabel);
        firstViewComponents.setCenter(firstViewButton);
        
        VBox secondViewComponents = new VBox();        
        secondViewComponents.getChildren().add(secondViewButton);
        secondViewComponents.getChildren().add(secondViewLabel);
        
        GridPane thirdViewComponents = new GridPane();        
        thirdViewComponents.add(thirdViewLabel, 0, 0);
        thirdViewComponents.add(thirdViewButton, 1, 1);
        
        Scene first = new Scene(firstViewComponents);
        Scene second = new Scene(secondViewComponents);
        Scene third = new Scene(thirdViewComponents);
        
        firstViewButton.setOnAction((event) -> {
            window.setScene(second);
        });

        secondViewButton.setOnAction((event) ->  {
            window.setScene(third);
        });             
        
        thirdViewButton.setOnAction((event) -> {
            window.setScene(first);
        });

        window.setTitle("Excercise 13-10 - GreeterApplication");
        window.setScene(first);
        window.show();
    }
    
    public static void main(String[] args) {
        launch(MultipleViews.class);
    }
}