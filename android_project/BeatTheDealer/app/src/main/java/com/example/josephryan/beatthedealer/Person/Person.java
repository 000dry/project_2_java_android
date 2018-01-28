package com.example.josephryan.beatthedealer.Person;

import com.example.josephryan.beatthedealer.DeckOfCards.Card;


import java.util.ArrayList;

/**
 * Created by josephryan on 27/01/2018.
 */

public abstract class Person {

    ArrayList<Card> hand;

    public Person(){
        this.hand = new ArrayList<>();
        }

    public ArrayList<Card> getHand() {
        return this.hand;
    }

    public void acceptCard(Card card) {
        this.hand.add(card);
    }
}
