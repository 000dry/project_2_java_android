package com.example.josephryan.cardgame;

import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;


public class CardTest {

    Card card;

    @Before
    public void before() {
        card = new Card(Suit.HEARTS, Rank.FOUR);
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
}
