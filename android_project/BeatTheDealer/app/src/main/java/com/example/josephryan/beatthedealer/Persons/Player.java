package com.example.josephryan.beatthedealer.Persons;



public class Player extends Person {

    int score;
    boolean inGame;

    public Player(int score, boolean inGame){
        super(score);
        this.inGame = inGame;
    }

    public boolean getInGame(){
        return this.inGame;
    }

    public void inGameBooleanSwitch(){
        this.inGame = this.getInGame() ? false : true;
    }

}
