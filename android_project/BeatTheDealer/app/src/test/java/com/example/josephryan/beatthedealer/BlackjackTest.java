package com.example.josephryan.beatthedealer;

import com.example.josephryan.beatthedealer.DeckOfCards.Card;
import com.example.josephryan.beatthedealer.DeckOfCards.Deck;
import com.example.josephryan.beatthedealer.DeckOfCards.Rank;
import com.example.josephryan.beatthedealer.DeckOfCards.Suit;
import com.example.josephryan.beatthedealer.Games.BeatTheDealer;
import com.example.josephryan.beatthedealer.Games.Blackjack;
import com.example.josephryan.beatthedealer.Games.Game;
import com.example.josephryan.beatthedealer.Persons.Dealer;
import com.example.josephryan.beatthedealer.Persons.Player;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by josephryan on 30/01/2018.
 */

public class BlackjackTest {

    Blackjack blackjack;
    Deck deck;
    Dealer dealer;
    Player player1;
    Player player2;
    Card card1;
    Card card2;
    Card card3;
    Card card4;

    @Before
    public void before() {
        blackjack = new Blackjack();
        deck = new Deck();
        dealer = new Dealer(2, true, deck);
        player1 = new Player(0, true);
        player2 = new Player(2, true);
        card1 = new Card(Suit.CLUBS, Rank.FOUR);
        card2 = new Card(Suit.DIAMONDS, Rank.SEVEN);
        card3 = new Card(Suit.HEARTS, Rank.TWO);
        card4 = new Card(Suit.SPADES, Rank.ACE);
    }

    @Test
    public void canGetValueOfHandWithFiveCards(){
        player1.acceptCard(card1);
        player1.acceptCard(card1);
        player1.acceptCard(card1);
        player1.acceptCard(card1);
        player1.acceptCard(card1);
        assertEquals(20, blackjack.checkValueOfHand(player1));
    }

    @Test
    public void canGetResult(){
        player1.acceptCard(card1);
        player1.acceptCard(card2);
        dealer.acceptCard(card3);
        dealer.acceptCard(card4);
        assertEquals("Player Wins", blackjack.getResult(player1, dealer));
    }
}
