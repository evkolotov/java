public class User {
    public int balance;
    public String name;
    public User (int balance, String name) {
        this.balance = balance;
        this.name = name;
    }

    public void spendMoney (int cost) throws BalanceException {
        if (balance - cost >= 0) {
            balance -= cost;
        } else {
            throw new BalanceException(String.format("you didn't have enought money, you nee in %d roubles", cost - balance));
        }
    }
}
