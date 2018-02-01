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

        for (int i = 0; i < allSuits.length; i++){
            for (int j = 0; j < allRanks.length; j++) {
                Suit suit = allSuits[i];
                Rank rank = allRanks[j];
                Card newCard = new Card(suit, rank, true);
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
