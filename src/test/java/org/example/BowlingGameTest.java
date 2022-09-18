package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BowlingGameTest {

    BowlingGame bowlingGame;
    int numFrames = 10;
    @BeforeEach
    void constructGame(){
        bowlingGame = new BowlingGame();
    }

    @Test
    void strikeAll(){
        for(int i = 0; i < numFrames; i++)
            bowlingGame.rollStrike();
        bowlingGame.rollBonus(10);
        bowlingGame.rollBonus(10);
        assertEquals(300, bowlingGame.getScore());
    }

    @Test
    void nineAndMissAll(){
        for(int i = 0; i < numFrames; i++)
            bowlingGame.rollDefault(9,0);
        assertEquals(90, bowlingGame.getScore());
    }

    @Test
    void fiveAndSpareAll(){
        for(int i = 0; i < numFrames; i++)
            bowlingGame.rollSpare(5,5);
        bowlingGame.rollBonus(5);
        assertEquals(150, bowlingGame.getScore());
    }

    @Test
    void missAll(){
        for(int i = 0; i < numFrames; i++)
            bowlingGame.rollDefault(0,0);
        assertEquals(0, bowlingGame.getScore());
    }

}