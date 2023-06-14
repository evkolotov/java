package Dz.Task983;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {
    @Override
    public int compare(Person person1, Person person2) {
        int initStep1 = person1.getInitStep();
        int initStep2 = person2.getInitStep();
        return Integer.compare(initStep1, initStep2);
    }
}
