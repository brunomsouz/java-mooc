/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asteroids;

import javafx.scene.shape.Polygon;
import javafx.geometry.Point2D;
import javafx.scene.shape.Shape;

/**
 *
 * @author bruno
 */
public abstract class Character {
    private boolean alive;
    private final Polygon character;
    private Point2D movement;

    public Character(Polygon polygon, int x, int y) {
        character = polygon;
        character.setTranslateX(x);
        character.setTranslateY(y);
        
        alive = true;
        movement = new Point2D(0, 0);
    }
    
    // essa classe possui um objeto do tipo Polyon que é o personagem em si
    // como não podemos adicionar um objeto dela no pane, iremos devolver o obj do tipo polygon
    public Polygon getCharacter() {
        return character;
    }
    
    // o método setRotate gira o polígono com base no seu estado original
    // então somamos 5 ao estado atual dele para poder continuar girando
    public void rotateRight() {
        character.setRotate(character.getRotate() + 5);
    }
    
    public void rotateLeft() {
        character.setRotate(character.getRotate() - 5);
    }
    
    // este método funciona em conjunto com o accelerate
    // ele irá setar o translado nos eixos para o ponto atual + o ponto da variável movement
    public void move() {
        character.setTranslateX(character.getTranslateX() + movement.getX());
        character.setTranslateY(character.getTranslateY() + movement.getY());
        
        if (character.getTranslateX() < 0) {
            character.setTranslateX(character.getTranslateX() + AsteroidsApplication.WIDTH);
        }
        
        if (character.getTranslateX() > AsteroidsApplication.WIDTH) {
            character.setTranslateX(character.getTranslateX() % AsteroidsApplication.WIDTH);
        }
        
        if (character.getTranslateY() < 0) {
            character.setTranslateY(character.getTranslateY() + AsteroidsApplication.HEIGHT);
        }
        
        if (character.getTranslateY() > AsteroidsApplication.HEIGHT) {
            character.setTranslateY(character.getTranslateY() % AsteroidsApplication.HEIGHT);
        }
    }
    
    // este método utiliza as funções sin e cos para pegar o ângulo atual
    // depois ela soma X e Y aos pontos da variável movement
    // quando utilizamos o método move, ele irá mover o polígono com base na coordenada atual do objeto movement
    public void accelerate() {
        double changeX = Math.cos(Math.toRadians(character.getRotate()));
        double changeY = Math.sin(Math.toRadians(character.getRotate()));
        
        // multiplicamos x e y por 0.5 para não gerar uma aceleração muito alta
        changeX *= 0.05;
        changeY *= 0.05;
        
        movement = movement.add(changeX, changeY);
    }
    
    // verifica se o objeto atual colidiu com o objeto do parâmetro, se utilizando do métoto intersect
    // se o retorno for true, irá parar o programa com base nas regras do AsteroidsApplication
    public boolean collide(Character character) {
        Shape collisionArea = Shape.intersect(this.character, character.getCharacter());
        return collisionArea.getBoundsInLocal().getWidth() != -1;
    }
    
    public Point2D getMovement() {
        return movement;
    }
    
    public void setMovement(Point2D movement) {
        this.movement = movement;
    }
    
    public void setAlive(boolean value) {
        alive = value;
    }
    
    public boolean isAlive() {
        return alive;
    }
}
