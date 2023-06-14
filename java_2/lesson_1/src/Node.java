public class Node<T> {
    private Node next = null;
    private T value;
    public Node (T value) {
        this.value = value;
    }
    public Node getNext() {
        return next;
    }
    public void setNext(Node next) {
        this.next = next;
    }
    public T getValue() {
        return value;
    }
    public void setValue(T value) {
        this.value = value;
    }
    public void add (T number) {
        Node<T> last = new Node<T>(number);
        Node<T> current = this;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(last);
    }
    public void printList() {
        Node current = this;
        while (current != null) {
            System.out.println(current.value);
            current = current.getNext();
        }
    }
}
