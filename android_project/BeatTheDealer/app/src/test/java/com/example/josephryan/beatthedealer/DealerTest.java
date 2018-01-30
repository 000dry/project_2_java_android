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

    Deck deck;
    Dealer dealer;
    Player player1;
    Player player2;
    Card card1;
    Card card2;
    Card card3;

    @Before
    public void before() {
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
    public void canDealARound(){
        dealer.addPlayer(player1);
        dealer.addPlayer(player2);
        dealer.dealForRound();
        dealer.dealForRound();
        assertEquals(2, dealer.getHand().size());
        assertEquals(2, player1.getHand().size());
        assertEquals(2, player2.getHand().size());
    }

    @Test
    public void canCheckCardValue(){
        player1.acceptCard(card1);
        assertEquals(4, dealer.checkCardValue(player1, 0));
    }

   @Test
    public void canGetValueOfAHand__Player(){
        player1.acceptCard(card1);
        player1.acceptCard(card2);
        assertEquals(11, dealer.checkValueOfHand(player1));
   }

   @Test
    public void canCheckValueOfAHand__Dealer(){
        dealer.acceptCard(card1);
        dealer.acceptCard(card2);
        assertEquals(11, dealer.checkValueOfHand(dealer));
   }

    @Test
    public void canUpdateScore__positiveInt(){
        dealer.updateScore(player1, 2);
        assertEquals(2, player1.getScore());
    }

    @Test
    public void canUpdateScore__negativeInt(){
        dealer.updateScore(dealer, -2);
        assertEquals(0, dealer.getScore());
    }

   @Test
    public void canGetResultAsString__playerWins(){
       dealer.addPlayer(player1);
       player1.acceptCard(card2); //7
       player1.acceptCard(card2); //7
       dealer.acceptCard(card1); //4
       dealer.acceptCard(card1); //4
       assertEquals("Player wins", dealer.getResult(player1));
       assertEquals(2, player1.getScore());
       assertEquals(1, dealer.getScore());
   }

    @Test
    public void canGetResultAsString__playerLoses(){
        dealer.addPlayer(player1);
        dealer.acceptCard(card2); //7
        dealer.acceptCard(card2); //7
        player1.acceptCard(card1); //4
        player1.acceptCard(card1); //4
        assertEquals("Dealer wins", dealer.getResult(player1));
        assertEquals(0, player1.getScore());
        assertEquals(4, dealer.getScore());
    }

    @Test
    public void canGetResultAsString__draw(){
        dealer.addPlayer(player1);
        dealer.acceptCard(card1); //4
        player1.acceptCard(card1); //4
        assertEquals("Draw", dealer.getResult(player1));
        assertEquals(1, player1.getScore());
        assertEquals(3, dealer.getScore());
    }

    @Test
    public void canGetResultAsString_forfeit(){
        dealer.addPlayer(player1);
        dealer.acceptCard(card1); //4
        player2.acceptCard(card1); //4
        player2.inGameBooleanSwitch();
        assertEquals("Forfeit", dealer.getResult(player2));
        assertEquals(2, player2.getScore());
        assertEquals(4, dealer.getScore());
    }
}
