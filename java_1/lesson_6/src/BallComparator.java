import java.util.Comparator;

public class BallComparator implements Comparator<Ball> {
    @Override
    public int compare(Ball o1, Ball o2) {
        if (o1.r > o2.r) {
            return 1;
        } else if (o1.r < o2.r) {
            return -1;
        } else {
            return 0;
        }
    }
}
