package com.example.josephryan.beatthedealer.Games;

import com.example.josephryan.beatthedealer.DeckOfCards.Card;
import com.example.josephryan.beatthedealer.DeckOfCards.Rank;
import com.example.josephryan.beatthedealer.Persons.Dealer;
import com.example.josephryan.beatthedealer.Persons.Person;
import com.example.josephryan.beatthedealer.Persons.Player;

import java.util.ArrayList;

/**
 * Created by josephryan on 30/01/2018.
 */

public class Blackjack extends Game{

    public Blackjack(){
        super(5);
    }

    public String getResult(Player player, Dealer dealer) {
        int dealerHand = this.shouldAdjustForLowAce(dealer);
        int playerHand = this.shouldAdjustForLowAce(player);

        if(player.getInGame()){
            if(playerHand > dealerHand && playerHand < 21){
                updateScore(player, 2);
                updateScore(dealer, -1);
                return "Player Wins";
            } else if(playerHand < dealerHand){
                updateScore(player, -1);
                updateScore(dealer, 2);
                return "Dealer Wins";
            } else if(playerHand > 21){
                updateScore(player, -1);
                updateScore(dealer, 2);
                return "Dealer Wins";
            } else {
                updateScore(player, 1);
                updateScore(dealer, 1);
                return "Draw";
            }
        } else {
            updateScore(player, 0);
            updateScore(dealer, 2);
            return "Forfeit";
        }
    }

    public int checkHandForAces(Person person){
        int aceCount = 0;
        ArrayList<Card> hand = person.getHand();

        for(int i = 0; i < hand.size(); i++){
            Card card = hand.get(i);
            if(card.getRank() == Rank.ACE){
                aceCount += 1;
            }
        }
        return aceCount;
    }

    public int shouldAdjustForLowAce(Person person){
        int personHand = person.checkValueOfHand();
        int aceCount = this.checkHandForAces(person);

        for(int i = 0; i < aceCount; i++){
            if(personHand > 21) {
                personHand -= 10;
                }
            }
        return personHand;
    }

}
