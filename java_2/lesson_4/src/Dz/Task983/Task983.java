package Dz.Task983;

import Dz.Task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task983 implements Task {
    int numberOfPerson;
    ArrayList<Person> persons;
    @Override
    public void readInputData() {
        numberOfPerson = Integer.parseInt(scanner.nextLine());
        persons = new ArrayList<>();
        for (int i = 0; i< numberOfPerson; i++) {
            Integer[] personValues = Arrays.stream(
                scanner.nextLine().split(" ")
            )
            .map(
                    Integer::parseInt
            )
            .toArray(Integer[]::new);
            Person person = new Person(personValues);
            person.calculateTime();
            persons.add(person);
        }
    }
    @Override
    public void executeTask() {
        readInputData();
        int currentNumberSecondsForEnd = Integer.MIN_VALUE;
        for (Person person : persons.stream().sorted(new PersonComparator()).collect(Collectors.toList())) {
            if (person.getNumberSecondsForEnd() < currentNumberSecondsForEnd) {
                person.setNumberSecondsForEnd(currentNumberSecondsForEnd);
            } else {
                currentNumberSecondsForEnd = person.getNumberSecondsForEnd();
            }
        }
        persons.forEach(System.out::println);
    }
}
