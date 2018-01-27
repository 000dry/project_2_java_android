package com.example.josephryan.cardgame;

/**
 * Created by josephryan on 27/01/2018.
 */

public abstract Person {

    ArrayList<Card> hand;

    public Person(){
        this.hand = new ArrayList<>();
        }
}
