package com.example.josephryan.cardgame.Java.Person;
import com.example.josephryan.cardgame.Java.DeckOfCards.Card;
import com.example.josephryan.cardgame.Java.DeckOfCards.Deck;

import java.util.ArrayList;

public class Dealer extends Person{

    Deck deck;
    ArrayList<Player> playersInGame;

    public Dealer(Deck deck){
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

    public int checkCardValue(Player player) {
       Card playersHand = player.getHand().get(0);
       int value = playersHand.getRank().getValue();
       return value;
    }

    public int checkValueOfHand(Person person) {
        int value = 0;

        for(int i = 0; i < person.getHand().size(); i++){
            Card handToCheck = person.getHand().get(i);
            value += handToCheck.getRank().getValue();
        }

        return value;
    }

    public boolean resultAgainstDealer(Person player) {
        int dealerHand = this.checkValueOfHand(this);
        int playerHand = this.checkValueOfHand(player);

        return playerHand > dealerHand;
    }


//    public String compareCards(Player player1, Player player2) {
//        if(checkCardValue(player1) > checkCardValue(player2)) {
//            return "The winner is player 1";
//        } else {
//            return "The winner is player 2";
//        }
//    }
}

