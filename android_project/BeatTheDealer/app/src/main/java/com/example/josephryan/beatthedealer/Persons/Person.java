package com.example.josephryan.beatthedealer.Persons;

import com.example.josephryan.beatthedealer.DeckOfCards.Card;

import java.util.ArrayList;

/**
 * Created by josephryan on 27/01/2018.
 */

public abstract class Person {

    int score;
    ArrayList<Card> hand;

    public Person(int score){
        this.score = score;
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

    public String[] getEachCard(){
        String[] cards = new String[this.getHand().size()];

        for(int i = 0; i < this.getHand().size(); i++){
            String rank = this.getHand().get(i).getRank().name();
            String suit = this.getHand().get(i).getSuit().name();

            cards[i] = "The " + rank.toLowerCase() + " of " + suit.toLowerCase() + ".\n";
        }
        return cards;
    }

    public String buildCardString(Person person){

        String[] cards = person.getEachCard();

        StringBuilder builder = new StringBuilder(); //join method was unavailable for level 15 API
        for(String card : cards) {
            builder.append(card);
        }
        String cardStrings = builder.toString();
        return cardStrings;

    }

    public void emptyHand(){
        for(int i = 0; i < this.getHand().size();){
            this.getHand().remove(i);
        }
    }
}
