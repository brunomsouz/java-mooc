
public class Program {

    public static void main(String[] args) {        
        DictionaryOfManyTranslations dictionary = new DictionaryOfManyTranslations();
        dictionary.add("lie", "maata");
        dictionary.add("lie", "valehdella");

        dictionary.remove("bow");
        System.out.println(dictionary.translate("bow"));
    }
}
