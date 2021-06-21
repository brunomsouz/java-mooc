/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bruno
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;

public class Hand implements Comparable<Hand> {
    private List<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }
    
    public void add(Card card) {
        cards.add(card);
    }
    
    public void print() {
        cards.forEach(card -> System.out.println(card));
    }
    
    public int getHandValue() {
        return cards.stream().mapToInt(card -> card.getValue())
                .reduce(0, (previousSum, value) -> previousSum + value);
    }
    
    public void sort() {
        Comparator<Card> comparator = Comparator
                .comparing(Card::getValue)
                .thenComparing(Card::getSuit);
        
        Collections.sort(cards, comparator);
        
        // como já criamos um compareTo em cards, poderia só ter feito:
        // Collections.sort(cards);
    }
    
    @Override
    public int compareTo(Hand hand) {
        return this.getHandValue() - hand.getHandValue();
    }
    
    public void sortBySuit() {
        Comparator<Card> comparator = Comparator
                .comparing(Card::getSuit)
                .thenComparing(Card::getValue);
        
        Collections.sort(cards, comparator);
        
        // ou mais fácil como no exemplo, utilizando a classe que criamos:
        // Collections.sort(cards, new BySuitInValueOrder());
    }
}
