public class Main {
    public static void main(String[] args) {

        Cat cat = new Cat();
        Dog dog = new Dog();

        cat.sound();
        cat.hello();

        dog.sound();
        dog.hello();

        PlusAction plusAction = new PlusAction();
        plusAction.action(5,10);

    }
}