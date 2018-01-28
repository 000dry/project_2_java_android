package com.example.josephryan.beatthedealer.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.josephryan.beatthedealer.Persons.Dealer;
import com.example.josephryan.beatthedealer.DeckOfCards.Deck;
import com.example.josephryan.beatthedealer.Persons.Person;
import com.example.josephryan.beatthedealer.Persons.Player;
import com.example.josephryan.beatthedealer.R;

public class GameActivity extends AppCompatActivity {

    Dealer dealer;
    Player player1;
    Button dealButton;
    Button resultButton;
    TextView playerCards;
    TextView dealerCards;
    TextView dealerView;
    Integer maxCardsDealt = 2;
    Integer startPoint = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        dealer = new Dealer(new Deck());
        player1 = new Player();
        dealer.addPlayer(player1);
        dealButton = findViewById(R.id.deal);
        resultButton = findViewById(R.id.get_result);
        playerCards = findViewById(R.id.cards);
        dealerCards = findViewById(R.id.dealer_cards);
        dealerView = findViewById(R.id.dealer_reveal);

        String checkPlayersInGame = Integer.toString(dealer.getPlayerCount());
        Log.d("number of players: ", checkPlayersInGame);
        String hasDeck = Integer.toString(dealer.getDeck().getCardDeck().size());
        Log.d("full deck: ", hasDeck);
    }

    public void onDealButtonClick(View button){
        if(startPoint == maxCardsDealt){
            button.setVisibility(View.INVISIBLE);
            resultButton.setVisibility(View.VISIBLE);
        } else {
            startPoint += 1;
        }
        dealer.dealForRound();

        String playerHasCards = Integer.toString(player1.getHand().size());
        Log.d("Player number of cards:", playerHasCards);
        String dealerHasCards = Integer.toString(dealer.getHand().size());
        Log.d("Dealer number of cards:", dealerHasCards);

        String cardStrings = player1.buildCardString(player1);
        playerCards.setText(cardStrings);
        Log.d("Strings? ", cardStrings);

        String dealerStrings = dealer.buildCardString(dealer);
        dealerCards.setText(dealerStrings);
        Log.d("DealerStrings?", dealerStrings);

        Log.d("Clicks", startPoint.toString());
    }

    public void onClickResultButton(View button){
        dealerView.setVisibility(View.VISIBLE);
        dealerCards.setVisibility(View.VISIBLE);
    }



}
