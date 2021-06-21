/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

/**
 *
 * @author bruno
 */

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

public class PracticeView {
    private Dictionary dictionary;
    private String word;

    public PracticeView(Dictionary dictionary) {
        this.dictionary = dictionary;
        this.word = dictionary.getRandomWord();
    }
    
    public Parent getView() {
        GridPane layout = new GridPane();
        
        Label translationInstructions = new Label("Translate the word '" + word + "'");
        TextField translationField = new TextField();
        Button checkButton = new Button("Check");
        Label result = new Label("");
        
        layout.add(translationInstructions, 0, 0);
        layout.add(translationField, 0, 1);
        layout.add(checkButton, 0, 2);
        layout.add(result, 0, 3);
        
        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(10, 10, 10, 10));
        
        checkButton.setOnAction((event) -> {
            String translation = dictionary.get(word);
            if (translationField.getText().trim().equals(translation)) {
                result.setText("Correct!");
            } else {
                result.setText("Incorrect! The translation of the word '" + 
                        word + "' is '" + translation + "'");
            }
            
            word = dictionary.getRandomWord();
            translationInstructions.setText("Translate the word '" + word + "'");
            translationField.clear();
        });
        
        return layout;
    }
    
}
