public class MyThread extends Thread{
    private CommonObject commonObject;
    private final int numberOfRepeating = 100000;
    public MyThread(String name, CommonObject commonObject) {
        super(name);
        this.commonObject = commonObject;
    }
    public void run() {
        synchronized (commonObject) {
            for (int i = 0; i < numberOfRepeating; i++) {
                commonObject.counter++;
            }
        }
    }
}

