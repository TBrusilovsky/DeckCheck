import java.util.ArrayList;

public class Deck {
    public ArrayList<Card> maindeck;
    public ArrayList<Card> sideboard;
    public String deckName;

    public Deck(String deckName) 
    {
        this.deckName = deckName;
        maindeck = new ArrayList<Card>();
        sideboard = new ArrayList<Card>();
    }
    public void addCard(int location, int number, String name)
    {
        Card toAdd = new Card(number,name);

        if (location == 0)
        {
            maindeck.add(toAdd);
        }
        else 
        {
            sideboard.add(toAdd);
        }
    }
    public void printDeck()
    {
        System.out.println("Maindeck");
        for (Card card : maindeck)
        {
            System.out.println(card);
        }
        System.out.println("Sideboard");
        for (Card card : sideboard)
        {
            System.out.println(card);
        }
    }


}

class Card {
    public int number;
    public String name;

    public Card(int number, String name) 
    {
        this.number = number;
        this.name = name;
    }

    public String toString() {
        return Integer.toString(number) + " " + name;
    }

}
