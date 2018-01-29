package com.example.josephryan.beatthedealer.Activities;

import android.widget.ImageView;

import com.example.josephryan.beatthedealer.DeckOfCards.Suit;
import com.example.josephryan.beatthedealer.R;

import java.util.HashMap;

/**
 * Created by josephryan on 29/01/2018.
 */

public class ImageResourceFinder {

    public HashMap<Suit, Integer> cardIcons(){
        HashMap<Suit, Integer> images = new HashMap<>();
        images.put(Suit.CLUBS, R.drawable.clubstemplate);
        images.put(Suit.SPADES, R.drawable.spadestemplate);
        images.put(Suit.HEARTS, R.drawable.heartstemplate);
        images.put(Suit.DIAMONDS, R.drawable.diamondstemplate);
        return images;
    }

//    ImageView img = new ImageView();

//    img.setImageResource(images.get(Suit.CLUBS));
}
