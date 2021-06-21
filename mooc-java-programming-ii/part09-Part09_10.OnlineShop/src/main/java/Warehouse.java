/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bruno
 */
import java.util.Set;
import java.util.Map;
import java.util.HashMap;

public class Warehouse {
    private Map<String, Integer> listOfPrices;
    private Map<String, Integer> listOfStocks;

    public Warehouse() {
        listOfPrices = new HashMap<>();
        listOfStocks = new HashMap<>();
    }
    
    public void addProduct(String product, int price, int stock) {
        listOfPrices.put(product, price);
        listOfStocks.put(product, stock);
    }
    
    public int stock(String product) {
        return listOfStocks.getOrDefault(product, 0);
    }
    
    public boolean take(String product) {
        if (listOfStocks.containsKey(product) && listOfStocks.get(product) > 0) {
            int newStock = listOfStocks.get(product) - 1;
            
            listOfStocks.put(product, newStock);
            
            return true;
        }
        
        return false;
    }
    
    public int price(String product) {
        return listOfPrices.getOrDefault(product, -99);
    }
    
    public Set<String> products() {
        return listOfStocks.keySet();
    }
}
