package com.example.josephryan.beatthedealer.DeckOfCards;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    ArrayList<Card> cardDeck;

    public Deck(){
        this.cardDeck = new ArrayList<>();
        fillDeck();
    }


    public ArrayList<Card> getCardDeck() {
        return this.cardDeck;
    }

    private void fillDeck() {
        Suit[] allSuits = Suit.values();
        Rank[] allRanks = Rank.values();


        for (Suit i: allSuits){
            for (Rank j: allRanks) {
                Card newCard = new Card(i, j);
                this.cardDeck.add(newCard);
            }
        }

    }

    public void shuffleDeck() {
        Collections.shuffle(this.cardDeck);
    }

    public Card removeCard() {
        if(this.cardDeck.size() == 0){
            fillDeck();
        }
        Card card = this.cardDeck.remove(0);
        return card;

    }
}
