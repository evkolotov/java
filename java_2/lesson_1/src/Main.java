public class Main {
//    public static <T> void printer (T[] array) {
//        for (T value : array) {
//            System.out.println(value);
//        }
//    }
    public static void main(String[] args) {
//        Node<Integer> start = new Node<>(5);
//        start.add(2);
//        start.printList();
//        printer(new String[] {"test1", "test2"});
//        printer(new Integer[] {1, 2, 3});
//        Pair<String, Integer> pair = new Pair<>();
//        pair.setFirst("first");
//        pair.setSecond(1);
//        System.out.println(pair.getFirst());
//        System.out.println(pair.getSecond());

        QueueExample<Integer> queueExample = new QueueExample<>(5);
        queueExample.add(4);
        queueExample.add(3);
        queueExample.add(2);
        queueExample.add(1);
        System.out.println(queueExample.remove());
        System.out.println(queueExample.remove());
        System.out.println(queueExample.remove());
        System.out.println(queueExample.remove());
        System.out.println(queueExample.remove());
        System.out.println(queueExample.remove());

    }
}