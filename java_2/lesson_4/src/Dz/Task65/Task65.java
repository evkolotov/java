package Dz.Task65;

import Dz.Task;
import Dz.Task983.Person;
import Dz.Task983.PersonComparator;

import java.util.*;
import java.util.stream.Collectors;

public class Task65 implements Task {
    int numberOfMessages;
    ArrayList<Message> messages;
    @Override
    public void readInputData() {
        Integer[] messageInitValue = Arrays.stream(
            scanner.nextLine().split("(?<=\\G.{1})")
        )
        .map(
                Integer::parseInt
        )
        .toArray(Integer[]::new);

        numberOfMessages = Integer.parseInt(scanner.nextLine());

        messages = new ArrayList<>();
        for (int i = 0; i< numberOfMessages; i++) {
            Integer[] messageValues = Arrays.stream(
                scanner.nextLine().split("(?<=\\G.{1})")
            )
            .map(
                    Integer::parseInt
            )
            .toArray(Integer[]::new);
            int numberMessage = i+1;
            Message message = new Message(messageValues, messageInitValue, numberMessage);
            message.calculateCoefficientHamming();
            messages.add(message);
        }
    }
    @Override
    public void executeTask() {
        readInputData();
        Map<Integer, List<Message>> map = messages.stream().collect(Collectors.groupingBy(x -> x.getCoefficientHamming()));
        int minCoefficientHamming = map.keySet().stream().limit(1).mapToInt(Integer::intValue).sum();
        System.out.println(minCoefficientHamming);
        map.get(minCoefficientHamming).stream().forEach(x->System.out.print(x + " "));
    }
}
