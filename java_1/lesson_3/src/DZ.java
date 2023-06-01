import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DZ {

    public static void taskNoNumber() throws IOException {

        System.out.println();

        FileReader reader = new FileReader("src/randomMassive.txt");
        Scanner scanner = new Scanner(reader);

        int numberOfRows = scanner.nextInt();
        int numberOfCollums = scanner.nextInt();
        int array[][] = new int[numberOfRows][numberOfCollums];
        int sumOfSecondaryDiagonal = 0;
        int sumOfNumberUpperMainDiagonal = 0;
        int minNumberInMatrix = Integer.MAX_VALUE;
        int[] minNumberInRowIndexArray = new int[numberOfCollums];
        int minNumberInRowIndex = 0;
        int[] maxNumberInCollumIndexArray = new int[numberOfRows];
        int[] maxNumberInCollums = new int[numberOfRows];

        for (int i = 0; i < numberOfRows; i++) {
            maxNumberInCollums[i] = Integer.MIN_VALUE;
        }

        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfCollums; j++) {
                array[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfCollums; j++) {
                System.out.print(array[i][j]);
                if (j != numberOfCollums - 1) {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
        for (int i = 0; i < numberOfRows; i++) {
            sumOfSecondaryDiagonal += array[i][numberOfCollums - 1 - i];
        }
        System.out.println("sumOfSecondaryDiagonal: " + sumOfSecondaryDiagonal);


        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfCollums; j++) {
                if (minNumberInMatrix > array[i][j]) {
                    minNumberInMatrix = array[i][j];
                }
            }
        }
        System.out.println("minNumberMatrix: " + minNumberInMatrix);


        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfCollums; j++) {
                if (j > i) {
                    sumOfNumberUpperMainDiagonal += array[i][j];
                }
            }
        }
        System.out.println("sumOfNumberUpperMainDiagonal: " + sumOfNumberUpperMainDiagonal);


        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfCollums; j++) {
                if (array[i][minNumberInRowIndex] > array[i][j]) {
                    minNumberInRowIndex = j;
                }
                if (array[maxNumberInCollumIndexArray[j]][j] < array[i][j]) {
                    maxNumberInCollumIndexArray[j] = i;
                }
            }
            minNumberInRowIndexArray[i] = minNumberInRowIndex;
        }

        for (int i = 0; i < numberOfCollums; i++) {
            for (int j = 0; j < numberOfCollums; j++) {
                if (i == maxNumberInCollumIndexArray[j] && j == minNumberInRowIndexArray[i]) {
                    System.out.println("Saddle point of a matrix: array[" + i + "][" + j + "] = " + array[i][j]);
                }
            }
        }
    }

    public static void taskFirst() {
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        System.out.println("taskFirst, revers array, enter array");
//        System.out.println("10");
//        int arrayLength = scanner.nextInt();
//        System.out.println("enter array");
        System.out.println("80 15 28 48 99 14 80 36 28 45");
//        int array[] = new int[arrayLength];
//        for (int i=0; i<array.length; i++) {
//            array[i] = scanner.nextInt();
//        }
//        for (int i=array.length-1; i>=0; i--) {
//            System.out.print(array[i]);
//            if (i!=0) {
//                System.out.print("\t");
//            }
//        }
        String inputString = scanner.nextLine();
        String[] numbers = inputString.split(" ");
        String reversNumbersString = "";

        for (int i = 0; i < numbers.length; i++) {
            reversNumbersString += numbers[numbers.length - 1 - i];
            if (i != numbers.length - 1) {
                reversNumbersString += "\t";
            }
        }
        System.out.println(reversNumbersString);
    }

    public static void taskSecond() {
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        System.out.println("taskSecond, bubl sort array, enter array");
        System.out.println("80 15 28 48 99 14 80 36 28 45");
        String inputString = scanner.nextLine();
        String[] numbersString = inputString.split(" ");
        int[] numbers = new int[numbersString.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(numbersString[i]);
        }

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 0; j < numbers.length - i - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }


        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]);
            if (i != numbers.length) {
                System.out.print("\t");
            }
        }
    }

    public static void taskThird () {
        System.out.println();

        Scanner scanner = new Scanner(System.in);

        System.out.println();

        System.out.println("taskThird, binary search, input search to number");
        System.out.println("72");
        int numberToSearch = 0;
        try {
            numberToSearch = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("need number");
            return;
        }
        scanner.nextLine();

        System.out.println("input bublsort array");
        System.out.println("15 20 25 40 55 56 62 72 86 99");
        String inputString = scanner.nextLine();
        int[] numbers = new int[0];
        try {
            String[] numbersString = inputString.split(" ");
            numbers = new int[numbersString.length];
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = Integer.parseInt(numbersString[i]);
            }
        } catch (NumberFormatException e) {
            System.out.println("wrong array");
            return;
        }

        int low = 0;
        int hight = numbers.length - 1;
        while (low <= hight) {
            int mid = (low + hight) / 2;
            if (numbers[mid] < numberToSearch) {
                low = mid + 1;
            } else if (numbers[mid] > numberToSearch) {
                hight = mid - 1;
            } else {
                System.out.println("array [" + mid + "] : " + numbers[mid]);
                return;
            }
        }
        System.out.println(numberToSearch+" not found");
    }

    public static void taskForth () throws IOException {
        System.out.println();


        System.out.println("taskFourth saperInput.txt");

        FileReader reader = new FileReader("src/saperInput.txt");
        Scanner scanner = new Scanner(reader);

        int numberOfRow = 0;
        int numberOfCollum = 0;
        int numberStringInInputFile = 0;
        try {
            numberOfRow = scanner.nextInt();
            numberOfCollum = scanner.nextInt();
            numberStringInInputFile = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("wrong input");
            return;
        }

        int[][] map = new int[numberOfRow][numberOfCollum];

        for (int i = 0; i < numberOfRow; i++) {
            for (int j = 0; j < numberOfCollum; j++) {
                map[i][j] = 0;
            }
        }
        try {
            for (int i = 0; i < numberStringInInputFile; i++) {
                int numberRowOfMine = scanner.nextInt() - 1;
                int numberCollumOfMine = scanner.nextInt() - 1;
                map[numberRowOfMine][numberCollumOfMine] = 9;
            }
        } catch (InputMismatchException e) {
            System.out.println("wrong input");
            return;
        }
        reader.close();

        for (int i = 0; i < numberOfRow; i++) {
            for (int j = 0; j < numberOfCollum; j++) {
                if (map[i][j] == 9) {
                    continue;
                }
                int counter = 0;
                try {
                    if (map[i - 1][j - 1] == 9) {
                        counter++;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                }
                try {
                    if (map[i - 1][j] == 9) {
                        counter++;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                }
                try {
                    if (map[i - 1][j + 1] == 9) {
                        counter++;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                }
                try {
                    if (map[i][j - 1] == 9) {
                        counter++;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                }
                try {
                    if (map[i][j + 1] == 9) {
                        counter++;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                }
                try {
                    if (map[i + 1][j - 1] == 9) {
                        counter++;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                }
                try {
                    if (map[i + 1][j] == 9) {
                        counter++;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                }
                try {
                    if (map[i + 1][j + 1] == 9) {
                        counter++;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                }
                map[i][j] = counter;
            }
        }

        for (int i = 0; i < numberOfRow; i++) {
            for (int j = 0; j < numberOfCollum; j++) {
                if (map[i][j] == 9) {
                    System.out.print("*");
                } else if (map[i][j] == 0) {
                    System.out.print(".");
                } else {
                    System.out.print(map[i][j]);
                }
                if (j != numberOfCollum) {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }


    public static void taskFifth () {
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        System.out.println("taskFifth, spiral array, input size");
        int numRow = 0;
        try {
            numRow = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("wrong input");
        }
        int numColumns = numRow;
        int [][] array = new int[numRow][numColumns];


        int numCurrent = 1;
        int counterHalfCircl = 1;
        int counter = 1;
        int currRow = 0;
        int currColumn = 0;

        while (numCurrent < numRow*numColumns) {

            //right
            while (counter <= numColumns - counterHalfCircl){
                array[currRow][currColumn] = numCurrent;
                numCurrent++;
                currColumn++;
                counter++;
            }
            if (numCurrent != numColumns) {
                counterHalfCircl++;
            }
            counter = 1;

            //down
            while (counter <= numRow - counterHalfCircl){
                array[currRow][currColumn] = numCurrent;
                numCurrent++;
                currRow++;
                counter++;
            }
            counter = 1;

            //left
            while (counter <= numColumns - counterHalfCircl){
                array[currRow][currColumn] = numCurrent;
                numCurrent++;
                currColumn--;
                counter++;
            }
            counterHalfCircl++;
            counter = 1;

            //up
            while (counter <= numRow - counterHalfCircl){
                array[currRow][currColumn] = numCurrent;
                numCurrent++;
                currRow--;
                counter++;
            }
            counter = 1;

        }

        //add last number
        if (numCurrent == numRow*numColumns) {
            array[currRow][currColumn] = numCurrent;
        }

        for (int i = 0; i<numRow; i++) {
            for (int j = 0; j<numColumns; j++) {
                System.out.print(array[i][j]);
                if (j!=numColumns) {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }
}
