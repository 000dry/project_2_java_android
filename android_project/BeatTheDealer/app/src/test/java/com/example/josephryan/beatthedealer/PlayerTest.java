package com.example.josephryan.beatthedealer;

import com.example.josephryan.beatthedealer.DeckOfCards.Card;
import com.example.josephryan.beatthedealer.DeckOfCards.Rank;
import com.example.josephryan.beatthedealer.DeckOfCards.Suit;
import com.example.josephryan.beatthedealer.Person.Player;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    Player player1;
    Card card1;
    Card card2;

    @Before
    public void before(){
        player1 = new Player();
        card1 = new Card(Suit.HEARTS, Rank.QUEEN);
        card2 = new Card(Suit.SPADES, Rank.EIGHT);
    }

    @Test
    public void canGetEachCard(){
        player1.acceptCard(card1);
        player1.acceptCard(card2);
        assertEquals(2, player1.getEachCard().length);
    }

}
