package com.example.josephryan.beatthedealer.Android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.josephryan.beatthedealer.DeckOfCards.RankHashMap;
import com.example.josephryan.beatthedealer.DeckOfCards.Suit;
import com.example.josephryan.beatthedealer.Games.BeatTheDealer;
import com.example.josephryan.beatthedealer.Games.Game;
import com.example.josephryan.beatthedealer.Persons.Dealer;
import com.example.josephryan.beatthedealer.DeckOfCards.Deck;
import com.example.josephryan.beatthedealer.Persons.Player;
import com.example.josephryan.beatthedealer.R;


public class OnePlayerActivity extends AppCompatActivity {

    BeatTheDealer game;
    Dealer dealer;
    Player player1;
    RankHashMap ranks;
    ImageResourceFinder suitImages;

    ImageButton cardBack;
    ImageButton newSessionButton;
    ImageButton keepPlayingButton;
    Button optOutButton;
    Button resultButton;
    TextView resultDisplay;
    TextView dealerScore;
    TextView playerScore;
    TextView score1;
    TextView score2;
    TextView playerCard1Num1;
    TextView playerCard1Num2;
    TextView playerCard2Num1;
    TextView playerCard2Num2;
    TextView dealerCard1Num1;
    TextView dealerCard1Num2;
    TextView dealerCard2Num1;
    TextView dealerCard2Num2;
    ImageView playerCard1;
    ImageView playerCard2;
    ImageView dealerCard1;
    ImageView dealerCard2;
    ImageView resultsFrame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        game = new BeatTheDealer();
        dealer = new Dealer(0, true, new Deck());
        player1 = new Player(0, true);
        game.addPlayer(player1);
        game.addPlayer(dealer);
        ranks = new RankHashMap();
        suitImages = new ImageResourceFinder();

        cardBack = findViewById(R.id.card_back);
        newSessionButton = findViewById(R.id.new_session);
        keepPlayingButton = findViewById(R.id.keep_playing);
        optOutButton = findViewById(R.id.opt_out);
        resultButton = findViewById(R.id.get_result);
        resultDisplay = findViewById(R.id.result_display);
        dealerScore = findViewById(R.id.dealer_score);
        playerScore = findViewById(R.id.player_score);
        score1 = findViewById(R.id.score1);
        score2 = findViewById(R.id.score2);
        playerCard1Num1 = findViewById(R.id.player_card1_number1);
        playerCard1Num2 = findViewById(R.id.player_card1_number2);
        playerCard2Num1 = findViewById(R.id.player_card2_number1);
        playerCard2Num2 = findViewById(R.id.player_card2_number2);
        dealerCard1Num1 = findViewById(R.id.dealer_card1_number1);
        dealerCard1Num2 = findViewById(R.id.dealer_card1_number2);
        dealerCard2Num1 = findViewById(R.id.dealer_card2_number1);
        dealerCard2Num2 = findViewById(R.id.dealer_card2_number2);
        playerCard1 = findViewById(R.id.player_card1);
        playerCard2 = findViewById(R.id.player_card2);
        dealerCard1 = findViewById(R.id.dealer_card1);
        dealerCard2 = findViewById(R.id.dealer_card2);
        resultsFrame = findViewById(R.id.result_frame);
    }

