
import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bruno
 */
public class Item {
    private String product;
    private int quantity;
    private int unityPrice;

    public Item(String product, int quantity, int unityPrice) {
        this.product = product;
        this.quantity = quantity;
        this.unityPrice = unityPrice;
    }
    
    public int price() {
        return quantity * unityPrice;
    }
    
    public void increaseQuantity() {
        quantity++;
    }
    
    @Override
    public String toString() {
        return product + ": " + quantity;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.product);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Item other = (Item) obj;
        if (!Objects.equals(this.product, other.product)) {
            return false;
        }
        return true;
    }
    
    
}
