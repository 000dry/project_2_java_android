import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class DeckTest {

    Deck deck;

    @Before
    public void before(){
        this.deck = new Deck();

    }

    @Test
    public void deckHas52Cards(){
        assertEquals(52, deck.getCardDeck().size());
    }

    @Test
    public void deckHasAceOfClubsFirstCard(){
        Card card = deck.getCardDeck().get(0);
        assertEquals(Suit.CLUBS, card.getSuit());
        assertEquals(Rank.ACE, card.getRank());
    }

    @Test
    public void canRemoveCard(){
        deck.removeCard();
        assertEquals(51, deck.getCardDeck().size());
    }

}
