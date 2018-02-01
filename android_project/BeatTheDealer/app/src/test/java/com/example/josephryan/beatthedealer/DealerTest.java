package com.example.josephryan.beatthedealer;

import com.example.josephryan.beatthedealer.DeckOfCards.Card;
import com.example.josephryan.beatthedealer.DeckOfCards.Deck;
import com.example.josephryan.beatthedealer.DeckOfCards.Rank;
import com.example.josephryan.beatthedealer.DeckOfCards.Suit;
import com.example.josephryan.beatthedealer.Games.BeatTheDealer;
import com.example.josephryan.beatthedealer.Games.Blackjack;
import com.example.josephryan.beatthedealer.Persons.Dealer;
import com.example.josephryan.beatthedealer.Persons.Player;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DealerTest {

    BeatTheDealer beatTheDealer;
    Blackjack blackjack;
    Deck deck;
    Dealer dealer;
    Player player1;
    Player player2;
    Card card1;
    Card card2;
    Card card3;

    @Before
    public void before() {
        beatTheDealer = new BeatTheDealer();
        blackjack = new Blackjack();
        deck = new Deck();
        dealer = new Dealer(2, true, deck);
        player1 = new Player(0, true);
        player2 = new Player(2, true);
        card1 = new Card(Suit.CLUBS, Rank.FOUR, true);
        card2 = new Card(Suit.DIAMONDS, Rank.SEVEN, true);
        card3 = new Card(Suit.HEARTS, Rank.TWO, true);
    }

    @Test
    public void hasCards() {
        assertEquals(52, dealer.getDeck().getCardDeck().size());
    }


    @Test
    public void canDealCard() {
        dealer.dealCard(player1, beatTheDealer);
        assertEquals(1, player1.getHand().size());
        assertEquals(51, dealer.getDeck().getCardDeck().size());
    }

    @Test
    public void cannotDealMoreCardsThanGamesMaxCard__blackjack(){
        dealer.dealCard(player1, blackjack);
        dealer.dealCard(player1, blackjack);
        dealer.dealCard(player1, blackjack);
        dealer.dealCard(player1, blackjack);
        dealer.dealCard(player1, blackjack);
        dealer.dealCard(player1, blackjack);
        dealer.dealCard(player1, blackjack);
        dealer.dealCard(player1, blackjack);
        dealer.dealCard(player1, blackjack);
        assertEquals(5, player1.getHand().size());
    }

    @Test
    public void cannotDealMoreCardsThanGamesMaxCard__beatTheDealer(){
        dealer.dealCard(player1, beatTheDealer);
        dealer.dealCard(player1, beatTheDealer);
        dealer.dealCard(player1, beatTheDealer);
        dealer.dealCard(player1, beatTheDealer);
        dealer.dealCard(player1, beatTheDealer);
        dealer.dealCard(player1, beatTheDealer);
        dealer.dealCard(player1, beatTheDealer);
        dealer.dealCard(player1, beatTheDealer);
        assertEquals(2, player1.getHand().size());
    }

    @Test
    public void canDealARound(){
        beatTheDealer.addPlayer(player1);
        beatTheDealer.addPlayer(player2);
        beatTheDealer.addPlayer(dealer);
        dealer.dealForRound(beatTheDealer);
        dealer.dealForRound(beatTheDealer);
        assertEquals(2, dealer.getHand().size());
        assertEquals(2, player1.getHand().size());
        assertEquals(2, player2.getHand().size());
    }

    @Test
    public void dealerTakesExtraCardIfHandValueUnder13(){
        dealer.acceptCard(card1);
        dealer.acceptCard(card3);
        dealer.shouldDrawCard(blackjack);
        assertEquals(3, dealer.getHand().size());
    }
}
