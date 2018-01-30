package com.example.josephryan.beatthedealer.Persons;

import com.example.josephryan.beatthedealer.DeckOfCards.Card;

import java.util.ArrayList;

/**
 * Created by josephryan on 27/01/2018.
 */

public abstract class Person {

    public int score;
    boolean inGame;
    ArrayList<Card> hand;

    public Person(int score, boolean inGame){
        this.score = score;
        this.inGame = inGame;
        this.hand = new ArrayList<>();
        }

    public int getScore(){
        return this.score;
    }

    public ArrayList<Card> getHand() {
        return this.hand;
    }

    public void acceptCard(Card card) {
        if(this.getHand().size() < 2) {
            this.hand.add(card);
        }
    }

    public void emptyHand(){
        for(int i = 0; i < this.getHand().size();){
            this.getHand().remove(i);
        }
    }

    public boolean getInGame(){
        return this.inGame;
    }

    public void setInGameToTrue(){
        this.inGame = true;
    }

    public void inGameBooleanSwitch(){
        this.inGame = this.getInGame() ? false : true;
    }
}
