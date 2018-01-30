package com.example.josephryan.beatthedealer;

import com.example.josephryan.beatthedealer.DeckOfCards.Card;
import com.example.josephryan.beatthedealer.DeckOfCards.Deck;
import com.example.josephryan.beatthedealer.DeckOfCards.Rank;
import com.example.josephryan.beatthedealer.DeckOfCards.Suit;
import com.example.josephryan.beatthedealer.Persons.Dealer;
import com.example.josephryan.beatthedealer.Persons.Player;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DealerTest {

    Game game;
    Deck deck;
    Dealer dealer;
    Player player1;
    Player player2;
    Card card1;
    Card card2;
    Card card3;

    @Before
    public void before() {
        game = new Game();
        deck = new Deck();
        dealer = new Dealer(2, true, deck);
        player1 = new Player(0, true);
        player2 = new Player(2, true);
        card1 = new Card(Suit.CLUBS, Rank.FOUR);
        card2 = new Card(Suit.DIAMONDS, Rank.SEVEN);
        card3 = new Card(Suit.HEARTS, Rank.TWO);

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
    public void canDealARound(){
        game.addPlayer(player1);
        game.addPlayer(player2);
        game.addPlayer(dealer);
        dealer.dealForRound(game);
        dealer.dealForRound(game);
        assertEquals(2, dealer.getHand().size());
        assertEquals(2, player1.getHand().size());
        assertEquals(2, player2.getHand().size());
    }
}
