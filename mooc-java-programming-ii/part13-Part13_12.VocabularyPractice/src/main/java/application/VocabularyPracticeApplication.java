package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class VocabularyPracticeApplication extends Application {
    private Dictionary dictionary;
    
    @Override
    public void init() {
        dictionary = new Dictionary();
    }
    
    @Override
    public void start(Stage window) {
        InputView inputView = new InputView(dictionary);
        PracticeView practiceView = new PracticeView(dictionary);
        
        Button goToInputView = new Button("Enter new words");
        Button goToPracticeView = new Button("Practice");
        
        HBox menu = new HBox();        
        menu.getChildren().addAll(goToInputView, goToPracticeView);
        menu.setPadding(new Insets(10, 10, 10, 10));
        menu.setSpacing(10);
        
        BorderPane layout = new BorderPane();       
        
        layout.setTop(menu);
        layout.setCenter(inputView.getView());        
        
        Scene scene = new Scene(layout, 400, 300);
        
        goToInputView.setOnAction((event) -> {
            layout.setCenter(inputView.getView());
        });
        
        goToPracticeView.setOnAction((event) -> {
            layout.setCenter(practiceView.getView());
        });
        
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(VocabularyPracticeApplication.class);
    }
}
