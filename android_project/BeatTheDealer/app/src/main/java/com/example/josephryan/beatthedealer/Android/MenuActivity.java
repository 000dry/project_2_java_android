package com.example.josephryan.beatthedealer.Android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.josephryan.beatthedealer.R;

public class MenuActivity extends AppCompatActivity {

    Button beatTheDealerButton;
    Button blackjackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        beatTheDealerButton = findViewById(R.id.beat_the_dealer);
        blackjackButton = findViewById(R.id.blackjack);
    }

    public void onClickBeatTheDealer(View button){
        Intent intent = new Intent(this, BeatTheDealerActivity.class);
        startActivity(intent);
    }

    public void onClickBlackJack(View button){
        Intent intent = new Intent(this, BlackjackActivity.class);
        startActivity(intent);
    }
}
