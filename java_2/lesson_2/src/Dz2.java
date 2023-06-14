public class Dz2 {
    public void run () throws InterruptedException {

        long startTime = System.currentTimeMillis();
        final int numberOfThreads = 8;
        final int size = 10000;
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i+1;
        }
        int numberOfElementsInThread = array.length / numberOfThreads;
        SumThread[] threads = new SumThread[numberOfThreads];
        for (int i = 0; i < numberOfThreads; i++) {
            int start = i * numberOfElementsInThread;
            int end = (i+1) * numberOfElementsInThread - 1;
            threads[i] = new SumThread(array, start, end);
            threads[i].start();
        }
        for (int i = 0; i < numberOfThreads; i++) {
            threads[i].join();
        }
        int sum = 0;
        for (int i = 0; i < numberOfThreads; i++) {
            sum += threads[i].sum;
        }
        System.out.println(String.format("Сумма: %d", sum));
        long endTime = System.currentTimeMillis();
        System.out.println(String.format("Затраченное время: %d", endTime - startTime));
    }
}
