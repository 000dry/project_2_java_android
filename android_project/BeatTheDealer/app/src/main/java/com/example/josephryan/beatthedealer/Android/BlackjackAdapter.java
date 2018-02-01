package com.example.josephryan.beatthedealer.Android;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.josephryan.beatthedealer.DeckOfCards.Card;
import com.example.josephryan.beatthedealer.DeckOfCards.Rank;
import com.example.josephryan.beatthedealer.DeckOfCards.RankHashMap;
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
    RankHashMap ranks;

    public BlackjackAdapter(ArrayList<Card> playerHand){
        this.playerHand = playerHand;
        suitImages = new ImageResourceFinder();
        ranks = new RankHashMap();
    }

    public void refreshView(){

        this.notifyDataSetChanged();
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

        String rank = ranks.rankStrings().get(card.getRank());
        holder.number1.setText(rank);
//        holder.number2.setText(rank);
    }

    @Override
    public int getItemCount() {
        return playerHand.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView cardSuit;
        public TextView number1;
        public TextView number2;

        public ViewHolder(View itemView) {
            super(itemView);
            cardSuit = itemView.findViewById(R.id.card_image);
            number1 = itemView.findViewById(R.id.player_card_number1);
//            number2 = itemView.findViewById(R.id.player_card_number2);
        }
    }
}
