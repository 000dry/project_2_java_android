package com.example.josephryan.beatthedealer.Android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.josephryan.beatthedealer.DeckOfCards.Card;
import com.example.josephryan.beatthedealer.DeckOfCards.Deck;
import com.example.josephryan.beatthedealer.DeckOfCards.RankHashMap;
import com.example.josephryan.beatthedealer.DeckOfCards.Suit;
import com.example.josephryan.beatthedealer.Games.Blackjack;
import com.example.josephryan.beatthedealer.Persons.Dealer;
import com.example.josephryan.beatthedealer.Persons.Person;
import com.example.josephryan.beatthedealer.Persons.Player;
import com.example.josephryan.beatthedealer.R;

public class BlackjackActivity extends AppCompatActivity {

    Blackjack game;
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
        setContentView(R.layout.activity_blackjack);

        game = new Blackjack();
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

    public void onDealButtonClick(View button){
        dealer.dealForRound(game);
        dealer.dealForRound(game);
        changeVisibilityOnClickDealButton();
        createCards(player1, 0, playerCard1, playerCard1Num1, playerCard1Num2);
        createCards(player1, 1, playerCard2, playerCard2Num1, playerCard2Num2);
        createCards(dealer, 0, dealerCard1, dealerCard1Num1, dealerCard1Num2);
    }

    //    *** View/Resource setters below ***

    public void createCards(Person person, int i, ImageView view1, TextView view2, TextView view3){
        Card card = person.getHand().get(i);

        Suit suit = card.getSuit();
        int suitID = suitImages.cardIcons().get(suit);
        view1.setImageResource(suitID);

        String rank = ranks.rankStrings().get(card.getRank());
        view2.setText(rank);
        view3.setText(rank);
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

}
