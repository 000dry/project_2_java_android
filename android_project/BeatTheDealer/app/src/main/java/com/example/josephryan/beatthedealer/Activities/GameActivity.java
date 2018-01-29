package com.example.josephryan.beatthedealer.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.josephryan.beatthedealer.Persons.Dealer;
import com.example.josephryan.beatthedealer.DeckOfCards.Deck;
import com.example.josephryan.beatthedealer.Persons.Player;
import com.example.josephryan.beatthedealer.R;

public class GameActivity extends AppCompatActivity {

    Dealer dealer;
    Player player1;

    Button dealButton;
    Button resultButton;
    Button newSessionButton;
    Button keepPlayingButton;
    TextView playerCards;
    TextView dealerCards;
    TextView dealerView;
    TextView resultDisplay;
    TextView dealerScore;
    TextView playerScore;
    TextView score1;
    TextView score2;
    ImageView cardback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        dealer = new Dealer(0, new Deck());
        player1 = new Player(0);
        dealer.addPlayer(player1);

        dealButton = findViewById(R.id.deal);
        resultButton = findViewById(R.id.get_result);
        newSessionButton = findViewById(R.id.new_session);
        keepPlayingButton = findViewById(R.id.keep_playing);
        playerCards = findViewById(R.id.cards);
        dealerCards = findViewById(R.id.dealer_cards);
        dealerView = findViewById(R.id.dealer_reveal);
        resultDisplay = findViewById(R.id.result_display);
        dealerScore = findViewById(R.id.dealer_score);
        playerScore = findViewById(R.id.player_score);
        score1 = findViewById(R.id.score1);
        score2 = findViewById(R.id.score2);
        cardback = findViewById(R.id.card_back);
    }

    public void onDealButtonClick(View button){
        dealer.dealForRound();
        dealer.dealForRound();

        button.setVisibility(View.INVISIBLE);
        resultButton.setVisibility(View.VISIBLE);

        String cardStrings = player1.buildCardString(player1);
        playerCards.setText(cardStrings);

        String dealerStrings = dealer.buildCardString(dealer);
        dealerCards.setText(dealerStrings);
    }

    public void onClickResultButton(View button){
        dealerView.setVisibility(View.VISIBLE);
        dealerCards.setVisibility(View.VISIBLE);
        resultDisplay.setVisibility(View.VISIBLE);
        newSessionButton.setVisibility(View.VISIBLE);
        keepPlayingButton.setVisibility(View.VISIBLE);
        button.setVisibility(View.INVISIBLE);
        cardback.setVisibility(View.INVISIBLE);

        String result = dealer.getResult(player1);
        resultDisplay.setText(result);

        String points1 = Integer.toString(dealer.getScore());
        dealerScore.setText(points1);

        String points2 = Integer.toString(player1.getScore());
        playerScore.setText(points2);
    }

    public void onClickNewSession(View button){
        this.recreate();
    }

    public void onClickKeepPlaying(View button){
        dealer.emptyHand();
        player1.emptyHand();

        dealerView.setVisibility(View.INVISIBLE);
        dealerCards.setVisibility(View.INVISIBLE);
        resultDisplay.setVisibility(View.INVISIBLE);
        newSessionButton.setVisibility(View.INVISIBLE);
        keepPlayingButton.setVisibility(View.INVISIBLE);
        dealButton.setVisibility(View.VISIBLE);

        playerCards.setText("");
        dealerCards.setText("");
    }
}
