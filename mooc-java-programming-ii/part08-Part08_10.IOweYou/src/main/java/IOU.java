/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bruno
 */
import java.util.HashMap;

public class IOU {
    private HashMap<String, Double> owed;

    public IOU() {
        owed = new HashMap<>();
    }
    
    public void setSum(String toWhom, double amount) {
        owed.put(toWhom, amount);
    }
    
    public double howMuchDoIOweTo(String toWhom) {
        return owed.getOrDefault(toWhom, 0.0);
    }
}
