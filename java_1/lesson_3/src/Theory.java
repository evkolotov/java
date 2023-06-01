import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class Theory {

    public static void theoryCheck() throws IOException {

        String pathToFile = "src/test.txt";
        int sizeOfArray = 5;
        int maxRandomNumber = 100;

        Random random = new Random();
        FileWriter writer = new FileWriter(pathToFile);
        writer.write(Integer.toString(sizeOfArray)+"\n");
        for (int i=0; i<sizeOfArray; i++) {
            int randomNumber = random.nextInt(maxRandomNumber);
            String randomNumberString = Integer.toString(randomNumber);
            writer.write(randomNumberString);
            if (i != sizeOfArray-1) {
                writer.write("\t");
            }
        }
        writer.close();


        FileReader reader = new FileReader(pathToFile);
        Scanner scanner = new Scanner(reader);

//        while (scanner.hasNextLine()) {
//            String line = scanner.nextLine();
//            System.out.println(line);
//        }

        sizeOfArray = scanner.nextInt();
        int [] array = new int[sizeOfArray];
        for (int i=0; i<sizeOfArray; i++) {
            array[i] = scanner.nextInt();
        }
        reader.close();

        for (int i=0; i<sizeOfArray; i++) {
            System.out.println("array["+i+"] = "+array[i]);
            if (i != array.length - 1) {
                System.out.println("\t");
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i=0; i<sizeOfArray; i++) {
            if (array[i]>max) {
                max = array[i];
            }
        }
        System.out.println("\n"+"max: "+max);

    }

    public static void taskFirst() throws IOException {
        String pathToFile = "src/test.txt";
        int sizeOfArray = 0;
        int counter = 1;
        int sum = 0;
        int average = 0;

        FileReader reader = new FileReader(pathToFile);
        Scanner scanner = new Scanner(reader);
        sizeOfArray = scanner.nextInt();
        int [] array = new int[sizeOfArray];
        for (int i=0; i<sizeOfArray; i++) {
            array[i] = scanner.nextInt();
            sum += array[i];
        }
        reader.close();

        for (int i = 0; i<sizeOfArray; i++) {
            if (array[i]==0) {
                continue;
            }
            for (int j = i+1; j<sizeOfArray;j++) {
                if (array[i] == array[j]){
                    array[j] = 0;
                    counter++;
                }

            }
            System.out.println("array["+i+"] = "+array[i]+" occurs in array "+counter+" times");
            counter = 1;
        }
    }
    public static void taskSecond () throws IOException {
        String pathToFile = "src/test.txt";
        int sizeOfArray = 0;

        FileReader reader = new FileReader(pathToFile);
        Scanner scanner = new Scanner(reader);
        sizeOfArray = scanner.nextInt();
        int [] array = new int[sizeOfArray];
        for (int i=0; i<sizeOfArray; i++) {
            array[i] = scanner.nextInt();
        }
        reader.close();

        int min = Integer.MAX_VALUE;
        for (int i=0; i<sizeOfArray; i++) {
            if (array[i]<min) {
                min = array[i];
            }
        }
        System.out.println("\n"+"min: "+min);
    }
    public static void taskThird () throws IOException {
        String pathToFile = "src/test.txt";
        int sizeOfArray = 0;
        int sum = 0;

        FileReader reader = new FileReader(pathToFile);
        Scanner scanner = new Scanner(reader);
        sizeOfArray = scanner.nextInt();
        int [] array = new int[sizeOfArray];
        for (int i=0; i<sizeOfArray; i++) {
            array[i] = scanner.nextInt();
            sum += array[i];
        }
        reader.close();
        System.out.println("sum: "+sum);
    }
    public static void taskFourth() throws IOException {
        String pathToFile = "src/test.txt";
        int sizeOfArray = 0;
        int sum = 0;
        int average = 0;

        FileReader reader = new FileReader(pathToFile);
        Scanner scanner = new Scanner(reader);
        sizeOfArray = scanner.nextInt();
        int [] array = new int[sizeOfArray];
        for (int i=0; i<sizeOfArray; i++) {
            array[i] = scanner.nextInt();
            sum += array[i];
        }
        reader.close();
        average = sum / sizeOfArray;
        System.out.println("average: "+average);
    }
    public static void taskFifth () throws IOException {
        String pathToFile = "src/test.txt";
        int sizeOfArray = 0;
        int findElement = 22;

        FileReader reader = new FileReader(pathToFile);
        Scanner scanner = new Scanner(reader);
        sizeOfArray = scanner.nextInt();
        int [] array = new int[sizeOfArray];
        for (int i=0; i<sizeOfArray; i++) {
            array[i] = scanner.nextInt();
        }
        reader.close();
        Arrays.sort(array);
        int low = 0;
        int hight = array.length - 1;
        while (low <= hight) {
            int mid = (low+hight) / 2;
            if (array[mid] < findElement) {
                low = mid+1;
            } else if (array[mid] > findElement) {
                hight = mid-1;
            } else {
                System.out.println("array ["+mid+"] : "+array[mid]);
                return;
            }
        }

    }
    public static void randomMassiveWrite () throws IOException {
        FileWriter writer = new FileWriter("src/randomMassive.txt");
        Random random = new Random();
        int numberOfRows = 10;
        int numberOfColums = 10;
        int maxRandomNumber = 100;
        writer.write(Integer.toString(numberOfRows));
        writer.write("\t");
        writer.write(Integer.toString(numberOfColums));
        writer.write("\n");
        for (int i=1; i<=numberOfRows; i++) {
            for (int j=1; j<=numberOfColums; j++) {
                int randomNumber = random.nextInt(maxRandomNumber);
                String line = Integer.toString(randomNumber);
                writer.write(line);
                if (j!=numberOfColums) {
                    writer.write("\t");
                }
            }
            writer.write("\n");
        }
        writer.close();
    }
    public static void randomMassiveRead () throws IOException {
        FileReader reader = new FileReader("src/randomMassive.txt");
        Scanner scanner = new Scanner(reader);

        int numberOfRows = scanner.nextInt();
        int numberOfColums = scanner.nextInt();

        int array [][] = new int[numberOfRows][numberOfColums];
        for (int i=0; i<numberOfRows; i++) {
            for (int j=0; j<numberOfColums; j++) {
                array[i][j] = scanner.nextInt();
            }
        }

        for (int i=0; i<numberOfRows; i++) {
            for (int j=0; j<numberOfColums; j++) {
                System.out.print(array[i][j]);
                if (j!=numberOfColums-1) {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }


}
