public class DeadlockTask extends Thread {
    private Client clientFrom;
    private Client clientTo;
    private int money;

    public DeadlockTask(String name, Client clientFrom, Client clientTo, int money) {
        super(name);
        this.clientFrom = clientFrom;
        this.clientTo = clientTo;
        this.money = money;
    }

    public void run() {
        while (true) {
            if (clientFrom.tryLock()) {
                if (clientTo.tryLock()) {
                    try {
                        clientFrom.money -= money;
                        clientTo.money += money;
                        System.out.println(
                                String.format(
                                        "Клиент %s перевёл %d рублей клиенту %s",
                                        clientFrom.name,
                                        money,
                                        clientTo.name
                                )
                        );
                    }
                    finally {
                        clientTo.unlock();
                        clientFrom.unlock();
                        break;
                    }
                }
                else {
                    clientFrom.unlock();
                }
            }
        }
    }
}
