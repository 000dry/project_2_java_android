import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DealerTest {

    Deck deck;
    Dealer dealer;
    Player player1;
    Player player2;
    Card card1;
    Card card2;

    @Before
    public void before() {
        deck = new Deck();
        dealer = new Dealer("James", deck);
        player1 = new Player("Leroy Jenkins");
        player2 = new Player("Megan");
        card1 = new Card(Suit.CLUBS, Rank.FOUR);
        card2 = new Card(Suit.DIAMONDS, Rank.SEVEN);
    }

    @Test
    public void hasCards() {
        assertEquals(52, dealer.getDeck().getCardDeck().size());
    }

    @Test
    public void canDealCard() {
        dealer.dealCard(player1);
        assertEquals(1, player1.getHand().size());
        assertEquals(51, dealer.getDeck().getCardDeck().size());
    }


    @Test
    public void canCheckPlayersCardValue(){
        player1.acceptCard(card1);
        assertEquals(4, dealer.checkCardValue(player1));
    }

    @Test
    public void canCompareCards(){
        player1.acceptCard(card1);
        player2.acceptCard(card2);
        assertEquals("The winner is player 2", dealer.compareCards(player1, player2));

    }

}
