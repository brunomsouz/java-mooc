package asteroids;

import java.util.concurrent.atomic.AtomicInteger;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.layout.Pane;
import javafx.scene.input.KeyCode;
import javafx.animation.AnimationTimer;

public class AsteroidsApplication extends Application {

    public static int WIDTH = 300;
    public static int HEIGHT = 200;

    @Override
    public void start(Stage window) {
        Pane pane = new Pane();
        pane.setPrefSize(WIDTH, HEIGHT);
        
        Text text = new Text(10, 20, "Points: 0");
        pane.getChildren().add(text);
        AtomicInteger points = new AtomicInteger();

        Ship ship = new Ship(WIDTH / 2, HEIGHT / 2);
        pane.getChildren().add(ship.getCharacter());

        List<Asteroid> asteroids = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Random random = new Random();
            Asteroid asteroid = new Asteroid(random.nextInt(WIDTH / 3), random.nextInt(HEIGHT));
            asteroids.add(asteroid);
        }

        asteroids.forEach(asteroid -> pane.getChildren().add(asteroid.getCharacter()));

        Scene scene = new Scene(pane);

        Map<KeyCode, Boolean> pressedKeys = new HashMap<>();

        scene.setOnKeyPressed((event) -> {
            pressedKeys.put(event.getCode(), Boolean.TRUE);
        });

        scene.setOnKeyReleased((event) -> {
            pressedKeys.put(event.getCode(), Boolean.FALSE);
        });

        List<Projectile> projectiles = new ArrayList<>();

        window.setTitle("Asteroids!");
        window.setScene(scene);
        window.show();
        
        new AnimationTimer() {

            @Override
            public void handle(long now) {
                // ele irá checar no hashmap o valor de KeyCode.LEFT
                // enquanto a tecla estiver pressionada, será true, e a nave irá girar para o lado correspondente
                // ao soltar a tecla, o valor será false, e a nave irá parar de girar
                if (pressedKeys.getOrDefault(KeyCode.LEFT, false)) {
                    ship.rotateLeft();
                }

                if (pressedKeys.getOrDefault(KeyCode.RIGHT, false)) {
                    ship.rotateRight();
                }

                if (pressedKeys.getOrDefault(KeyCode.UP, false)) {
                    ship.accelerate();
                }

                if (pressedKeys.getOrDefault(KeyCode.SPACE, false) && projectiles.size() < 3) {

                    Projectile projectile = new Projectile((int) ship.getCharacter().getTranslateX(), (int) ship.getCharacter().getTranslateY());
                    projectile.getCharacter().setRotate(ship.getCharacter().getRotate());
                    projectiles.add(projectile);

                    projectile.accelerate();
                    projectile.setMovement(projectile.getMovement().normalize().multiply(3));

                    pane.getChildren().add(projectile.getCharacter());
                }

                ship.move();
                asteroids.forEach(asteroid -> asteroid.move());
                projectiles.forEach(projectile -> projectile.move());

                asteroids.forEach(asteroid -> {
                    if (ship.collide(asteroid)) {
                        stop();
                    }
                });

                projectiles.forEach(projectile -> {
                    asteroids.forEach(asteroid -> {
                        if (projectile.collide(asteroid)) {
                            projectile.setAlive(false);
                            asteroid.setAlive(false);
                        }
                    });
                    
                    if(!projectile.isAlive()) {
                        text.setText("Points: " + points.addAndGet(1000));
                    }
                });

                projectiles.stream()
                        .filter(projectile -> !projectile.isAlive())
                        .forEach(projectile -> pane.getChildren().remove(projectile.getCharacter()));
                projectiles.removeAll(projectiles.stream()
                        .filter(projectile -> !projectile.isAlive())
                        .collect(Collectors.toList()));
                
                asteroids.stream()
                        .filter(asteroid -> !asteroid.isAlive())
                        .forEach(asteroid -> pane.getChildren().remove(asteroid.getCharacter()));
                asteroids.removeAll(asteroids.stream()
                        .filter(asteroid -> !asteroid.isAlive())
                        .collect(Collectors.toList()));
                
                // cria asteróides aleatoriamente
                if(Math.random() < 0.005) {
                    Asteroid asteroid = new Asteroid(WIDTH, HEIGHT);
                    if(!asteroid.collide(ship)) {
                        asteroids.add(asteroid);
                        pane.getChildren().add(asteroid.getCharacter());
                    }
                }                    
            }
        }.start();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static int partsCompleted() {
        // State how many parts you have completed using the return value of this method
        return 4;
    }

}
