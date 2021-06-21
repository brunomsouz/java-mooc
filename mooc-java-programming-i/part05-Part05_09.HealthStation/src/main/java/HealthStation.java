
public class HealthStation {
    private int weighingsCounter = 0;

    public int weigh(Person person) {
        this.weighingsCounter += 1;
        return person.getWeight();
    }
    
    public void feed(Person person) {
        person.setWeight(person.getWeight() + 1);
    }
    
    public int weighings() {
        return weighingsCounter;
    }

}
