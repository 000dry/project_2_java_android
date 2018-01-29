package com.example.josephryan.beatthedealer.Persons;

import com.example.josephryan.beatthedealer.DeckOfCards.Card;
import com.example.josephryan.beatthedealer.DeckOfCards.Deck;

import java.util.ArrayList;

public class Dealer extends Person{

    int score;
    Deck deck;
    ArrayList<Player> playersInGame;

    public Dealer(int score, Deck deck){
        super(score);
        this.deck = deck;
        this.playersInGame = new ArrayList<>();
    }

    public Deck getDeck() {
        return this.deck;
    }

    public ArrayList<Card> getHand(){
        return this.hand;
    }

    public void addPlayer(Player player) {
        this.playersInGame.add(player);
    }

    public int getPlayerCount() {
        return this.playersInGame.size();
    }

    public void dealCard(Player player) {
        Card card = deck.removeCard();
        player.acceptCard(card);
    }

    public void dealToSelf() {
        Card card = deck.removeCard();
        this.acceptCard(card);
    }

    public void dealForRound(){
        deck.shuffleDeck();

        for(int i = 0; i < this.playersInGame.size(); i++){
            Player player = this.playersInGame.get(i);
            this.dealCard(player);
        }
        this.dealToSelf();
    }

    public int checkCardValue(Person person, int index) {
        Card hand = person.getHand().get(index);
        int value = hand.getRank().getValue();

        return value;
    }

    public int checkValueOfHand(Person person) {
        int value = 0;

        for(int i = 0; i < person.getHand().size(); i++){
            value += this.checkCardValue(person, i);
        }
        return value;
    }

    public void updateScore(Person person, int points){
        if(points > 0 && person.getScore() > 2) {
            person.score += points;
        }
    }

    public String getResult(Person player) {
        int dealerHand = this.checkValueOfHand(this);
        int playerHand = this.checkValueOfHand(player);

        if(playerHand > dealerHand){
            updateScore(player, 2);
            updateScore(this, -2);
            return "You beat the dealer!";
        } else if(playerHand == dealerHand){
            updateScore(this, 1);
            updateScore(player, 1);
            return "It's a draw!";
        } else {
            updateScore(player, -2);
            updateScore(this, 2);
            return "The dealer wins!";
        }
    }

}

