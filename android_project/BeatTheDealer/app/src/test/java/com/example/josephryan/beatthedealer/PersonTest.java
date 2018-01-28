package com.example.josephryan.beatthedealer;

import com.example.josephryan.beatthedealer.DeckOfCards.Card;
import com.example.josephryan.beatthedealer.DeckOfCards.Deck;
import com.example.josephryan.beatthedealer.DeckOfCards.Rank;
import com.example.josephryan.beatthedealer.DeckOfCards.Suit;
import com.example.josephryan.beatthedealer.Person.Dealer;
import com.example.josephryan.beatthedealer.Person.Player;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by josephryan on 27/01/2018.
 */

public class PersonTest {

    Deck deck;
    Dealer dealer;
    Player player;
    Card card;

    @Before
    public void before(){
        deck = new Deck();
        dealer = new Dealer(deck);
        player = new Player();
        card = new Card(Suit.SPADES, Rank.ACE);
    }

    @Test
    public void canGetHand(){
        assertEquals(0, player.getHand().size());
        assertEquals(0, dealer.getHand().size());
    }

    @Test
    public void playerCanAcceptCard(){
        player.acceptCard(card);
        dealer.acceptCard(card);
        assertEquals(1, player.getHand().size());
        assertEquals(1, dealer.getHand().size());
    }
}
