package com.example.josephryan.cardgame;

import java.util.ArrayList;

public class Player implements IHandable{


    public Player(){
        this.hand = new ArrayList<>();
    }


    public ArrayList<Card> getHand() {
        return this.hand;
    }

    public void acceptCard(Card card) {
        this.hand.add(card);
    }
}
