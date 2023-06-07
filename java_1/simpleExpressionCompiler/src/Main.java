import CheckValid.CheckValid;
import Pars.Parser;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Input simple expression \n" +
                    "int x53_asd = 5 + 3");
            String inputLine = scanner.nextLine();

            CheckValid checkValid = new CheckValid();
            if (!checkValid.checkValidLine(inputLine)) {
                System.out.println("false");
                continue;
            }

            Parser parser = new Parser(inputLine);
            parser.parseInputLine();

            try {
                checkValid.setInputTypeVariable(parser.getInputTypeVariable());
                checkValid.setNameVariable(parser.getNameVariable());
                checkValid.setFirstNumber(parser.getFirstNumber());
                checkValid.setOperation(parser.getOperation());
                checkValid.setSecondNumber(parser.getSecondNumber());
            } catch (NullPointerException e) {
                System.out.println("false");
                continue;
            }

            System.out.println(checkValid.checkValidExpression());
            System.out.println();
        }
    }
}