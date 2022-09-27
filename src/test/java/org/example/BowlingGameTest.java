package org.example;

import org.junit.jupiter.api.AfterEach;
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

    @AfterEach
    void frameCountTest(){
        assertEquals(10, BowlingGame.framesCount);
    }

    @Test
    void strikeAll(){
        for(int i = 0; i < numFrames; i++)
            bowlingGame.rollStrike();
        bowlingGame.rollBonus(10);
        bowlingGame.rollBonus(10);
        assertEquals(300, bowlingGame.getScore());
        assertEquals(12, BowlingGame.rollCount);
    }

    @Test
    void nineAndMissAll(){
        for(int i = 0; i < numFrames; i++)
            bowlingGame.rollDefault(9,0);
        assertEquals(90, bowlingGame.getScore());
        assertEquals(20, BowlingGame.rollCount);
    }

    @Test
    void fiveAndSpareAll(){
        for(int i = 0; i < numFrames; i++)
            bowlingGame.rollSpare(5,5);
        bowlingGame.rollBonus(5);
        assertEquals(150, bowlingGame.getScore());
        assertEquals(21, BowlingGame.rollCount);
    }

    @Test
    void missAll(){
        for(int i = 0; i < numFrames; i++)
            bowlingGame.rollDefault(0,0);
        assertEquals(0, bowlingGame.getScore());
        assertEquals(20, BowlingGame.rollCount);
    }

    // TODO Random valid input test
    //@RepeatedTest()

}