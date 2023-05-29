import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DZ {
    private static Scanner scanner = new Scanner(System.in);
    public static void firstTask () {
        System.out.println("firstTask bulls and cow");

        byte bulls = 0;
        byte cows = 0;
        int randNumber = 0;
        Random random = new Random();
        do {
            randNumber = random.nextInt(1000,9999);
        } while (!checkNumberForBulls(randNumber));

        String randNumberString = Integer.toString(randNumber);

        while (true) {
            System.out.println("g play, enter digits, \"stop\" for end game");

            String inputString = scanner.nextLine();
            if (inputString.equals("stop")) {
                return;
            }

            try {
                int inputInteger = Integer.parseInt(inputString);
                if (!checkNumberForBulls(inputInteger)) {
                    System.out.println("wrong number, need 4 unic digits");
                    continue;
                }
                for (int i = 0; i<randNumberString.length(); i++) {
                    for (int j = i; j<randNumberString.length(); j++) {
                        if (randNumberString.charAt(i) == inputString.charAt(j)) {
                            if (i == j) {
                                bulls++;
                            } else {
                                cows++;
                            }
                        }
                    }
                }
                System.out.println(inputInteger+":\t"+bulls+" bulls,\t"+cows+" cows");
                if (bulls == 4) {
                    System.out.println("congrat");
                    break;
                }
                bulls = 0;
                cows = 0;
            } catch (NumberFormatException e) {
                System.out.println("NumberFormatException");
            }
        }
    }
    private static boolean checkNumberForBulls (int number) {
        String numberString = Integer.toString(number);
        if (numberString.length() != 4) {
            return false;
        }
        for (int i=0; i<numberString.length(); i++) {
            for (int j = i+1; j<numberString.length(); j++) {
                if (numberString.charAt(i) == numberString.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void secondTask() {
        System.out.println("secondTask palindrome \nasddsa");

        String inputString = scanner.nextLine();

        for (int i = 0; i < inputString.length() / 2; i++) {
            if (inputString.charAt(inputString.length() - i - 1) != inputString.charAt(i)) {
                System.out.println("it's not a palindrome");
                break;
            } else if (i == inputString.length() / 2 - 1) {
                System.out.println("it's a palindrome");
            }
        }

    }
    public static void thirdTask () {

        System.out.println("thirdTask lucky ticket \n73056423");

        String ticketString = scanner.nextLine();
        long tickedInteger = 0;


        try {
            tickedInteger = Long.parseLong(ticketString);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException");
            return;
        }

        int sumOfNumber = 0;

        if (ticketString.length() % 2 != 0) {
            System.out.println("odd number");
        } else {

            for (int i = 0; i < ticketString.length() + 1; i++) {

                if (i < ticketString.length() / 2) {
                    sumOfNumber += tickedInteger % 10;
                } else {
                    sumOfNumber -= tickedInteger % 10;
                }
                tickedInteger /= 10;
            }

            if (sumOfNumber == 0) {
                System.out.println("lucky number");
            } else {
                System.out.println("unlucky number");
            }
        }

    }
    public static void fourthTask () {

        System.out.println("fourthTask max number of null in a row \n100011111001010101010");
        int maxNumberNull = 0;
        int currentNumberNull = 0;

        String inputString = null;

        inputString = scanner.nextLine();

        if (inputString.matches("[01]+")) {
            for (int i = 0; i < inputString.length(); i++) {
                char c = inputString.charAt(i);
                if (c == '0') {
                    currentNumberNull++;
                    maxNumberNull = Math.max(maxNumberNull, currentNumberNull);
                } else {
                    currentNumberNull = 0;
                }
            }
        } else {
            System.out.println("Wrong digits");
            return;
        }
        System.out.println(maxNumberNull);
    }
    public static void fifthTask () {

        System.out.println("fifthTask pow string, input letter \nasdasdasd");
        String inputFirstLine = scanner.nextLine();
        String result = "";

        if (!inputFirstLine.matches("[a-z]+")) {
            System.out.println("firstLine must be a letters");
            return;
        }

        System.out.println("input number \n3 or -3");
        if (!scanner.hasNextInt()) {
            System.out.println("second line must be a number");
            return;
        }
        int inputSecondLine = scanner.nextInt();

        if (inputSecondLine == 0) {
            System.out.println("second line must be != 0");
            return;
        } else if (inputSecondLine > 0) {
            for (int i = 0; i < inputSecondLine; i++) {
                result += inputFirstLine;
            }
            if (result.length() > 1023) {
                result = result.substring(0,1023);
            }
            System.out.println(result);
            return;
        }

        inputSecondLine = Math.abs(inputSecondLine);

        if ((inputFirstLine.length() % inputSecondLine) == 0 ) {
            int lengthResult = inputFirstLine.length() / inputSecondLine;
            for (int i = 0; i < lengthResult; i++) {
                if (inputFirstLine.charAt(i) != inputFirstLine.charAt(i+lengthResult)) {
                    System.out.println("no solution");
                    return;
                }
            }
            result = inputFirstLine.substring(0,lengthResult);
            System.out.println(result);
        } else {
            System.out.println("no solution");
        }
    }
    public static void sixthTask () {

        String result = "";
        String resultFormated = "";
        int currentNumberDigits = 0;
        char currentChar = ' ';
        int lineLength = 40;

        scanner.nextLine();
        System.out.println("sixthTask \"3A5D35XW\" string, enter your string");
        String inputString = scanner.nextLine();
        if (inputString.matches("\\d+")) {
            System.out.println("wrong input, input string has only digits");
            return;
        }

        for (int i = 0; i<inputString.length(); i++) {
            currentChar = inputString.charAt(i);
            if (Character.isDigit(currentChar)) {
                currentNumberDigits = currentNumberDigits*10 + Character.getNumericValue(currentChar);
            } else if (Character.isUpperCase(currentChar)) {
                result += String.valueOf(currentChar).repeat(Math.max(1, currentNumberDigits));
                currentNumberDigits = 0;
            } else {
                System.out.println("wrong input, need digits and letters in upper case");
                return;
            }
        }

        for (int i=0; i < result.length(); i++) {
            if ((i % 40) == 0) {
                resultFormated += "\n";
            }
            resultFormated += result.charAt(i);
        }
        System.out.println(resultFormated);

    }
    public static void seventhTask () {

        System.out.println("seventhTask number word in text \n" +
                "aaaaaa asd aaaaaa awdwqwedas zxcxzc aaaaaa zxcxzc");
        String inputString = scanner.nextLine();
        String [] words = inputString.split(" ");
        int counter;
        String result = "";
        for (int i=0; i<words.length;i++) {
            counter = 1;
            if (words[i].equals("0")) {
                continue;
            }
            for (int j = i+1; j < words.length; j++) {
                if (words[i].equals(words[j])) {
                    counter++;
                    words[j] = "0";
                }
            }
            result += words[i]+"\t"+counter+"\n";
        }
        System.out.println(result);
    }

}
