public class Theory {
    public void run () throws InterruptedException {
        long startTime = System.currentTimeMillis();
        final int numberOfThreads = 8;
        final int size = 10000000;
        int[] array = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            array[i] = i;
        }
        int numberOfElementsInThread = array.length / numberOfThreads;
        FindMaximumThread[] threads = new FindMaximumThread[numberOfThreads];
        for (int i = 0; i < numberOfThreads; i++) {
            int start = i * numberOfElementsInThread;
            int end = (i+1) * numberOfElementsInThread;
            if (end > array.length - 1) {
                end = array.length - 1;
            }
            threads[i] = new FindMaximumThread(array, start, end);
            threads[i].start();
        }
        for (int i = 0; i < numberOfThreads; i++) {
            threads[i].join();
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < numberOfThreads; i++) {
            if (threads[i].max > max) {
                max = threads[i].max;
            }
        }
        System.out.println(String.format("Максимум: %d", max));
        long endTime = System.currentTimeMillis();
        System.out.println(String.format("Затраченное время: %d", endTime - startTime));
    }
}
