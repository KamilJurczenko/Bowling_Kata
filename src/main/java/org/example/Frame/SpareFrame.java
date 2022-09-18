package org.example.Frame;

import org.example.BowlingGame;

public class SpareFrame extends Frame{
    public SpareFrame(int firstRoll, int secondRoll) {
        addRoll(firstRoll);
        addRoll(secondRoll);
    }

    @Override
    public void setScore(){
        score += rolls.get(0) + rolls.get(1) + BowlingGame.rolls[firstRollIndex + 2];
    }
}
