
public class Main {

    public static void main(String[] args) {
        Gift smartphone = new Gift("Galaxy S10", 1);
        Gift tv = new Gift("LG", 7);
        Gift car = new Gift("Etios", 1750);
        
        Package listOfGifts = new Package();
        
        listOfGifts.addGift(smartphone);
        listOfGifts.addGift(tv);
        listOfGifts.addGift(car);
        
        System.out.println(listOfGifts.totalWeight());
    }
}
