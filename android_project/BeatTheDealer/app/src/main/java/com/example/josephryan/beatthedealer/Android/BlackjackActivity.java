package com.example.josephryan.beatthedealer.Android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.josephryan.beatthedealer.DeckOfCards.Card;
import com.example.josephryan.beatthedealer.DeckOfCards.Deck;
import com.example.josephryan.beatthedealer.DeckOfCards.RankHashMap;
import com.example.josephryan.beatthedealer.Games.Blackjack;
import com.example.josephryan.beatthedealer.Persons.Dealer;
import com.example.josephryan.beatthedealer.Persons.Player;
import com.example.josephryan.beatthedealer.R;

import java.util.ArrayList;

public class BlackjackActivity extends AppCompatActivity {

    Blackjack game;
    Dealer dealer;
    Player player1;
    RankHashMap ranks;
    ImageResourceFinder suitImages;
    RecyclerView recyclerView;
    RecyclerView recyclerView2;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.LayoutManager layoutManager2;
    BlackjackAdapter adapter;
    BlackjackAdapter adapter2;
    ArrayList<Card> playerHand;
    ArrayList<Card> dealerHand;

    ImageButton cardBack;
    ImageButton newSessionButton;
    ImageButton keepPlayingButton;
    Button split;
    Button stick;
    Button hit;
    Button dealerTurn;
    Button resultButton;
    TextView resultDisplay;
    TextView dealerScore;
    TextView playerScore;
    TextView score1;
    TextView score2;
    TextView dealerCard1Num1;
    TextView dealerCard1Num2;
    TextView dealerCard2Num1;
    TextView dealerCard2Num2;
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
        playerHand = player1.getHand();
        dealerHand = dealer.getHand();

        cardBack = findViewById(R.id.card_back);
        newSessionButton = findViewById(R.id.new_session);
        keepPlayingButton = findViewById(R.id.keep_playing);
        split = findViewById(R.id.split);
        stick = findViewById(R.id.stick);
        hit = findViewById(R.id.hit);
        dealerTurn = findViewById(R.id.dealers_turn);
        resultButton = findViewById(R.id.result_button);
        resultDisplay = findViewById(R.id.result_display);
        dealerScore = findViewById(R.id.dealer_score);
        playerScore = findViewById(R.id.player_score);
        score1 = findViewById(R.id.score1);
        score2 = findViewById(R.id.score2);
        dealerCard1Num1 = findViewById(R.id.dealer_card1_number1);
        dealerCard1Num2 = findViewById(R.id.dealer_card1_number2);
        dealerCard2Num1 = findViewById(R.id.dealer_card2_number1);
        dealerCard2Num2 = findViewById(R.id.dealer_card2_number2);
        dealerCard1 = findViewById(R.id.dealer_card1);
        dealerCard2 = findViewById(R.id.dealer_card2);
        resultsFrame = findViewById(R.id.result_frame);
    }

    public void onDealButtonClick(View button){
        dealer.dealForRound(game);
        dealer.dealForRound(game);
        dealer.setCardsExceptFirstFaceDown();

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new BlackjackAdapter(playerHand);
        recyclerView.setAdapter(adapter);

        recyclerView2 = findViewById(R.id.recycler_view2);
        recyclerView2.setHasFixedSize(true);
        layoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView2.setLayoutManager(layoutManager2);
        adapter2 = new BlackjackAdapter(dealerHand);
        recyclerView2.setAdapter(adapter2);

        changeVisibilityOnClickDealButton();
    }

    public void onClickHitButton(View button){
        dealer.dealCard(player1, game);
        adapter.notifyDataSetChanged();
    }

    public void onClickStickButton(View button){
        changeVisibilityOnClickStickButton();
    }

    public void onClickDealersTurnButton(View button){
        dealer.shouldDrawCard(game);

        int i = dealer.getHand().size();
        dealer.getHand().get(i - 1).setFaceUpToFalse();

        resultButton.setVisibility(View.VISIBLE);
        button.setVisibility(View.INVISIBLE);
        adapter2.notifyDataSetChanged();
    }

    public void onClickResultOrSplitButton(View button){
        changeVisibilityOnClickResult();
        dealer.getHand().get(1).setFaceUpToTrue();
        adapter2.notifyDataSetChanged();

        String result = game.getResult(player1, dealer);
        resultDisplay.setText(result);
        String points1 = Integer.toString(dealer.getScore());
        dealerScore.setText(points1);
        String points2 = Integer.toString(player1.getScore());
        playerScore.setText(points2);
    }

    public void onClickSplitButton(View button){
        player1.blackjackInGameBooleanSwitch();
        onClickResultOrSplitButton(button);
        stick.setVisibility(View.INVISIBLE);
    }

    public void onClickNewSession(View button){
        this.recreate();
    }

    public void onClickKeepPlaying(View button){
        dealer.emptyHand();
        player1.emptyHand();
        player1.setInGameToTrue();
        changeVisibilityOnClickKeepPlaying();
    }

    //    *** View/Resource setters below ***

    private void changeVisibilityOnClickStickButton(){
        dealerTurn.setVisibility(View.VISIBLE);
        hit.setVisibility(View.INVISIBLE);
        split.setVisibility(View.INVISIBLE);
        stick.setVisibility(View.INVISIBLE);
    }

    private void changeVisibilityOnClickDealButton(){
        cardBack.setVisibility(View.INVISIBLE);
        split.setVisibility(View.VISIBLE);
        stick.setVisibility(View.VISIBLE);
        hit.setVisibility(View.VISIBLE);
    }

    private void changeVisibilityOnClickResult() {
        resultDisplay.setVisibility(View.VISIBLE);
        newSessionButton.setVisibility(View.VISIBLE);
        keepPlayingButton.setVisibility(View.VISIBLE);
        resultsFrame.setVisibility(View.VISIBLE);
        stick.setVisibility(View.INVISIBLE);
        split.setVisibility(View.INVISIBLE);
        hit.setVisibility(View.INVISIBLE);
        cardBack.setVisibility(View.INVISIBLE);
        resultButton.setVisibility(View.INVISIBLE);
    }

    public void changeVisibilityOnClickKeepPlaying(){
        resultDisplay.setVisibility(View.INVISIBLE);
        newSessionButton.setVisibility(View.INVISIBLE);
        keepPlayingButton.setVisibility(View.INVISIBLE);
        cardBack.setVisibility(View.VISIBLE);
        resultsFrame.setVisibility(View.INVISIBLE);
    }
}
