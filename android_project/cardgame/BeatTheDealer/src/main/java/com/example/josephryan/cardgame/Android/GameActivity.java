package com.example.josephryan.cardgame.Android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.josephryan.cardgame.Java.Dealer;
import com.example.josephryan.cardgame.Java.DeckOfCards.Deck;
import com.example.josephryan.cardgame.Java.Player;
import com.example.josephryan.cardgame.R;

public class GameActivity extends AppCompatActivity {

    Deck deck;
    Dealer dealer;
    Player player1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        deck = new Deck();
        dealer = new Dealer(deck);
        player1 = new Player();

        dealer.addPlayer(player1);

        String checkPlayersInGame = Integer.toString(dealer.getPlayerCount());
        Log.d("number of players: ", checkPlayersInGame);
        String hasDeck = Integer.toString(dealer.getDeck().getCardDeck().size());
        Log.d("full deck: ", hasDeck);
    }


}
