public class QueueExample<T> {
    private QueueExample next;
    private T value;

    public QueueExample(T value) {
        this.value = value;
    }

    public QueueExample getNext() {
        return next;
    }

    public void setNext(QueueExample next) {
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
    public void add (T value) {
        QueueExample last = new QueueExample<T>(value);
        QueueExample current = this;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(last);
    }
    public T remove() {
        T currentValue = getValue();
        if (currentValue != null) {
            setValue(null);
            if (this.getNext() != null) {
                QueueExample current = this.getNext();
                this.setValue((T) current.getValue());
                this.setNext(current.getNext());
            }
        }
        return currentValue;
    }
}
