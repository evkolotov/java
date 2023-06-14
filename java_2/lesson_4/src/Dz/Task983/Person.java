package Dz.Task983;

public class Person {
    private int initStep;
    private int speed;

    public int getNumberSecondsForEnd() {
        return numberSecondsForEnd;
    }

    public void setNumberSecondsForEnd(int numberSecondsForEnd) {
        this.numberSecondsForEnd = numberSecondsForEnd;
    }
    public int getInitStep() {
        return initStep;
    }

    private int numberSecondsForEnd;
    public Person (Integer[] value) {
        this.speed = value[0];
        this.initStep = value[1];
    }
    public void calculateTime() {
        this.numberSecondsForEnd = initStep*speed;
    }

    @Override
    public String toString() {
        return String.format("%d", numberSecondsForEnd);
    }
}
