package org.example.Frame;

import org.example.BowlingGame;

public class StrikeFrame extends Frame{

    public StrikeFrame() {
        addRoll(10);
    }

    @Override
    public void setScore(){
        score += rolls.get(0) + BowlingGame.rolls[firstRollIndex + 1] + BowlingGame.rolls[firstRollIndex + 2];
    }
}
