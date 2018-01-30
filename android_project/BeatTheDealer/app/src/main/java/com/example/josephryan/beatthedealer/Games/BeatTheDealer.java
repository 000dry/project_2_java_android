package com.example.josephryan.beatthedealer.Games;

import com.example.josephryan.beatthedealer.Persons.Dealer;
import com.example.josephryan.beatthedealer.Persons.Player;

/**
 * Created by josephryan on 30/01/2018.
 */

public class BeatTheDealer extends Game {

    public String getResult(Player player, Dealer dealer) {
        int dealerHand = this.checkValueOfHand(dealer);
        int playerHand = this.checkValueOfHand(player);

        if(player.getInGame()){
            if(playerHand > dealerHand){
                updateScore(player, 2);
                updateScore(dealer, -1);
                return "Player Wins";
            } else if(playerHand == dealerHand){
                updateScore(player, 1);
                updateScore(dealer, 1);
                return "Draw";
            } else {
                updateScore(player, -1);
                updateScore(dealer, 2);
                return "Dealer Wins";
            }
        } else {
            updateScore(player, 0);
            updateScore(dealer, 2);
            return "Forfeit";
        }
    }
}
