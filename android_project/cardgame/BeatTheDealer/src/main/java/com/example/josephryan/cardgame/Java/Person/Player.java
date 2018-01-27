package com.example.josephryan.cardgame.Java.Person;

import com.example.josephryan.cardgame.Java.DeckOfCards.Rank;
import com.example.josephryan.cardgame.Java.DeckOfCards.Suit;


public class Player extends Person {



    public Player(){
    }

    public String[] getEachCard(){
        String[] cards = new String[this.getHand().size()];
        for(int i = 0; i < this.getHand().size(); i++){
           String rank = this.getHand().get(i).getRank().name();
           String suit = this.getHand().get(i).getSuit().name();
           cards[i] = "The " + rank.toLowerCase() + " of " + suit.toLowerCase() + ". ";
        }
        return cards;
    }



}
