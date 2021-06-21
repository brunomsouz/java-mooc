/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asteroids;

import javafx.scene.shape.Polygon;

/**
 *
 * @author bruno
 */
public class Ship extends Character {

    // o construtor irá gerar um triângulo e passar as coordenadas onde ele deverá ser inicialmente colocado
    public Ship(int x, int y) {
        super(new Polygon(-5, -5, 10, 0, -5, 5), x, y);
    }
}
