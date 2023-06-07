package CheckValid;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class CheckValid {

    private String inputLine;
    private String inputTypeVariable;
    private String nameVariable;
    private double firstNumber;
    private char operation;
    private double secondNumber;



    public boolean checkValidLine (String inputLine) {
        return inputLine.matches(
                "^\s*[a-zA-Z]+\s+[\\w_]+\s*=\s*([+-]?\\d+([.]\\d+)?)\s*[-+*/]\s*([+-]?\\d+([.]\\d+)?)\s*$");
    }

    public boolean checkValidExpression () {
        HashMap<String, double[]> typeVariableAndMaxMinNumber = new HashMap();

        double [] minAndMaxByte = {Byte.MIN_VALUE, Byte.MAX_VALUE};
        typeVariableAndMaxMinNumber.put("byte", minAndMaxByte);

        double [] minAndMaxShort = {Short.MIN_VALUE, Short.MAX_VALUE};
        typeVariableAndMaxMinNumber.put("short", minAndMaxShort);

        double [] minAndMaxInteger = {Integer.MIN_VALUE, Integer.MAX_VALUE};
        typeVariableAndMaxMinNumber.put("int", minAndMaxInteger);

        double [] minAndMaxLong = {Long.MIN_VALUE, Long.MAX_VALUE};
        typeVariableAndMaxMinNumber.put("long", minAndMaxLong);

        double [] minAndMaxFloat = {Float.MIN_VALUE, Float.MAX_VALUE};
        typeVariableAndMaxMinNumber.put("float", minAndMaxFloat);

        double [] minAndMaxDouble = {Double.MIN_VALUE, Double.MAX_VALUE};
        typeVariableAndMaxMinNumber.put("double", minAndMaxDouble);

        boolean checkNumberAfterDecimal = true;
        boolean result = true;

        if (!typeVariableAndMaxMinNumber.containsKey(inputTypeVariable)) {
            return false;
        } else if (!(inputTypeVariable.equals("float") || inputTypeVariable.equals("double"))) {
            checkNumberAfterDecimal = checkValidDigitsAfterDecimal(firstNumber) && checkValidDigitsAfterDecimal(secondNumber);
        }
        result= firstNumber >= typeVariableAndMaxMinNumber.get(inputTypeVariable)[0] &&
                firstNumber <= typeVariableAndMaxMinNumber.get(inputTypeVariable)[1] &&
                secondNumber >= typeVariableAndMaxMinNumber.get(inputTypeVariable)[0] &&
                secondNumber <= typeVariableAndMaxMinNumber.get(inputTypeVariable)[1] &&
                checkNumberAfterDecimal;

        return result;
    }
    private boolean checkValidDigitsAfterDecimal (double number) {
        String numberString = Double.toString(number);
        String [] numberSplitDecimal = numberString.split("\\.");
        int numberAfterDecimal = Integer.parseInt(numberSplitDecimal[1]);
        if (numberAfterDecimal > 0) {
            return false;
        } else {
            return true;
        }
    }

    public void setInputTypeVariable (String inputTypeVariable){
    this.inputTypeVariable = inputTypeVariable;
    }

    public void setNameVariable (String nameVariable){
    this.nameVariable = nameVariable;
    }

    public void setFirstNumber ( double firstNumber){
    this.firstNumber = firstNumber;
    }

    public void setOperation ( char operation){
    this.operation = operation;
    }

    public void setSecondNumber ( double secondNumber){
    this.secondNumber = secondNumber;
    }

}
