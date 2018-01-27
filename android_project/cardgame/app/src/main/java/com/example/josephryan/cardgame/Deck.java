import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    ArrayList<Card> cardDeck;
    Card card;
    Suit[] allSuits;
    Rank[] allRanks;

    public Deck(){
        this.cardDeck = new ArrayList<>();
        fillDeck();
    }


    public ArrayList<Card> getCardDeck() {
        return this.cardDeck;
    }

    private void fillDeck() {
        Suit[] allSuits = Suit.values();
        Rank[] allRanks = Rank.values();


        for (Suit i: allSuits){
            for (Rank j: allRanks) {
                Card newCard = new Card(i, j);
                this.cardDeck.add(newCard);
            }
        }

    }

    public void shuffleDeck() {
        Collections.shuffle(this.cardDeck);
    }

    public Card removeCard() {
//        might need to add logic to check there are enough cards to deal
//        either here, or in the dealer class....
        Card card = this.cardDeck.remove(0);
        return card;
    }
}
