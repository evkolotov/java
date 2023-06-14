public class SumThread extends Thread {
    private int[] array;
    int start;
    int end;

    public SumThread(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    public int sum = 0;

    public void run() {
        System.out.println(String.format("Thread started in range: %d:%d", start, end));
        for (int i = start; i <= end; i++) {
            sum += array[i];
        }
    }
}
