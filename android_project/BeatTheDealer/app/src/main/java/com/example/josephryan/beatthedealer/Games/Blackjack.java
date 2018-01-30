package com.example.josephryan.beatthedealer.Games;

import com.example.josephryan.beatthedealer.Persons.Dealer;
import com.example.josephryan.beatthedealer.Persons.Player;

/**
 * Created by josephryan on 30/01/2018.
 */

public class Blackjack extends Game{

    public String getResult(Player player, Dealer dealer) {
        int dealerHand = dealer.checkValueOfHand();
        int playerHand = player.checkValueOfHand();

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
    }
}