//    public void cardImageSetter(ImageView image){
//        for(int i = 0; i < game.getPlayerCount(); i++) {
//            Person player = game.getPlayer(i);
//            for(int j = 0; j < player.getHand().size(); j++){
//                Suit suit = player.getHand().get(j).getSuit();
//                int suitID = suitImages.cardIcons().get(suit);
//
//            }
//        }
//        image.setImageResource(suitID);
//    }

    public void onDealButtonClick(View button){
        dealer.dealForRound(game);
        dealer.dealForRound(game);
        changeVisibilityOnClickDealButton();

        Suit suit1 = player1.getHand().get(0).getSuit(); //write all this into separate method
        int suit1ID = suitImages.cardIcons().get(suit1); // *
        playerCard1.setImageResource(suit1ID);           // *

        Suit suit2 = player1.getHand().get(1).getSuit(); // *
        int suit2ID = suitImages.cardIcons().get(suit2); // *
        playerCard2.setImageResource(suit2ID);           // *

        Suit suit3 = dealer.getHand().get(0).getSuit();  // *
        int suit3ID = suitImages.cardIcons().get(suit3); // *
        dealerCard1.setImageResource(suit3ID);           // *

        String card1 = ranks.rankStrings().get(player1.getHand().get(0).getRank()); // *
        playerCard1Num1.setText(card1); // *
        playerCard1Num2.setText(card1); // *

        String card2 = ranks.rankStrings().get(player1.getHand().get(1).getRank()); // *
        playerCard2Num1.setText(card2); // *
        playerCard2Num2.setText(card2); // *

        String card3 = ranks.rankStrings().get(dealer.getHand().get(0).getRank());
        dealerCard1Num1.setText(card3);
        dealerCard1Num2.setText(card3);

    }

    public void onClickResultButton(View button){
        changeVisibilityOnClickResult();

        String result = game.getResult(player1, dealer);
        resultDisplay.setText(result);

        String points1 = Integer.toString(dealer.getScore());
        dealerScore.setText(points1);

        String points2 = Integer.toString(player1.getScore());
        playerScore.setText(points2);

        Suit suit4 = dealer.getHand().get(1).getSuit();
        int suit4ID = suitImages.cardIcons().get(suit4);
        dealerCard2.setImageResource(suit4ID);

        String card4 = ranks.rankStrings().get(dealer.getHand().get(1).getRank());
        dealerCard2Num1.setText(card4);
        dealerCard2Num2.setText(card4);
    }

    public void onClickOptOutButton(View button){
        player1.inGameBooleanSwitch();
        onClickResultButton(button);
        resultButton.setVisibility(View.INVISIBLE);
    }

    public void onClickNewSession(View button){
        this.recreate();
    }

    public void onClickKeepPlaying(View button){
        dealer.emptyHand();
        player1.emptyHand();
        player1.setInGameToTrue();
        changeVisibilityOnClickKeepPlaying();

        playerCard1Num1.setText("");
        playerCard1Num2.setText("");
        playerCard2Num1.setText("");
        playerCard2Num2.setText("");
        dealerCard1Num1.setText("");
        dealerCard1Num2.setText("");
        dealerCard2Num1.setText("");
        dealerCard2Num2.setText("");
    }

    private void changeVisibilityOnClickDealButton(){
        cardBack.setVisibility(View.INVISIBLE);
        optOutButton.setVisibility(View.VISIBLE);
        resultButton.setVisibility(View.VISIBLE);
        playerCard1.setVisibility(View.VISIBLE);
        playerCard2.setVisibility(View.VISIBLE);
        dealerCard1.setVisibility(View.VISIBLE);
        dealerCard2.setVisibility(View.VISIBLE);
    }

    private void changeVisibilityOnClickResult() {
        resultDisplay.setVisibility(View.VISIBLE);
        newSessionButton.setVisibility(View.VISIBLE);
        keepPlayingButton.setVisibility(View.VISIBLE);
        resultsFrame.setVisibility(View.VISIBLE);
        resultButton.setVisibility(View.INVISIBLE);
        optOutButton.setVisibility(View.INVISIBLE);
        cardBack.setVisibility(View.INVISIBLE);
    }

    public void changeVisibilityOnClickKeepPlaying(){
        resultDisplay.setVisibility(View.INVISIBLE);
        newSessionButton.setVisibility(View.INVISIBLE);
        keepPlayingButton.setVisibility(View.INVISIBLE);
        cardBack.setVisibility(View.VISIBLE);
        playerCard1.setVisibility(View.INVISIBLE);
        playerCard2.setVisibility(View.INVISIBLE);
        dealerCard1.setVisibility(View.INVISIBLE);
        dealerCard2.setVisibility(View.INVISIBLE);
        dealerCard2.setImageResource(R.drawable.cardback);
        resultsFrame.setVisibility(View.INVISIBLE);
    }
}
