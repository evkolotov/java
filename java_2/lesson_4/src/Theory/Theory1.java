package Theory;

import java.util.stream.IntStream;

public class Theory1 {
    public void run () {
        IntStream intStream = IntStream.of(1,15, 5);
        intStream = IntStream.concat(intStream, IntStream.of(6, 16));
        intStream = IntStream.concat(intStream, IntStream.of(6, 16));
        intStream.filter(x->x>1).map(x->x*10).sorted().limit(4).forEach(System.out::println);
    }
}