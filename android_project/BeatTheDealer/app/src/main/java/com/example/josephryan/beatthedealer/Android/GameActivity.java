package com.example.josephryan.beatthedealer.Android;

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
    TextView resultDisplay;
    TextView dealerScore;
    TextView playerScore;
    TextView score1;
    TextView score2;
    TextView playerCard1Num1;
    TextView playerCard1Num2;
    TextView playerCard2Num1;
    TextView playerCard2Num2;
    ImageView cardBack;
    ImageView playerCard1;
    ImageView playerCard2;
    ImageView dealerCard1;
    ImageView dealerCard2;

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
        resultDisplay = findViewById(R.id.result_display);
        dealerScore = findViewById(R.id.dealer_score);
        playerScore = findViewById(R.id.player_score);
        score1 = findViewById(R.id.score1);
        score2 = findViewById(R.id.score2);
        playerCard1Num1 = findViewById(R.id.player_card1_number1);
        playerCard1Num2 = findViewById(R.id.player_card1_number2);
        playerCard2Num1 = findViewById(R.id.player_card2_number1);
        playerCard2Num2 = findViewById(R.id.player_card2_number2);
        cardBack = findViewById(R.id.card_back);
        playerCard1 = findViewById(R.id.player_card1);
        playerCard2 = findViewById(R.id.player_card2);
        dealerCard1 = findViewById(R.id.dealer_card1);
        dealerCard2 = findViewById(R.id.dealer_card2);
    }


    public void onDealButtonClick(View button){
        dealer.dealForRound();
        dealer.dealForRound();

        button.setVisibility(View.INVISIBLE);
        resultButton.setVisibility(View.VISIBLE);
        playerCard1.setVisibility(View.VISIBLE);
        playerCard2.setVisibility(View.VISIBLE);
        dealerCard1.setVisibility(View.VISIBLE);
        dealerCard2.setVisibility(View.VISIBLE);

        Suit suit1 = player1.getHand().get(0).getSuit(); //write all this into separate method
        int suit1ID = suitImages.cardIcons().get(suit1); // *
        playerCard1.setImageResource(suit1ID);           // *

        Suit suit2 = player1.getHand().get(1).getSuit(); // *
        int suit2ID = suitImages.cardIcons().get(suit2); // *
        playerCard2.setImageResource(suit2ID);           // *

        Suit suit3 = dealer.getHand().get(0).getSuit();  // *
        int suit3ID = suitImages.cardIcons().get(suit3); // *
        dealerCard1.setImageResource(suit3ID);           // *

        String num1 = Integer.toString(player1.getHand().get(0).getRank().getValue()); // *
        playerCard1Num1.setText(num1); // *
        playerCard1Num2.setText(num1); // *

        String num2 = Integer.toString(player1.getHand().get(1).getRank().getValue()); // *
        playerCard2Num1.setText(num2); // *
        playerCard2Num2.setText(num2); // *

    }

    public void onClickResultButton(View button){
        resultDisplay.setVisibility(View.VISIBLE);
        newSessionButton.setVisibility(View.VISIBLE);
        keepPlayingButton.setVisibility(View.VISIBLE);
        button.setVisibility(View.INVISIBLE);
        cardBack.setVisibility(View.INVISIBLE);

        String result = dealer.getResult(player1);
        resultDisplay.setText(result);

        String points1 = Integer.toString(dealer.getScore());
        dealerScore.setText(points1);

        String points2 = Integer.toString(player1.getScore());
        playerScore.setText(points2);

        Suit suit4 = dealer.getHand().get(1).getSuit();
        int suit4ID = suitImages.cardIcons().get(suit4);
        dealerCard2.setImageResource(suit4ID);
    }

    public void onClickNewSession(View button){
        this.recreate();
    }

    public void onClickKeepPlaying(View button){
        dealer.emptyHand();
        player1.emptyHand();

        resultDisplay.setVisibility(View.INVISIBLE);
        newSessionButton.setVisibility(View.INVISIBLE);
        keepPlayingButton.setVisibility(View.INVISIBLE);
        dealButton.setVisibility(View.VISIBLE);
        cardBack.setVisibility(View.VISIBLE);
        playerCard1.setVisibility(View.INVISIBLE);
        playerCard2.setVisibility(View.INVISIBLE);
        dealerCard1.setVisibility(View.INVISIBLE);
        dealerCard2.setVisibility(View.INVISIBLE);
        dealerCard2.setImageResource(R.drawable.cardback);

        playerCard1Num1.setText("");
        playerCard1Num2.setText("");
        playerCard2Num1.setText("");
        playerCard2Num2.setText("");
    }
}
