package com.example.josephryan.cardgame.Android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.josephryan.cardgame.Java.Person.Dealer;
import com.example.josephryan.cardgame.Java.DeckOfCards.Deck;
import com.example.josephryan.cardgame.Java.Person.Player;
import com.example.josephryan.cardgame.R;

import java.util.Arrays;

public class GameActivity extends AppCompatActivity {

    Dealer dealer;
    Player player1;
    Button dealButton;
    TextView playerCards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        dealer = new Dealer(new Deck());
        player1 = new Player();
        dealer.addPlayer(player1);
        dealButton = findViewById(R.id.deal);
        playerCards = findViewById(R.id.cards);

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

        String[] cards = player1.getEachCard();
        StringBuilder builder = new StringBuilder();
        for(String card : cards) {
            builder.append(card);
        }
        String cardStrings = builder.toString();

        playerCards.setText(cardStrings);
        Log.d("Strings? ", cardStrings);
    }


}
