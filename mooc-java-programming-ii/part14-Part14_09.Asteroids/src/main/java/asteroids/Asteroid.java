/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asteroids;

import javafx.scene.shape.Polygon;
import java.util.Random;

/**
 *
 * @author bruno
 */
public class Asteroid extends Character {
    private double rotationalMovement;
    
    // cria um asteróide de tamanho variável com base na classe PolygonFactory
    // e então gera uma rotatividade e uma aceleração aleatórios, que serão a base do funcionamento do asteróide
    public Asteroid(int x, int y) {
        super(new PolygonFactory().createPolygon(), x, y);
        
        Random random = new Random();
        
        super.getCharacter().setRotate(random.nextInt(360));
        
        int accelerationAmmount = 1 + random.nextInt(10);
        for (int i = 0; i < accelerationAmmount; i++) {
            accelerate();
        }
        
        rotationalMovement = 0.5 - random.nextDouble();
    }
    
    // no caso dos asteróides, iremos sobrepor o método de movimento original para rotacioná-lo
    // durante o movimento, fazendo uma animação mais natural
    @Override
    public void move() {
        super.move();
        super.getCharacter().setRotate(super.getCharacter().getRotate() * rotationalMovement);
    }
}
