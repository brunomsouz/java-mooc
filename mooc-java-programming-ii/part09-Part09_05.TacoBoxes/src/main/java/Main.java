
public class Main {

    public static void main(String[] args) {
        CustomTacoBox tacos = new CustomTacoBox(-3);
        
        System.out.println(tacos.tacosRemaining());
        tacos.eat();
        tacos.eat();
        System.out.println(tacos.tacosRemaining());
        tacos.eat();
        System.out.println(tacos.tacosRemaining());
        tacos.eat();
        tacos.eat();
        tacos.eat();
        System.out.println(tacos.tacosRemaining());
    }
}
