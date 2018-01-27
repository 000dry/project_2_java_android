package com.example.josephryan.cardgame;

import com.example.josephryan.cardgame.Java.DeckOfCards.Card;
import com.example.josephryan.cardgame.Java.Dealer;
import com.example.josephryan.cardgame.Java.DeckOfCards.Deck;
import com.example.josephryan.cardgame.Java.Player;
import com.example.josephryan.cardgame.Java.DeckOfCards.Rank;
import com.example.josephryan.cardgame.Java.DeckOfCards.Suit;

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
        dealer = new Dealer(deck);
        player1 = new Player();
        player2 = new Player();
        card1 = new Card(Suit.CLUBS, Rank.FOUR);
        card2 = new Card(Suit.DIAMONDS, Rank.SEVEN);
    }

    @Test
    public void hasCards() {
        assertEquals(52, dealer.getDeck().getCardDeck().size());
    }

    @Test
    public void canAddPlayerToGame(){
        dealer.addPlayer(player1);
        dealer.addPlayer(player2);
        assertEquals(2, dealer.getPlayerCount());
    }

    @Test
    public void canDealCard() {
        dealer.dealCard(player1);
        assertEquals(1, player1.getHand().size());
        assertEquals(51, dealer.getDeck().getCardDeck().size());
    }

    @Test
    public void canDealCardToDealer() {
        dealer.dealToSelf();
        assertEquals(1, dealer.getHand().size());
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
