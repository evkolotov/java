public class Theory1 {
    public void run () throws InterruptedException {
        final int size = 100;
        CommonObject commonObject = new CommonObject();
        MyThread[] myThreads = new MyThread[size];
        for(int i = 0; i < myThreads.length; i++) {
            myThreads[i] = new MyThread("myThread", commonObject);
            myThreads[i].start();
        }
        for(int i = 0; i < myThreads.length; i++) {
            myThreads[i].join();
        }
        System.out.println(
                String.format("Value in common resourse %d", commonObject.counter)
        );
    }
}
