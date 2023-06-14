package Theory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Theory2 {
    public void run () {
        List<String> l = new ArrayList<>();
        l.add("hello");
        l.add("world");
        l.forEach(System.out::println);
        Map<String, Integer> m = new HashMap<>();
        m.put("stas", 24);
        m.put("oleg", 10);
        String[] a = {"It is the first message", "It is the second message"};
        Stream<String> lStream = l.stream();
        l = lStream.map(x->x+" test").skip(1).collect(Collectors.toList());
        l.forEach(System.out::println);
    }
}
