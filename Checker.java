import java.io.*;
import java.util.*;

public class Checker {
    private static ArrayList<Card> sideboardOptions;
    private static List<String> deckNames;
    private static ArrayList<Deck> decks;

    
    public static void main(String [] args) throws IOException {

        Checker thechecker = new Checker();
        thechecker.input();
        thechecker.listDecks();
        thechecker.loadDecks();
        thechecker.sideboardcards();
        System.out.println(sideboardOptions);
        
    }
    private void loadDecks() throws IOException
    {
        decks = new ArrayList<Deck>();
        for (String deck : deckNames)
        {
            Deck newDeck = new Deck(deck);
            Scanner deckReader = new Scanner(new FileInputStream("Decks/" + deck));
            int location = 0;
            while(deckReader.hasNext())
            {
                String line = deckReader.nextLine();
                if (line.equals("Sideboard")) {location = 1;}
                else if (line.length() < 3) break;
                else {
                    int quantity = Integer.parseInt(line.substring(0,1));
                    String name = line.substring(2);
                    newDeck.addCard(location,quantity,name);
                }
            }

        }
    }
    private void input()
    {
        deckNames = new ArrayList<String>();
        File[] files = new File("Decks").listFiles((dir, name) -> name.endsWith(".txt"));;

        for (File file : files) {
            if (file.isFile()) {
                deckNames.add(file.getName());
            }
        }
    }
    private void listDecks()
    {
        for (String deck : deckNames)
        {
            System.out.println(deck);
        }
    }
    private void sideboardcards() //broken
    {
        sideboardOptions = new ArrayList<Card>();
        for (Deck theDeck : decks)
        {
            for (Card card : theDeck.sideboard)
            {
                sideboardOptions.add(card);
                System.out.println(card);
            }
        }
    }

}
