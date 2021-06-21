/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bruno
 */
public class Timer {
    private ClockHand hundredsOfASecond;
    private ClockHand seconds;
    
    public Timer() {
        this.seconds = new ClockHand(60);
        this.hundredsOfASecond = new ClockHand(100);
    }
    
    public void advance() {
        this.hundredsOfASecond.advance();
        
        if (this.hundredsOfASecond.value() == 0) {
            this.seconds.advance();
        }
    }
    
    public String toString() {
        return this.seconds + ":" + this.hundredsOfASecond;
    }
}
