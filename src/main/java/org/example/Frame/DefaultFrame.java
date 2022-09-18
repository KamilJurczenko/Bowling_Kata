package org.example.Frame;

public class DefaultFrame extends Frame{

    public DefaultFrame(int firstRoll, int secondRoll) {
        addRoll(firstRoll);
        addRoll(secondRoll);
    }

    @Override
    public void setScore(){
        score += rolls.get(0) + rolls.get(1);
    }
}
