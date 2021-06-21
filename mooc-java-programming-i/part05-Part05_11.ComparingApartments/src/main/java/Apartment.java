
public class Apartment {

    private int rooms;
    private int squares;
    private int pricePerSquare;

    public Apartment(int rooms, int squares, int pricePerSquare) {
        this.rooms = rooms;
        this.squares = squares;
        this.pricePerSquare = pricePerSquare;
    }
    
    public boolean largerThan(Apartment compared) {
        if (this.squares > compared.squares) {
            return true;
        }
        
        return false;
    }
    
    public int getPrice() {
        return this.squares * this.pricePerSquare;
    }

    public int priceDifference(Apartment compared) {
        int difference = this.getPrice() - compared.getPrice();
        
        if (difference < 0) {
            difference *= -1;
        }
        
        return difference;
        
        // ou podemos fazer como no exemplo:
        // return Math.abs(this.getPrice() - compared.getPrice())
    }
    
    public boolean moreExpensiveThan(Apartment compared) {
        return this.getPrice() > compared.getPrice();
    }
}
