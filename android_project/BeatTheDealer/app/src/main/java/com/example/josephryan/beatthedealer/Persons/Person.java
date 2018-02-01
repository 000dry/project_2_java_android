package com.example.josephryan.beatthedealer.Persons;

import com.example.josephryan.beatthedealer.DeckOfCards.Card;
import com.example.josephryan.beatthedealer.DeckOfCards.Rank;

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
            this.hand.add(card);
    }

    public void emptyHand(){
        for(int i = 0; i < this.getHand().size();){
            this.getHand().remove(i);
        }
    }

    public int checkCardValue(int index) {
        Card hand = this.getHand().get(index);
        int value = hand.getRank().getValue();

        return value;
    }

    public int checkValueOfHand() {
        int value = 0;

        for(int i = 0; i < this.getHand().size(); i++){
            value += this.checkCardValue(i);
        }
        return value;
    }

    public int checkHandForAces(){
        int aceCount = 0;
        ArrayList<Card> hand = this.getHand();

        for(int i = 0; i < hand.size(); i++){
            Card card = hand.get(i);
            if(card.getRank() == Rank.ACE){
                aceCount += 1;
            }
        }
        return aceCount;
    }

    public int shouldAdjustForLowAce(){
        int personHand = this.checkValueOfHand();
        int aceCount = this.checkHandForAces();

        for(int i = 0; i < aceCount; i++){
            if(personHand > 21) {
                personHand -= 10;
            }
        }
        return personHand;
    }

}
