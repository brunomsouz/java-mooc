/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bruno
 */
import java.util.List;
import java.util.ArrayList;

public class ShoppingCart {
    private List<Item> cart;

    public ShoppingCart() {
        cart = new ArrayList<>();
    }
    
    public void add(String product, int price) {
        Item newItem = new Item(product, 1, price);
        
        if (cart.contains(newItem)) {
            this.increaseQuantity(cart.indexOf(newItem));
        } else {
            cart.add(newItem);
        }
    }
    
    public int price() {
        int totalPrice = 0;
        
        for (Item item : cart) {
            totalPrice += item.price();
        }
        
        return totalPrice;
    }
    
    public void print() {
        for (Item item : cart) {
            System.out.println(item.toString());
        }
    }
    
    public void increaseQuantity(int index) {
        cart.get(index).increaseQuantity();
    }
}
