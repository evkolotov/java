package Dz.Task648;

import Dz.Task;

import java.util.Arrays;
import java.util.stream.Stream;

import static java.lang.Math.abs;


public class Task648 implements Task {
    int numberOfNumbers;
    Integer[] inputNumber;
    @Override
    public void readInputData() {
        numberOfNumbers = Integer.parseInt(scanner.nextLine());
        inputNumber = Arrays.stream(
            scanner.nextLine().split(" ")
        )
        .map(
            Integer::parseInt
        )
        .toArray(Integer[]::new);
    }

    @Override
    public void executeTask() {
        readInputData();
        int halfNumberOfNumbers = numberOfNumbers/2;
        int firstHalfSum = Arrays.stream(inputNumber).limit(halfNumberOfNumbers).reduce((x, y)->x+y).orElse(0);
        int secondHalfSum = Arrays.stream(inputNumber).skip(halfNumberOfNumbers).reduce((x, y)->x+y).orElse(0);
        int result = abs(firstHalfSum - secondHalfSum);

        System.out.println(result);

    }
}
