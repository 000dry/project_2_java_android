package com.example.josephryan.cardgame;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Dealer implements IHandable{

    Deck deck;
    ArrayList<Card> hand;
    ArrayList<Player> playersInGame;

    public Dealer(Deck deck){
        this.deck = deck;
        this.hand = new ArrayList<>();
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

    public void acceptCard(Card card){
        this.hand.add(card);
    }

    public int checkCardValue(Player player) {
       Card playersHand = player.getHand().get(0);
       int value = playersHand.getRank().getValue();
       return value;
    }

    public String compareCards(Player player1, Player player2) {
        if(checkCardValue(player1) > checkCardValue(player2)) {
            return "The winner is player 1";
        } else {
            return "The winner is player 2";
        }
    }
}

