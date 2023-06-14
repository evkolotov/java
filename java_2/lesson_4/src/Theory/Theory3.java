package Theory;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Theory3 {
    public void run () {
        String[] a = {"It is the first message", "It is the second message"};
//        flatMap:
//        Stream<String> aStream = Arrays.stream(a);
//        aStream
//                .map(s->s.split(" ")).
//                convert all in one stream
//                flatMap(Arrays::stream)
//                .distinct()
//                .forEach(System.out::println);
//        map:
        Stream<String> aStream = Arrays.stream(a);
        aStream
                .map(s->s.split(" ")).
//                convetn all in many arrays
                map(Arrays::stream)
                .distinct()
                .forEach(x->x.forEach(System.out::println));
//        flatMap преобразует набор в единый стрим, в то время как map преобразует в список стримов.

    }
    public void run2 (){
        IntStream intStream = IntStream.of(1,15, 5);
        //OptionalInt optional = intStream.findFirst();
        //System.out.println(optional.isPresent() ? optional.getAsInt() : "nope");
        OptionalInt optional = intStream.reduce((x, y) -> x + y);
        System.out.println(optional.isPresent() ? optional.getAsInt() : "nope");

    }
}
