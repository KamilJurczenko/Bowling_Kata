package org.example.Frame;

import org.example.BowlingGame;

import java.util.ArrayList;

// a frame has two rolls to knock down all pins
abstract public class Frame {

    protected ArrayList<Integer> rolls;
    protected int score = 0;
    private String scoreIndicator;
    protected int firstRollIndex;

    public abstract void setScore();

    public Frame() {
        rolls = new ArrayList<>();
        firstRollIndex = BowlingGame.rollCount;
        BowlingGame.framesCount++;
    }

    public int getScore() {
        return score;
    }

    public void addRoll(int numPin){
        // add to frame (local) roll list
        rolls.add(numPin);
        // add to game (global) roll list
        BowlingGame.rolls[BowlingGame.rollCount] = numPin;
        BowlingGame.rollCount++;
    }
}
