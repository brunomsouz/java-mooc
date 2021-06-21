package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class JokeApplication extends Application {

    @Override
    public void start(Stage window) {
        // creating the main layout
        BorderPane layout = new BorderPane();
        
        // creating the buttons
        Button joke = new Button("Joke");
        Button answer = new Button("Answer");
        Button explanation = new Button("Explanation");
        
        // creating the menu
        HBox menu = new HBox();
        menu.getChildren().addAll(joke, answer, explanation);
        menu.setPadding(new Insets(20, 20, 20, 20));
        menu.setSpacing(20);
        
        // creating views
        StackPane jokeView = createView("What do you call a bear with no teeth?");
        StackPane answerView = createView("A gummy bear.");
        StackPane explanationView = createView("Terrible joke, if you have no teeth you have just gums");
        
        // initializing the layout with jokeView
        layout.setTop(menu);
        layout.setCenter(jokeView);
        
        // creating actions
        joke.setOnAction((event) -> layout.setCenter(jokeView));
        answer.setOnAction((event) -> layout.setCenter(answerView));
        explanation.setOnAction((event) -> layout.setCenter(explanationView));
        
        Scene scene = new Scene(layout);
        
        window.setScene(scene);
        window.show();
    }
    
    public static StackPane createView(String text) {
        StackPane layout = new StackPane();
        layout.setPrefSize(300, 180);
        layout.getChildren().add(new Label(text));
        layout.setAlignment(Pos.CENTER);
        
        return layout;
    }
    
    public static void main(String[] args) {
        launch(JokeApplication.class);
    }
}
