package com.example.josephryan.cardgame;

import java.util.ArrayList;

/**
 * Created by josephryan on 27/01/2018.
 */

public interface IHandable {

    ArrayList<Card> getHand();

    void acceptCard(Card card);
}
