package org.example.Frame;

// a frame has two rolls to knock down all pins
abstract public class Frame {

    private int score = 0;
    private String scoreIndicator;

    public Frame() {
    }

    public abstract void setScore(int score);

    public int getScore() {
        return score;
    }
}
