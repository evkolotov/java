public class NumberSimpleThread extends Thread {
    private int[] array;
    int start;
    int end;

    public NumberSimpleThread(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    public int counter = 0;
    private boolean isSimplestNumber(int number) {
        int firstSimpleNumber = 2;
        for (int i = number > firstSimpleNumber ? firstSimpleNumber:firstSimpleNumber + 1; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public void run() {
        System.out.println(String.format("Thread start/end number: %d:%d", array[start], array[end]));
        for (int i = start; i <= end; i++) {
            if (isSimplestNumber(array[i]) && array[i] != 1) {
                counter++;
            }
        }
    }
}
