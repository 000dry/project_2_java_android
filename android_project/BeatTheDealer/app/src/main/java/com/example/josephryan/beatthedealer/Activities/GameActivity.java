package com.example.josephryan.beatthedealer.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.josephryan.beatthedealer.DeckOfCards.Suit;
import com.example.josephryan.beatthedealer.Persons.Dealer;
import com.example.josephryan.beatthedealer.DeckOfCards.Deck;
import com.example.josephryan.beatthedealer.Persons.Player;
import com.example.josephryan.beatthedealer.R;


public class GameActivity extends AppCompatActivity {

    Dealer dealer;
    Player player1;
    ImageResourceFinder suitImages;

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
    ImageView playerCard1;
    ImageView playerCard2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        dealer = new Dealer(0, new Deck());
        player1 = new Player(0);
        dealer.addPlayer(player1);
        suitImages = new ImageResourceFinder();

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
        playerCard1 = findViewById(R.id.player_card1);
        playerCard2 = findViewById(R.id.player_card2);
    }


    public void onDealButtonClick(View button){
        dealer.dealForRound();
        dealer.dealForRound();

        button.setVisibility(View.INVISIBLE);
        resultButton.setVisibility(View.VISIBLE);
        playerCard1.setVisibility(View.VISIBLE);
        playerCard2.setVisibility(View.VISIBLE);

        String cardStrings = player1.buildCardString(player1);
        playerCards.setText(cardStrings);

        String dealerStrings = dealer.buildCardString(dealer);
        dealerCards.setText(dealerStrings);

        Suit suit1 = player1.getHand().get(0).getSuit();
        int suit1ID = suitImages.cardIcons().get(suit1);
        playerCard1.setImageResource(suit1ID);

        Suit suit2 = player1.getHand().get(1).getSuit();
        int suit2ID = suitImages.cardIcons().get(suit2);
        playerCard2.setImageResource(suit2ID);

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
        cardback.setVisibility(View.VISIBLE);
        playerCard1.setVisibility(View.INVISIBLE);
        playerCard2.setVisibility(View.INVISIBLE);

        playerCards.setText("");
        dealerCards.setText("");
    }
}
