/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bruno
 */
public class TripleTacoBox implements TacoBox {
    private int numberOfTacos;

    public TripleTacoBox() {
        numberOfTacos = 3;
    }
    
    @Override
    public int tacosRemaining() {
        return numberOfTacos;
    }
    
    @Override
    public void eat() {
        if (numberOfTacos > 0) {
            numberOfTacos--;
        }
    }
}
