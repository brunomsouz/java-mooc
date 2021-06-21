
import java.util.Objects;

public class Person {

    private String name;
    private SimpleDate birthday;
    private int height;
    private int weight;

    public Person(String name, SimpleDate birthday, int height, int weight) {
        this.name = name;
        this.birthday = birthday;
        this.height = height;
        this.weight = weight;
    }
    
    public boolean equals(Object compared) {
        // primeiro checamos as referências
        if (this == compared) {
            return true;
        }
        
        // depois checamos se o objeto é instância de person, se não for já retorna falso
        if (!(compared instanceof Person)) {
            return false;
        }
        
        // agora fazemos o cast do objeto para Person
        Person comparedPerson = (Person) compared;
        // e comparamos as variáveis internas do objeto
        // como birthday também é um objeto, iremos utilizar o próprio método equals dele para conferir com o objeto interno de Person
        if (this.name.equals(comparedPerson.name) &&
            this.height == comparedPerson.height &&
            this.weight == comparedPerson.weight &&
            this.birthday.equals(comparedPerson.birthday)) {
            return true;
        }
        
        // se tudo falhar...
        return false;
    }

    // implement an equals method here for checking the equality of objects
}
