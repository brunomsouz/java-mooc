/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticTacToe;

import javafx.scene.Parent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

/**
 *
 * @author bruno
 */
public class BoardView {
    private Logic logic;

    public BoardView() {
        this.logic = new Logic();
    }
            
    public Parent getView() {
        // main layout
        BorderPane layout = new BorderPane();
        layout.setPadding(new Insets(20, 20, 20, 20));     
        
        // label for the top, indicating whose turn it is
        Label player = new Label("Turn: " + logic.getPlayer());
        layout.setTop(player);

        // creating and styling the grid
        GridPane board = new GridPane();
        board.setVgap(10);
        board.setHgap(10);
        board.setAlignment(Pos.CENTER);
        
        // populating grid with buttons
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.add(createButton(player, i, j), i, j);
            }
        }
        
        // positioning the grid
        layout.setCenter(board);      
        
        return layout;
    }
    
    public Button createButton(Label player, int x, int y) {
        // button on its blank state
        Button button = new Button(" ");

        // button action
        button.setOnAction((event) -> {
            // check if there's already a winner, or if the button is played
            if (!logic.checkWinner() && !logic.isPlayed(y, x)) {
                String turn = logic.getPlayer();
                logic.play(y, x);
                button.setText(turn);
                
                // updating the label
                player.setText("Turn: " + logic.getPlayer());
                
                // if someone wins, update the label
                if (logic.checkWinner()) {
                    player.setText("The end!");
                }
            }
        });       

        return button;
    }   
}
