package Pars;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private String inputLine = "";
    private String inputTypeVariable;
    private String nameVariable;
    private Double firstNumber;
    private char operation;
    private Double secondNumber;

    public Parser(String inputLine) {
        this.inputLine = inputLine;
    }

    public void parseInputLine () {
        try {
            String [] inputLineSplitOnEquals = inputLine.split("=");
            String [] inputLineSplitOnTypeAndName = inputLineSplitOnEquals [0].split(" ");
            inputTypeVariable = inputLineSplitOnTypeAndName[0];
            nameVariable = inputLineSplitOnTypeAndName[1];
            String [] inputLineSplitOnFirstSecondNumber = inputLineSplitOnEquals[1].split("[+\\-*/]");
            firstNumber = Double.parseDouble(inputLineSplitOnFirstSecondNumber[0]);
            secondNumber = Double.parseDouble(inputLineSplitOnFirstSecondNumber[1]);
            String regexPatternOperation = "[+\\-*/]";
            Pattern pattern = Pattern.compile(regexPatternOperation);
            Matcher matcher = pattern.matcher(inputLineSplitOnEquals[1]);
            if (matcher.find()) {
                int operationIndex = matcher.start();
                char operation = inputLineSplitOnEquals[1].charAt(operationIndex);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("false");
            return;
        }

    }

    public String getInputTypeVariable() {
        return inputTypeVariable;
    }
    public String getNameVariable() {
        return nameVariable;
    }
    public double getFirstNumber() {
        return firstNumber;
    }
    public double getSecondNumber() {
        return secondNumber;
    }
    public char getOperation() {
        return operation;
    }

}
