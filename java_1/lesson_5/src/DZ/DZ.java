package DZ;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class DZ {
    public void taskFirst () throws IOException {

        System.out.println("task First, structure set #3453");

        File file = new File("src/DZ/DZ1INPUT.txt");
        Scanner scanner = new Scanner(file);

        int numberOfString = scanner.nextInt();
        scanner.nextLine();

        HashSet<Integer> integerHashSet = new HashSet<>();

        final int[] currentNumber = new int[1];

        HashMap<String, Runnable> commands = new HashMap<>();
        commands.put("ADD", () -> integerHashSet.add(currentNumber[0]));
        commands.put("PRESENT", () -> System.out.println(integerHashSet.contains(currentNumber[0])));
        commands.put("COUNT", () -> System.out.println(integerHashSet.size()));

        for (int i=0; i<numberOfString; i++) {

            String currentLine = scanner.nextLine();

            String [] currentLineParts = currentLine.split(" ");

            String currentCommand = currentLineParts[0];
            currentNumber[0] = 0;

            if (currentLineParts.length > 1) {
                currentNumber[0] = Integer.parseInt(currentLineParts[1]);
            }
            if (commands.containsKey(currentCommand)) {
                commands.get(currentCommand).run();
            }
        }
    }

    public void taskSecond () throws IOException {
        System.out.println("taskSecond Spammer");
        File file = new File("src/DZ/Spammer.txt");
        Scanner scanner = new Scanner(file);

        int numberOfString = scanner.nextInt();
        scanner.nextLine();

        HashMap<String, Integer> submitMap = new HashMap<>();

        for (int i=0; i<numberOfString; i++) {
            String currentName = scanner.nextLine();
            if (submitMap.containsKey(currentName)) {
                int count = submitMap.get(currentName);
                count++;
                submitMap.put(currentName, count);
            } else {
                submitMap.put(currentName, 1);
            }
        }
        for (HashMap.Entry<String, Integer> entry : submitMap.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey());
            }
        }
    }
}
