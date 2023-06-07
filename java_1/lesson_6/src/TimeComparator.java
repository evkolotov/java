import java.util.Comparator;

public class TimeComparator implements Comparator<Time> {

    @Override
    public int compare(Time o1, Time o2) {
        if (o1.convertToSeconds() > o2.convertToSeconds()) {
            return 1;
        } else if (o1.convertToSeconds() < o2.convertToSeconds()) {
            return -1;
        } else {
            return 0;
        }
    }
}
