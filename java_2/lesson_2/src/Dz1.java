public class Dz1 {
    public void run () throws InterruptedException {

        long startTime = System.currentTimeMillis();
        final int numberOfThreads = 8;
        final int size = 10000000;
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i+1;
        }
        int numberOfElementsInThread = array.length / numberOfThreads;
        NumberSimpleThread[] threads = new NumberSimpleThread[numberOfThreads];
        for (int i = 0; i < numberOfThreads; i++) {
            int start = i * numberOfElementsInThread;
            int end = (i+1) * numberOfElementsInThread - 1;
            threads[i] = new NumberSimpleThread(array, start, end);
            threads[i].start();
        }
        for (int i = 0; i < numberOfThreads; i++) {
            threads[i].join();
        }
        int count = 0;
        for (int i = 0; i < numberOfThreads; i++) {
            count += threads[i].counter;
        }
        System.out.println(String.format("Количество: %d", count));
        long endTime = System.currentTimeMillis();
        System.out.println(String.format("Затраченное время: %d", endTime - startTime));
    }
}
