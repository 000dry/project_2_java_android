package com.example.josephryan.beatthedealer;

import com.example.josephryan.beatthedealer.DeckOfCards.Card;
import com.example.josephryan.beatthedealer.DeckOfCards.Rank;
import com.example.josephryan.beatthedealer.DeckOfCards.Suit;

import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;


public class CardTest {

    Card card;

    @Before
    public void before() {
        card = new Card(Suit.HEARTS, Rank.FOUR, true);
    }

    @Test
    public void hasSuitHearts() {
        assertEquals(Suit.HEARTS, card.getSuit());
    }

    @Test
    public void hasRankFour() {
        assertEquals(Rank.FOUR, card.getRank());
    }

    @Test
    public void canGetAllSuits() {
        Suit[] suits = Suit.values();
        Suit[] expected = {Suit.CLUBS, Suit.DIAMONDS, Suit.HEARTS, Suit.SPADES};
        assertArrayEquals(expected, suits);
    }

    @Test
    public void canGetAllRanks() {
        Rank[] ranks = Rank.values();
        assertEquals(Rank.ACE, ranks[0]);
    }

    @Test
    public void canGetFaceUp(){
        assertEquals(true, card.isFaceUp());
    }

    @Test
    public void canSwitchFaceUp(){
        card.switchFaceUp();
        assertEquals(false, card.isFaceUp());
    }
}
