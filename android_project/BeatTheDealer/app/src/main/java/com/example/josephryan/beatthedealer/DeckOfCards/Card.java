package com.example.josephryan.beatthedealer.DeckOfCards;

public class Card {

    Suit suit;
    Rank rank;
    boolean faceUp;

    public Card(Suit suit, Rank rank, boolean faceUp){
        this.suit = suit;
        this.rank = rank;
        this.faceUp = faceUp;
    }

    public Suit getSuit() {
        return this.suit;
    }

    public Rank getRank() {
        return this.rank;
    }

    public boolean isFaceUp(){
        return this.faceUp;
    }

    public void switchFaceUp(){
        this.faceUp = this.isFaceUp() ? false : true;
    }
}
