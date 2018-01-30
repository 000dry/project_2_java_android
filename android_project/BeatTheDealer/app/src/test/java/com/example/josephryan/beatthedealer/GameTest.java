package com.example.josephryan.beatthedealer;

import com.example.josephryan.beatthedealer.DeckOfCards.Card;
import com.example.josephryan.beatthedealer.DeckOfCards.Deck;
import com.example.josephryan.beatthedealer.DeckOfCards.Rank;
import com.example.josephryan.beatthedealer.DeckOfCards.Suit;
import com.example.josephryan.beatthedealer.Games.BeatTheDealer;
import com.example.josephryan.beatthedealer.Games.Game;
import com.example.josephryan.beatthedealer.Persons.Dealer;
import com.example.josephryan.beatthedealer.Persons.Player;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by josephryan on 30/01/2018.
 */

public class GameTest {

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
        game = new BeatTheDealer();
        deck = new Deck();
        dealer = new Dealer(2, true, deck);
        player1 = new Player(0, true);
        player2 = new Player(2, true);
        card1 = new Card(Suit.CLUBS, Rank.FOUR);
        card2 = new Card(Suit.DIAMONDS, Rank.SEVEN);
        card3 = new Card(Suit.HEARTS, Rank.TWO);
    }

    @Test
    public void canAddPlayerToGame(){
        game.addPlayer(player1);
        game.addPlayer(player2);
        assertEquals(2, game.getPlayerCount());
    }

    @Test
    public void canCheckCardValue(){
        player1.acceptCard(card1);
        assertEquals(4, player1.checkCardValue(0));
    }

    @Test
    public void canGetValueOfAHand__Player(){
        player1.acceptCard(card1);
        player1.acceptCard(card2);
        assertEquals(11, player1.checkValueOfHand());
    }

    @Test
    public void canCheckValueOfAHand__Dealer(){
        dealer.acceptCard(card1);
        dealer.acceptCard(card2);
        assertEquals(11, dealer.checkValueOfHand());
    }

    @Test
    public void canUpdateScore__positiveInt(){
        game.updateScore(player1, 2);
        assertEquals(2, player1.getScore());
    }

    @Test
    public void canUpdateScore__negativeInt(){
        game.updateScore(dealer, -2);
        assertEquals(0, dealer.getScore());
    }
}
