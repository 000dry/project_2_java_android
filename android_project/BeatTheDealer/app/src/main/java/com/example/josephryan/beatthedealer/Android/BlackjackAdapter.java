package com.example.josephryan.beatthedealer.Android;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.josephryan.beatthedealer.DeckOfCards.Card;
import com.example.josephryan.beatthedealer.Games.Blackjack;

import java.util.ArrayList;

/**
 * Created by josephryan on 01/02/2018.
 */

class BlackjackAdapter extends RecyclerView.Adapter<BlackjackAdapter.ViewHolder> {

    private ArrayList<Card> playerHand;

    public BlackjackAdapter(ArrayList<Card> playerHand){
        this.playerHand = playerHand;
    }

    @Override
    public BlackjackAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(BlackjackAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
