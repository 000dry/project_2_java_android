package com.example.josephryan.beatthedealer;

import com.example.josephryan.beatthedealer.DeckOfCards.Card;
import com.example.josephryan.beatthedealer.DeckOfCards.Deck;
import com.example.josephryan.beatthedealer.DeckOfCards.Rank;
import com.example.josephryan.beatthedealer.DeckOfCards.Suit;
import com.example.josephryan.beatthedealer.Persons.Dealer;
import com.example.josephryan.beatthedealer.Persons.Player;

import org.junit.Assert;
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
    Card card1;
    Card card2;

    @Before
    public void before(){
        deck = new Deck();
        dealer = new Dealer(deck);
        player = new Player();
        card1 = new Card(Suit.SPADES, Rank.ACE);
        card2 = new Card(Suit.SPADES, Rank.EIGHT);
    }

    @Test
    public void canGetHand(){
        assertEquals(0, player.getHand().size());
        assertEquals(0, dealer.getHand().size());
    }

    @Test
    public void personCanAcceptCard__maximumOfTwoCards(){
        player.acceptCard(card1);
        dealer.acceptCard(card1);
        dealer.acceptCard(card1);
        dealer.acceptCard(card1);
        assertEquals(1, player.getHand().size());
        assertEquals(2, dealer.getHand().size());
    }

    @Test
    public void canGetEachCard(){
        player.acceptCard(card1);
        player.acceptCard(card2);
        dealer.acceptCard(card1);
        dealer.acceptCard(card2);
        assertEquals(2, player.getEachCard().length);
        assertEquals(2, dealer.getEachCard().length);
    }

    @Test
    public void canGetCardStrings(){
        player.acceptCard(card1);
        player.acceptCard(card2);
        assertEquals("The ace of spades. The eight of spades. ", player.buildCardString(player));
    }
}
