package com.example.josephryan.beatthedealer.Persons;

import com.example.josephryan.beatthedealer.DeckOfCards.Card;
import com.example.josephryan.beatthedealer.DeckOfCards.Deck;
import com.example.josephryan.beatthedealer.Games.Game;

import java.util.ArrayList;

public class Dealer extends Person{

    Deck deck;

    public Dealer(int score, boolean inGame, Deck deck){
        super(score, inGame);
        this.deck = deck;
    }

    public Deck getDeck() {
        return this.deck;
    }

    public ArrayList<Card> getHand(){
        return this.hand;
    }


    public void dealCard(Person person) {
        Card card = deck.removeCard();
        person.acceptCard(card);
    }

    public void dealForRound(Game game){
        deck.shuffleDeck();

        for(int i = 0; i < game.getPlayerCount(); i++){
            Person person = game.getPlayer(i);
            this.dealCard(person);
        }
    }

}

