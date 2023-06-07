import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {

//        try {
//            User user = new User(100, "stas");
//            user.spendMoney(110);
//        } catch (BalanceException e) {
//            System.out.println(e.toString());
//        }

//        Ball miniBall = new Ball(10, "miniBall");
//        Ball bigBall = new Ball(100, "bigBall");
//        Ball midleBall = new Ball(50, "midleBall");
//        BallComparator ballComparator = new BallComparator();
//        Set<Ball> balls = new TreeSet<>(ballComparator);
//        balls.add(bigBall);
//        balls.add(miniBall);
//        balls.add(midleBall);
//        System.out.println(balls);

        FileReader fileReader = new FileReader("src/Time.txt");
        Scanner scanner = new Scanner(fileReader);
        int numberOfLine = Integer.parseInt(scanner.nextLine());
        TimeComparator timeComparator = new TimeComparator();
        Set<Time>times = new TreeSet<>(timeComparator);
        for (int i = 0; i<numberOfLine; i++) {
            String currentLine = scanner.nextLine();
            String [] currentLineSplit = currentLine.split(" ");
            Time time = new Time(Integer.parseInt(currentLineSplit[0]), Integer.parseInt(currentLineSplit[1]), Integer.parseInt(currentLineSplit[2]));
            times.add(time);
        }
        for (Time time : times) {
            System.out.println(time);
        }
    }
}