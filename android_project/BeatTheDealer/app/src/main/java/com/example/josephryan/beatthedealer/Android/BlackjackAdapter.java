package com.example.josephryan.beatthedealer.Android;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.josephryan.beatthedealer.DeckOfCards.Card;
import com.example.josephryan.beatthedealer.DeckOfCards.Suit;
import com.example.josephryan.beatthedealer.Games.Blackjack;
import com.example.josephryan.beatthedealer.R;

import java.util.ArrayList;

/**
 * Created by josephryan on 01/02/2018.
 */

class BlackjackAdapter extends RecyclerView.Adapter<BlackjackAdapter.ViewHolder> {

    private ArrayList<Card> playerHand;
    ImageResourceFinder suitImages;

    public BlackjackAdapter(ArrayList<Card> playerHand){
        this.playerHand = playerHand;
        suitImages = new ImageResourceFinder();
    }

    @Override
    public BlackjackAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(BlackjackAdapter.ViewHolder holder, int position) {
        Card card = playerHand.get(position);
        Suit suit = card.getSuit();
        int suitID = suitImages.cardIcons().get(suit);

        holder.cardSuit.setImageResource(suitID);
    }

    @Override
    public int getItemCount() {
        return playerHand.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView cardSuit;

        public ViewHolder(View itemView) {
            super(itemView);
            cardSuit = itemView.findViewById(R.id.card_image);
        }
    }
}
