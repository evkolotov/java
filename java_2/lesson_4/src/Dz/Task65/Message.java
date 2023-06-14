package Dz.Task65;

public class Message {
    private Integer[] messageValue;
    private Integer[] messageInitValue;
    private int coefficientHamming;
    private int numberMessage;

    public int getCoefficientHamming() {
        return coefficientHamming;
    }
    public Message(Integer[] messageValue, Integer[] messageInitValue, int numberMessage) {
        this.messageValue = messageValue;
        this.messageInitValue = messageInitValue;
        this.numberMessage = numberMessage;
    }
    public void calculateCoefficientHamming() {
        coefficientHamming = 0;
        for (int i=0; i<messageValue.length; i++) {
            if (messageValue[i] != messageInitValue[i]) {
                coefficientHamming++;
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%d", numberMessage);
    }
}
