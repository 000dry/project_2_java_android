package com.example.josephryan.cardgame;

import com.example.josephryan.cardgame.Java.DeckOfCards.Card;
import com.example.josephryan.cardgame.Java.Player;
import com.example.josephryan.cardgame.Java.DeckOfCards.Rank;
import com.example.josephryan.cardgame.Java.DeckOfCards.Suit;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    Player player1;
    Player player2;
    Card card1;
    Card card2;

    @Before
    public void before(){
        player1 = new Player();
        player2 = new Player();
        card1 = new Card(Suit.HEARTS, Rank.QUEEN);
    }

    @Test
    public void playerCanAcceptCard(){
        player1.acceptCard(card1);
        assertEquals(1, player1.getHand().size());
    }





}
