package com.example.josephryan.beatthedealer.DeckOfCards;

import java.util.HashMap;

/**
 * Created by josephryan on 30/01/2018.
 */

public class RankHashMap {

    public HashMap<Rank, String> rankStrings(){
        HashMap<Rank, String> ranks = new HashMap<>();
        ranks.put(Rank.ACE, "A");
        ranks.put(Rank.TWO, "2");
        ranks.put(Rank.THREE, "3");
        ranks.put(Rank.FOUR, "4");
        ranks.put(Rank.FIVE, "5");
        ranks.put(Rank.SIX, "6");
        ranks.put(Rank.SEVEN, "7");
        ranks.put(Rank.EIGHT, "8");
        ranks.put(Rank.NINE, "9");
        ranks.put(Rank.TEN, "10");
        ranks.put(Rank.JACK, "J");
        ranks.put(Rank.QUEEN, "Q");
        ranks.put(Rank.KING, "K");
        return ranks;
    }
}
