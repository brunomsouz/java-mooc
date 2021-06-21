package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class GreeterApplication extends Application {

  @Override
  public void start(Stage window) throws Exception {
      // componentes da primeira tela
      Label instructionText = new Label("Enter your name and start.");
      TextField field = new TextField();
      Button startButton = new Button("Start");
      
      // layout da primeira tela
      GridPane layout = new GridPane();
      
      layout.add(instructionText, 1, 0);
      layout.add(field, 1, 1);
      layout.add(startButton, 1, 2);
      
      // estilizando o layout
      layout.setPrefSize(300, 180);  // tamanho da janela inicial
      layout.setAlignment(Pos.CENTER);  // deixa o layout no centro da cena
      layout.setVgap(10);  // espaçamento vertical entre os elementos
      layout.setHgap(10); // espaçamento horizontal entre os elementos
      layout.setPadding(new Insets(20, 20, 20, 20));  // padding é o preenchimento entre a borda e o conteúdo
      
      // criando a cena que irá conter este layout
      
      Scene firstView = new Scene(layout);
      
      // componentes da tela de boas vindas
      
      Label welcomeMessage = new Label("");
      
      StackPane welcomeLayout = new StackPane();
      
      welcomeLayout.setPrefSize(300, 180);
      welcomeLayout.getChildren().add(welcomeMessage);
      welcomeLayout.setAlignment(Pos.CENTER);
      
      // criando a cena para a tela de boas vindas
      Scene secondView = new Scene(welcomeLayout);
      
      // ação do botão start
      startButton.setOnAction((event) -> {
          String name = field.getText().trim();
          welcomeMessage.setText("Welcome " + name + "!");
          
          window.setScene(secondView);
      });
      
      window.setScene(firstView);
      window.show();
  }

  public static void main(String[] args) {
      launch(GreeterApplication.class);
  }
}