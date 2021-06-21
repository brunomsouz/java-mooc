

public class Main {

    public static void main(String[] args) {
        Item smartphone = new Item("S10", 2);
        Item notebook = new Item("Asus", 5);
        
        Suitcase suitcase = new Suitcase(10);
        
        suitcase.addItem(smartphone);
        suitcase.addItem(notebook);
        
        System.out.println(smartphone);
        System.out.println(notebook);
        System.out.println(suitcase);
        
        System.out.println(suitcase.totalWeight());
        suitcase.printItems();
        
        Hold hold = new Hold(20);
        
        hold.addSuitcase(suitcase);
        
        System.out.println(hold.totalWeight());
        
        hold.printItems();
    }

}
