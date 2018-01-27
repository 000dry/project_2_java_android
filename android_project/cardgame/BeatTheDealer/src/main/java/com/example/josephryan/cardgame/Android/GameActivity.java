package com.example.josephryan.cardgame.Android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.josephryan.cardgame.Java.Dealer;
import com.example.josephryan.cardgame.Java.DeckOfCards.Deck;
import com.example.josephryan.cardgame.Java.Player;
import com.example.josephryan.cardgame.R;

public class GameActivity extends AppCompatActivity {

    Deck deck;
    Dealer dealer;
    Player player1;
    Button dealButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        deck = new Deck();
        dealer = new Dealer(deck);
        player1 = new Player();
        dealer.addPlayer(player1);
        dealButton = findViewById(R.id.deal);

        String checkPlayersInGame = Integer.toString(dealer.getPlayerCount());
        Log.d("number of players: ", checkPlayersInGame);
        String hasDeck = Integer.toString(dealer.getDeck().getCardDeck().size());
        Log.d("full deck: ", hasDeck);
    }

    public void onDealButtonClick(View button){
        dealer.dealForRound();

        String playerHasCards = Integer.toString(player1.getHand().size());
        Log.d("Player number of cards:", playerHasCards);
        String dealerHasCards = Integer.toString(dealer.getHand().size());
        Log.d("Dealer number of cards:", dealerHasCards);


    }


}
