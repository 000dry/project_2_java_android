package com.example.josephryan.beatthedealer.Games;

import com.example.josephryan.beatthedealer.Persons.Dealer;
import com.example.josephryan.beatthedealer.Persons.Player;

/**
 * Created by josephryan on 30/01/2018.
 */

public class Blackjack extends Game{

    public String getResult(Player player, Dealer dealer) {
        int dealerHand = this.checkValueOfHand(dealer);
        int playerHand = this.checkValueOfHand(player);

        if(playerHand > dealerHand && playerHand < 21){
            return "Player Wins";
        } else if(playerHand < dealerHand){
            return "Dealer Wins";
        } else if(playerHand > 21){
            return "Dealer Wins";
        } else {
            return "Draw";
        }
    }
}
