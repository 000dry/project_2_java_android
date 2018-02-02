package com.example.josephryan.beatthedealer.Persons;



public class Player extends Person {

    public Player(int score, boolean inGame){
        super(score, inGame);
    }

    public boolean getInGame(){
        return this.inGame;
    }

    public void setInGameToTrue(){
        this.inGame = true;
    }

    public void inGameBooleanSwitch(){
        this.inGame = this.getInGame() ? false : true;
    }

    public void blackjackInGameBooleanSwitch(){
        int aceCount = this.checkHandForAces();

        if(aceCount == 0 && this.checkValueOfHand() <= 21)
            this.inGame = this.getInGame() ? false : true;
    }

}
