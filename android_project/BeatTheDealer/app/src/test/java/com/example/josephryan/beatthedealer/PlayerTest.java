package com.example.josephryan.beatthedealer;

import com.example.josephryan.beatthedealer.Persons.Player;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    Player player1;
    Player player2;

    @Before
    public void before(){
        player1 = new Player(0, true);
        player2 = new Player(0, false);
    }

    @Test
    public void canGetInGame(){
        assertEquals(true, player1.getInGame());
    }

    @Test
    public void canSetInGameToTrue(){
        player2.setInGameToTrue();
        assertEquals(true, player2.getInGame());
    }

    @Test
    public void canSwitchBoolean(){
        player1.inGameBooleanSwitch();
        assertEquals(false, player1.getInGame());
    }

}
