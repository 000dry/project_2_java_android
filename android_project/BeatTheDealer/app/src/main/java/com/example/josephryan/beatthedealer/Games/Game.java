package com.example.josephryan.beatthedealer.Games;

import com.example.josephryan.beatthedealer.DeckOfCards.Card;
import com.example.josephryan.beatthedealer.Persons.Person;

import java.util.ArrayList;

/**
 * Created by josephryan on 30/01/2018.
 */

public abstract class Game {

    ArrayList<Person> playersInGame;

    public Game(){
        this.playersInGame = new ArrayList<>();
    }

    public void addPlayer(Person person) {
        this.playersInGame.add(person);
    }

    public Person getPlayer(int i){
        return this.playersInGame.get(i);
    }

    public int getPlayerCount() {
        return this.playersInGame.size();
    }

    public int checkCardValue(Person person, int index) {
        Card hand = person.getHand().get(index);
        int value = hand.getRank().getValue();

        return value;
    }

    public int checkValueOfHand(Person person) {
        int value = 0;

        for(int i = 0; i < person.getHand().size(); i++){
            value += this.checkCardValue(person, i);
        }
        return value;
    }

    public void updateScore(Person person, int points){
        if(points < 0 && person.getScore() == 0) {
            return;
        }
        person.score += points;
    }
}
