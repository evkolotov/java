import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        System.out.println("Enter your age");
//
//        Scanner sc = new Scanner(System.in);
//        int age = sc.nextInt();
//        System.out.println("Your age is " + age);
//
//        if (age >= 18) {
//            System.out.println("The beer is your");
//        }
//        else {
//            System.out.println("The beer is not your");
//        }
//
//        if (age >= 0) {
//            System.out.println("Soon");
//        }
//        else if (age >= 18) {
//            System.out.println("Take beer");
//        }
//        else {
//            System.out.println("wtf is that");
//        }
//
//
//        String day = "Понедельник";
//        switch (day) {
//            case "Понедельник":
//                System.out.println("Monday");
//                break;
//            case "Вторник":
//                System.out.println("Tuesday");
//                break;
//        }
//
//
//        int sum = 0;
//        int start = 1;
//        int end = 10;
//        int step = 1;
//        for (int i = start; i < end; i += step) {
//            sum += i;
//        }
//        System.out.println(sum);
//
//
//        int distance = 1500;
//        int speedByDay = 100;
//        int minAcceptableDistance = 100;
//        int days = 0;
//        while (distance >= minAcceptableDistance) {
//            distance = distance - speedByDay;
//            days += 1;
//        }
//        System.out.println(days);
//
//
//        String stop = "";
//        String stopWord = "stop";
//        Scanner sc = new Scanner(System.in);
//        do {
//            stop = sc.nextLine();
//        } while (!stop.equals(stopWord));
//
//
//        int num = 0;
//        while (true) {
//            System.out.println(num++);
//        }


/*        DZ_0 */

//        Scanner sc = new Scanner(System.in);
//        String stopWord = "stop";
//        int num_1, num_2, result;
//        String operator;
//
//        while (true) {
//            try {
//                System.out.println("Enter num_1");
//                num_1 = sc.nextInt();
//
//                System.out.println("Enter num_2");
//                num_2 = sc.nextInt();
//
//                System.out.println("Enter operator, if you want to stop, write it here, pls)");
//                operator = sc.next();
//
//                switch (operator) {
//                    case "stop":
//                        System.out.println("stopWord is accept");
//                        return;
//                    case "+":
//                        result = num_1 + num_2;
//                        System.out.println(num_1+"+"+num_2+"="+result);
//                        break;
//                    case "-":
//                        result = num_1 - num_2;
//                        System.out.println(num_1+"-"+num_2+"="+result);
//                        break;
//                    case "*":
//                        result = num_1 * num_2;
//                        System.out.println(num_1+"*"+num_2+"="+result);
//                        break;
//                    case "/":
//                        if (num_2 == 0) {
//                            System.out.println("you can't divide by 0");
//                        }
//                        else {
//                            result = num_1 / num_2;
//                            System.out.println(num_1+"/"+num_2+"="+result);
//                        }
//                        break;
//                    default:
//                        System.out.println("Invalid operator");
//                        break;
//                }
//            }
//            catch (InputMismatchException e) {
//                System.out.println("InputMismatchException try again");
//                sc.nextLine();
//            }
//        }


/*        DZ_1 */

//        int start = 1000;
//        int end = 1;
//        int step = -2;
//        for ( int i = start;i > end;i += step) {
//            System.out.println(i);
//        }
//        System.out.println(end);

/*        DZ_2 */

//        try (Scanner sc = new Scanner(System.in)) {
//            int num = 0;
//            int firstSum = 0;
//            int lastSum = 0;
//            int count = 0;
//
//            System.out.println("enter the number: ");
//            num = sc.nextInt();
//            while (num != 0) {
//                count++;
//                if (count <= 3) {
//                    firstSum += num % 10;
//                }
//                else {
//                    lastSum += num % 10;
//                }
//                num /= 10;
//            }
//            if (count != 6) {
//                System.out.println("There are not six digits on the ticket");
//                return;
//            }
//            if (firstSum == lastSum) {
//                System.out.println("The ticket is lucky");
//            }
//            else {
//                System.out.println("The ticket is unlucky");
//            }
//        }
//        catch (InputMismatchException e) {
//            System.out.println("InputMismatchException, mb number > 2147483647");
//        }


/*        DZ_3 */

//        try (Scanner sc = new Scanner(System.in)) {
//
//            int weightGift = sc.nextInt();
//            int weightOrange = sc.nextInt();
//            int weightApple = sc.nextInt();
//            int weightPear = sc.nextInt();
//
//            int count = 0;
//            int remainder = 0;
//
//            for (int i = 0; i <= weightGift / weightOrange; i++) {
//                for (int j = 0; j <= weightGift / weightApple; j++) {
//                    remainder = weightGift - (weightOrange * i + weightApple * j);
//                    if (remainder >= 0 && remainder % weightPear == 0) {
//                        count++;
//                    }
//                }
//            }
//            System.out.println(count);
//
//        }
//        catch (InputMismatchException e) {
//            System.out.println("InputMismatchException");
//        }
//        catch (ArithmeticException e) {
//            System.out.println("ArithmeticException");
//        }

    }
}