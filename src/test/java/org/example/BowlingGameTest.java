package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BowlingGameTest {

    private int allRollsEq(int pinNum, int numRolls){
        BowlingGame bowlingGame = new BowlingGame();
        for(int i = 0; i < numRolls; i++)
            bowlingGame.roll(pinNum);
        return bowlingGame.getScore();
    }

    private int allRollsNotEq(int firstPinNum, int secondPinNum, int numFrames){
        BowlingGame bowlingGame = new BowlingGame();
        for(int i = 0; i < numFrames; i++){
            bowlingGame.roll(firstPinNum);
            bowlingGame.roll(secondPinNum);
        }
        return bowlingGame.getScore();
    }

    @Test
    void strikeAll(){
        assertEquals(300, allRollsEq(10, 12));
    }

    @Test
    void nineAndMissAll(){
        assertEquals(90, allRollsNotEq(9, 0, 10));
    }

    @Test
    void fiveAndSpareAll(){
        assertEquals(150, allRollsEq(5, 21));
    }

    @Test
    void missAll(){
        assertEquals(0, allRollsEq(0, 20));
    }

}