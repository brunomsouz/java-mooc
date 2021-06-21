package textstatistics;

import java.util.Arrays;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class TextStatisticsApplication extends Application {

    @Override
    public void start(Stage window) {
        TextArea text = new TextArea();        
        Label letterCount = new Label();
        Label wordCount = new Label();
        Label longestWord = new Label();
        
        text.textProperty().addListener((change, oldValue, newValue) -> {
            int characters = newValue.length();
            String[] parts = newValue.split(" ");
            int words = parts.length;
            String longest = Arrays.stream(parts)
                    .sorted((s1, s2) -> s2.length() - s1.length())
                    .findFirst()
                    .get();
            
            letterCount.setText("Letters: " + characters);
            wordCount.setText("Words: " + words);
            longestWord.setText("The longest word is: " + longest);
        });
  
        BorderPane components = new BorderPane();
        components.setCenter(text);
        
        HBox box = new HBox();
        box.setSpacing(10);
        box.getChildren().addAll(letterCount, wordCount, longestWord);        
        
        components.setBottom(box);
        
        Scene view = new Scene(components);
        
        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
    }

}
