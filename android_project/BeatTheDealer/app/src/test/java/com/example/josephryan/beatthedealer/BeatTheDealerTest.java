package com.example.josephryan.beatthedealer;

import com.example.josephryan.beatthedealer.DeckOfCards.Card;
import com.example.josephryan.beatthedealer.DeckOfCards.Deck;
import com.example.josephryan.beatthedealer.DeckOfCards.Rank;
import com.example.josephryan.beatthedealer.DeckOfCards.Suit;
import com.example.josephryan.beatthedealer.Games.BeatTheDealer;
import com.example.josephryan.beatthedealer.Persons.Dealer;
import com.example.josephryan.beatthedealer.Persons.Player;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by josephryan on 30/01/2018.
 */

public class BeatTheDealerTest {

    BeatTheDealer game;
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
        card1 = new Card(Suit.CLUBS, Rank.FOUR, true);
        card2 = new Card(Suit.DIAMONDS, Rank.SEVEN, true);
        card3 = new Card(Suit.HEARTS, Rank.TWO, true);
    }

    @Test
    public void canGetResultAsString__playerWins(){
        game.addPlayer(player1);
        player1.acceptCard(card2); //7
        player1.acceptCard(card2); //7
        dealer.acceptCard(card1); //4
        dealer.acceptCard(card1); //4
        assertEquals("Player Wins", game.getResult(player1, dealer));
        assertEquals(2, player1.getScore());
        assertEquals(1, dealer.getScore());
    }

    @Test
    public void canGetResultAsString__playerLoses(){
        game.addPlayer(player1);
        dealer.acceptCard(card2); //7
        dealer.acceptCard(card2); //7
        player1.acceptCard(card1); //4
        player1.acceptCard(card1); //4
        assertEquals("Dealer Wins", game.getResult(player1, dealer));
        assertEquals(0, player1.getScore());
        assertEquals(4, dealer.getScore());
    }

    @Test
    public void canGetResultAsString__draw(){
        game.addPlayer(player1);
        dealer.acceptCard(card1); //4
        player1.acceptCard(card1); //4
        assertEquals("Draw", game.getResult(player1, dealer));
        assertEquals(1, player1.getScore());
        assertEquals(3, dealer.getScore());
    }

    @Test
    public void canGetResultAsString_forfeit(){
        game.addPlayer(player2);
        dealer.acceptCard(card1); //4
        player2.acceptCard(card1); //4
        player2.inGameBooleanSwitch();
        assertEquals("Forfeit", game.getResult(player2, dealer));
        assertEquals(2, player2.getScore());
        assertEquals(4, dealer.getScore());
    }

    @Test
    public void canGetResultFromTwoPlayersVDealer__bothWin(){
        game.addPlayer(player1);
        game.addPlayer(player2);
        game.addPlayer(dealer);
        player1.acceptCard(card1); //4
        player2.acceptCard(card2); //7
        dealer.acceptCard(card3); //2
        assertEquals("Player Wins", game.getResult(player1, dealer));
        assertEquals("Player Wins", game.getResult(player2, dealer));
    }

    @Test
    public void canGetResultFromTwoPlayersVDealer__P1WinP2Lose(){
        game.addPlayer(player1);
        game.addPlayer(player2);
        game.addPlayer(dealer);
        player1.acceptCard(card2); //7
        player2.acceptCard(card3); //2
        dealer.acceptCard(card1); //4
        assertEquals("Player Wins", game.getResult(player1, dealer));
        assertEquals("Dealer Wins", game.getResult(player2, dealer));
    }
}
