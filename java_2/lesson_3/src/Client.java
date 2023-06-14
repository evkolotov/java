import java.util.concurrent.locks.ReentrantLock;

public class Client extends ReentrantLock {
    public int money;
    public int cardNumber;
    public String name;

    public Client(int money, int cardNumber, String name) {
        this.money = money;
        this.cardNumber = cardNumber;
        this.name = name;
    }
}


